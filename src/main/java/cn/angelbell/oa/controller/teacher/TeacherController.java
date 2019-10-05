package cn.angelbell.oa.controller.teacher;


import java.util.HashMap;
import java.util.List;
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
import cn.angelbell.oa.entity.Teacher;
import cn.angelbell.oa.entity.TeacherExample;
import cn.angelbell.oa.service.teacher.TeacherService;
import cn.angelbell.oa.util.PageData;
import cn.angelbell.oa.util.Tools;


/**
 * 教师控制器.
 * @author liziye
 * @version 2019-07-16
 */

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController extends BaseController{
	
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 获取全部教师信息.
	 * Integer pageNum, Integer pageSize
	 */
	@RequestMapping(value="/list")
	public ModelAndView teacherList(Integer pageNum, Integer pageSize) throws Exception{
		logBefore(logger, "获取全部教师信息");
		//默认每页15条信息
		if(pageSize == null){
			pageSize = 15;
		}
		PageInfo<Teacher> pageInfoTeacher = teacherService.getTeacherTypeList(pageNum,pageSize);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/teacherList");
		mv.addObject("pageInfo", pageInfoTeacher);
		return mv;
	}
	
	/**
	 * 添加教师信息.
	 */
	@RequestMapping(value="/add")  
    public ModelAndView addTeacher() throws Exception{
		logBefore(logger, "添加教师信息");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("teacher/addTeacher");
		return mv;
    }
	
	/**
	 * 删除教师信息.
	 * Integer teacherID 教师ID
	 */
	@RequestMapping(value="/delTeacherInfo",method = RequestMethod.GET ,produces="application/json;charset=UTF-8,text/html;charset=UTF-8")
	@ResponseBody
	public JSONPObject delTeacherInfo(HttpSession session, HttpServletRequest request,@RequestParam String callback,@RequestParam Integer teacherID) throws Exception{
		logBefore(logger, "删除指定教师信息");
		System.out.println("teacherID is -->"+teacherID);
		Map<String, Object> map = new HashMap<String, Object>();
		String code = "";
		String Msg = "";
		if(teacherID == null){
			code = "00";
			Msg = "请选择需要删除的信息!";
		}else{
			if(teacherService.deleteByPrimaryKey(teacherID)){
				code = "01";
				Msg = "删除成功!";
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
			@RequestParam String teacherName,
			@RequestParam String start,
			@RequestParam String end) throws Exception{
		logBefore(logger, "按条件查询教师信息");
		logBefore(logger, "教师姓名"+teacherName);
		//获取表单中提交的参数
		if(pageNum == null){
			pageNum = 1;
		}
		if(pageSize == null){
			pageSize = 15;
		}
		TeacherExample teacherExample = new TeacherExample();
		if(StringUtils.isNotBlank(teacherName)){
			logBefore(logger, "教师名称是："+teacherName);
			teacherExample.createCriteria().andRealnameLike('%'+teacherName+'%');
	    }
		if(StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)){
			logBefore(logger, "时间范围是："+start+"---"+end);
			teacherExample.createCriteria().andIntimeBetween(Tools.str2Date(start), Tools.str2Date(end));
	    }
		PageInfo<Teacher> pageInfoTeacher = teacherService.selectByExample(pageNum,pageSize,teacherExample);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher/exampleTeacherList");
		mv.addObject("pageInfo", pageInfoTeacher);
		return mv;
	}
}
