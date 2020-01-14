package cn.angelbell.oa.controller.comment;


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
import cn.angelbell.oa.entity.Comment;
import cn.angelbell.oa.entity.CommentExample;
import cn.angelbell.oa.service.comment.CommentService;
import cn.angelbell.oa.util.Tools;


/**
 * 教师控制器.
 * @author liziye
 * @version 2019-07-16
 */

@Controller
@RequestMapping(value = "/comment")
public class CommentController extends BaseController{
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * 获取全部评论信息.
	 * Integer pageNum, Integer pageSize
	 */
	@RequestMapping(value="/list")
	public ModelAndView commentList(Integer pageNum, Integer pageSize) throws Exception{
		logBefore(logger, "获取全部评论信息");
		//默认每页15条信息
		if(pageSize == null){
			pageSize = 15;
		}
		PageInfo<Comment> pageInfoComment = commentService.getCommentList(pageNum,pageSize);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("comment/commentList");
		mv.addObject("pageInfo", pageInfoComment);
		return mv;
	}
	
	/**
	 * 添加教师信息.
	 */
	@RequestMapping(value="/add")  
    public ModelAndView addComment() throws Exception{
		logBefore(logger, "添加评论");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("comment/addComment");
		return mv;
    }
	
	/**
	 * 删除教师信息.
	 * Integer teacherID 教师ID
	 */
	@RequestMapping(value="/delCommentInfo",method = RequestMethod.GET ,produces="application/json;charset=UTF-8,text/html;charset=UTF-8")
	@ResponseBody
	public JSONPObject delCommentInfo(HttpSession session, HttpServletRequest request,@RequestParam String callback,@RequestParam Integer commentID) throws Exception{
		logBefore(logger, "删除指定评论信息");
		System.out.println("studentID is -->"+commentID);
		Map<String, Object> map = new HashMap<String, Object>();
		String code = "";
		String Msg = "";
		if(commentID == null){
			code = "00";
			Msg = "请选择需要删除的信息!";
		}else{
			if(commentService.deleteByPrimaryKey(commentID)){
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
	 * 按条件查询评论信息
	 * Integer commentator 评论人
	 */
	@RequestMapping(value="/selectByExample")
	public ModelAndView selectCommentInfo(HttpSession session, 
			HttpServletRequest request , 
			Integer pageNum, 
			Integer pageSize, 
			@RequestParam String commentator,
			@RequestParam String start,
			@RequestParam String end) throws Exception{
		logBefore(logger, "按条件查询评论信息");
		logBefore(logger, "评论人"+commentator);
		//获取表单中提交的参数
		if(pageNum == null){
			pageNum = 1;
		}
		if(pageSize == null){
			pageSize = 15;
		}
		CommentExample example = new CommentExample();
		if(StringUtils.isNotBlank(commentator)){
			logBefore(logger, "教师名称是："+commentator);
			example.createCriteria().andCommentatorLike('%'+commentator+'%');
	    }
		if(StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)){
			logBefore(logger, "时间范围是："+start+"---"+end);
			example.createCriteria().andIntimeBetween(Tools.str2Date(start), Tools.str2Date(end));
	    }
		PageInfo<Comment> pageInfoComment = commentService.selectByExample(pageNum,pageSize,example);
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("comment/exampleCommentList");
		mv.addObject("pageInfo", pageInfoComment);
		return mv;
	}
}
