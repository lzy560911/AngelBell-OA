package cn.angelbell.oa.controller.parent;


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
import cn.angelbell.oa.entity.Parent;
import cn.angelbell.oa.entity.ParentExample;
import cn.angelbell.oa.service.parent.ParentService;


/**
 * 家长控制器.
 * @author liziye
 * @version 2019-07-16
 */

@Controller
@RequestMapping(value = "/parent")
public class ParentController extends BaseController{
	
	@Autowired
	private ParentService parentService;
	
	/**
	 * 获取全部家长信息.
	 * Integer pageNum, Integer pageSize
	 */
	@RequestMapping(value="/list")
	public ModelAndView parentList(Integer pageNum, Integer pageSize) throws Exception{
		logBefore(logger, "获取全部家长信息");
		//默认每页15条信息
		if(pageSize == null){
			pageSize = 15;
		}
		PageInfo<Parent> pageInfoParent = parentService.getParentTypeList(pageNum,pageSize);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("parent/parentList");
		mv.addObject("pageInfo", pageInfoParent);
		return mv;
	}
	
	/**
	 * 添加家长信息.
	 */
	@RequestMapping(value="/add")  
    public ModelAndView addParent() throws Exception{
		logBefore(logger, "添加家长信息");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parent/addParent");
		return mv;
    }
	
	/**
	 * 删除教师信息.
	 * Integer teacherID 教师ID
	 */
	@RequestMapping(value="/delParentInfo",method = RequestMethod.GET ,produces="application/json;charset=UTF-8,text/html;charset=UTF-8")
	@ResponseBody
	public JSONPObject delParentInfo(HttpSession session, HttpServletRequest request,@RequestParam String callback,@RequestParam Integer parentID) throws Exception{
		logBefore(logger, "删除指定家长信息");
		System.out.println("studentID is -->"+parentID);
		Map<String, Object> map = new HashMap<String, Object>();
		String code = "";
		String Msg = "";
		if(parentID == null){
			code = "00";
			Msg = "请选择需要删除的信息!";
		}else{
			if(parentService.deleteByPrimaryKey(parentID)){
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
	 * 按条件查询家长信息
	 * Integer parentID 家长ID
	 */
	@RequestMapping(value="/selectByExample")
	public ModelAndView selectParentInfo(HttpSession session, 
			HttpServletRequest request , 
			Integer pageNum, 
			Integer pageSize, 
			@RequestParam String parentName,
			@RequestParam String start,
			@RequestParam String end) throws Exception{
		logBefore(logger, "按条件查询家长信息");
		logBefore(logger, "家长姓名"+parentName);
		//获取表单中提交的参数
		if(pageNum == null){
			pageNum = 1;
		}
		if(pageSize == null){
			pageSize = 15;
		}
		ParentExample example = new ParentExample();
		if(StringUtils.isNotBlank(parentName)){
			logBefore(logger, "家长姓名是："+parentName);
			example.createCriteria().andNameLike('%'+parentName+'%');
	    }
		PageInfo<Parent> pageInfoParent = parentService.selectByExample(pageNum,pageSize,example);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("parent/exampleParentList");
		mv.addObject("pageInfo", pageInfoParent);
		return mv;
	}
}
