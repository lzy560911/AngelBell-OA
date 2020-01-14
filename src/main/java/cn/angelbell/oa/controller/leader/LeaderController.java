package cn.angelbell.oa.controller.leader;


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
import cn.angelbell.oa.entity.Leader;
import cn.angelbell.oa.entity.LeaderExample;
import cn.angelbell.oa.service.leader.LeaderService;
import cn.angelbell.oa.util.Tools;


/**
 * 教师控制器.
 * @author liziye
 * @version 2019-07-16
 */

@Controller
@RequestMapping(value = "/leader")
public class LeaderController extends BaseController{
	
	@Autowired
	private LeaderService leaderService;
	
	/**
	 * 获取全部领导信息.
	 * Integer pageNum, Integer pageSize
	 */
	@RequestMapping(value="/list")
	public ModelAndView teacherList(Integer pageNum, Integer pageSize) throws Exception{
		logBefore(logger, "获取全部领导信息");
		//默认每页15条信息
		if(pageSize == null){
			pageSize = 15;
		}
		PageInfo<Leader> pageInfoLeader = leaderService.getLeaderTypeList(pageNum,pageSize);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("leader/leaderList");
		mv.addObject("pageInfo", pageInfoLeader);
		return mv;
	}
	
	/**
	 * 添加领导信息.
	 */
	@RequestMapping(value="/add")  
    public ModelAndView addTeacher() throws Exception{
		logBefore(logger, "添加领导信息");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("leader/addTeacher");
		return mv;
    }
	
	/**
	 * 删除领导信息.
	 * Integer leaderID 领导ID
	 */
	@RequestMapping(value="/delLeaderInfo",method = RequestMethod.GET ,produces="application/json;charset=UTF-8,text/html;charset=UTF-8")
	@ResponseBody
	public JSONPObject delLeaderInfo(HttpSession session, HttpServletRequest request,@RequestParam String callback,@RequestParam Integer leaderID) throws Exception{
		logBefore(logger, "删除指定教师信息");
		System.out.println("teacherID is -->"+leaderID);
		Map<String, Object> map = new HashMap<String, Object>();
		String code = "";
		String Msg = "";
		if(leaderID == null){
			code = "00";
			Msg = "请选择需要删除的信息!";
		}else{
			if(leaderService.deleteByPrimaryKey(leaderID)){
				code = "01";
				Msg = "删除成功!";
			}
		}
		map.put("code", code);
		map.put("msg", Msg);
		return new JSONPObject(callback, map);
	}
	
	/**
	 * 按条件查询领导信息
	 * String leaderName 领导姓名
	 * String start 入职开始时间
	 * String end 入职结束时间
	 * 
	 */
	@RequestMapping(value="/selectByExample")
	public ModelAndView selectTeacherInfo(HttpSession session, 
			HttpServletRequest request , 
			Integer pageNum, 
			Integer pageSize, 
			@RequestParam String leaderName,
			@RequestParam String start,
			@RequestParam String end) throws Exception{
		logBefore(logger, "按条件查询领导信息");
		logBefore(logger, "领导姓名"+leaderName);
		//获取表单中提交的参数
		if(pageNum == null){
			pageNum = 1;
		}
		if(pageSize == null){
			pageSize = 15;
		}
		LeaderExample leaderExample = new LeaderExample();
		if(StringUtils.isNotBlank(leaderName)){
			logBefore(logger, "领导名称是："+leaderName);
			leaderExample.createCriteria().andNameLike('%'+leaderName+'%');
	    }
		if(StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)){
			logBefore(logger, "时间范围是："+start+"---"+end);
			leaderExample.createCriteria().andIntimeBetween(Tools.str2Date(start), Tools.str2Date(end));
	    }
		PageInfo<Leader> pageInfoLeader = leaderService.selectByExample(pageNum,pageSize,leaderExample);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("leader/exampleLeaderList");
		mv.addObject("pageInfo", pageInfoLeader);
		return mv;
	}
}
