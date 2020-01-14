package cn.angelbell.oa.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import cn.angelbell.oa.entity.User;
import cn.angelbell.oa.service.user.UserService;
import cn.angelbell.oa.util.AppUtil;
import cn.angelbell.oa.util.Const;
import cn.angelbell.oa.util.PageData;

/**
 * 用户控制器.
 * 1.获取全部用户信息
 * @author liziye
 * @version 2019-07-16
 */

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取全部用户信息.
	 */
	@RequestMapping(value="/list")  
    public ModelAndView userLogin(Integer pageNum, Integer pageSize) throws Exception{
		System.out.println("this is the user list");
		logBefore(logger, "获取全部用户信息");
		if(pageSize == null){
			pageSize = 15;
		}
		PageInfo<User> pageInfoUser = userService.getUsersTypeList(pageNum,pageSize);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userList");
		mv.addObject("pageInfo", pageInfoUser);
		return mv;
    }
	
	/**
	 * 跳转添加用户页面.
	 */
	@RequestMapping(value="/add")  
    public ModelAndView addUser() throws Exception{
		logBefore(logger, "添加用户");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/addUser");
		return mv;
    }
	
	/**
	 * 添加用户信息
	 * @throws Exception
	 */
	@RequestMapping(value="/doAdd" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object doAdd() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		logBefore(logger, "添加用户信息");
		
		String errInfo = "";
		String msg = "";
		
		Date date=new Date();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		User user = new User();
		user.setUsername(pd.getString("username"));
		user.setRealname(pd.getString("realname"));
		user.setPassword(pd.getString("pass"));
		user.setSalt(pd.getString("username"));
		user.setAvatar("D://images");
		user.setPhone(pd.getString("tel"));
		user.setEmail(pd.getString("email"));
		user.setLocked((byte) 0);
		user.setSex((byte) pd.getInt("sex"));
		user.setCtime(date);
		try {
			userService.saveUser(user);
			errInfo = "01";
			msg = "添加成功";
		} catch (Exception e) {
			// TODO: handle exception
			errInfo = "00";
			msg = "添加失败";
			e.printStackTrace();
		}
		map.put("result", errInfo);
		map.put("msg", msg);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 获取页面用户姓名
	 */
	@RequestMapping(value="/getUserName",method = RequestMethod.GET ,produces="application/json;charset=UTF-8,text/html;charset=UTF-8")
	@ResponseBody
	public JSONPObject getUserName(HttpSession session, HttpServletRequest request,@RequestParam String callback) throws Exception{
		logBefore(logger, "获取当前登录用户名");
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)session.getAttribute(Const.SESSION_USER);
		String userName = user.getUsername();
		map.put("userName", userName);
		return new JSONPObject(callback, map);
	}
}
