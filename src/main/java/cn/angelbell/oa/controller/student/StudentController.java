package cn.angelbell.oa.controller.student;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.controller.BaseController;
import cn.angelbell.oa.entity.Student;
import cn.angelbell.oa.entity.StudentExample;
import cn.angelbell.oa.service.student.StudentService;
import cn.angelbell.oa.util.Tools;


/**
 * 教师控制器.
 * @author liziye
 * @version 2019-07-16
 */

@Controller
@RequestMapping(value = "/student")
public class StudentController extends BaseController{
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * 获取全部学生信息.
	 * Integer pageNum, Integer pageSize
	 */
	@RequestMapping(value="/list")
	public ModelAndView studentList(Integer pageNum, Integer pageSize) throws Exception{
		logBefore(logger, "获取全部学生信息");
		//默认每页15条信息
		if(pageSize == null){
			pageSize = 15;
		}
		PageInfo<Student> pageInfoStudent = studentService.getStudentTypeList(pageNum,pageSize);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("student/studentList");
		mv.addObject("pageInfo", pageInfoStudent);
		return mv;
	}
	
	/**
	 * 添加教师信息.
	 */
	@RequestMapping(value="/add")  
    public ModelAndView addStudent() throws Exception{
		logBefore(logger, "添加学生信息");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/addStudent");
		return mv;
    }
	
	/**
	 * 删除教师信息.
	 * Integer teacherID 教师ID
	 */
	@RequestMapping(value="/delStudentInfo",method = RequestMethod.GET ,produces="application/json;charset=UTF-8,text/html;charset=UTF-8")
	@ResponseBody
	public JSONPObject delStudentInfo(HttpSession session, HttpServletRequest request,@RequestParam String callback,@RequestParam Integer studentID) throws Exception{
		logBefore(logger, "删除指定学生信息");
		System.out.println("studentID is -->"+studentID);
		Map<String, Object> map = new HashMap<String, Object>();
		String code = "";
		String Msg = "";
		if(studentID == null){
			code = "00";
			Msg = "请选择需要删除的信息!";
		}else{
			if(studentService.deleteByPrimaryKey(studentID)){
				code = "01";
				Msg = "删除成功!";
			}else{
				code = "02";
				Msg = "删除失败!";
			}
		}
		map.put("code", code);
		map.put("msg", Msg);
		return new JSONPObject(callback, map);
	}
	
	/**
	 * 按条件查询教师信息
	 * Integer teacherID 教师ID
	 */
	@RequestMapping(value="/selectByExample")
	public ModelAndView selectTeacherInfo(HttpSession session, 
			HttpServletRequest request , 
			Integer pageNum, 
			Integer pageSize, 
			@RequestParam String studentName,
			@RequestParam String start,
			@RequestParam String end) throws Exception{
		logBefore(logger, "按条件查询学生信息");
		logBefore(logger, "学生姓名"+studentName);
		//获取表单中提交的参数
		if(pageNum == null){
			pageNum = 1;
		}
		if(pageSize == null){
			pageSize = 15;
		}
		StudentExample example = new StudentExample();
		if(StringUtils.isNotBlank(studentName)){
			logBefore(logger, "学生名称是："+studentName);
			example.createCriteria().andNameLike('%'+studentName+'%');
	    }
		if(StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)){
			logBefore(logger, "时间范围是："+start+"---"+end);
			example.createCriteria().andIntimeBetween(Tools.str2Date(start), Tools.str2Date(end));
	    }
		PageInfo<Student> pageInfoStudent = studentService.selectByExample(pageNum,pageSize,example);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("student/exampleStudentList");
		mv.addObject("pageInfo", pageInfoStudent);
		return mv;
	}
}
