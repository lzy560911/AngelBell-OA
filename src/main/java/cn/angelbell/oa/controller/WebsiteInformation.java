package cn.angelbell.oa.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;

import cn.angelbell.oa.entity.User;
import cn.angelbell.oa.entity.Visitnet;
import cn.angelbell.oa.service.access.AccessService;
import cn.angelbell.oa.service.student.StudentService;
import cn.angelbell.oa.service.teacher.TeacherService;
import cn.angelbell.oa.util.AppUtil;
import cn.angelbell.oa.util.Const;
import cn.angelbell.oa.util.IPUtil;
import cn.angelbell.oa.util.Jurisdiction;
import cn.angelbell.oa.util.PageData;

/**
 * 获取访问ip控制器
 * @author liziye
 * @version 2019-12-28
 */

@Controller
@RequestMapping(value = "/websiteInfo")
public class WebsiteInformation extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(WebsiteInformation.class);
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
    private AccessService accessService;
	
	@RequestMapping(value="/getInfo" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object getInfo() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		String errInfo = "";
		String msg = "";
		
		PageData pd = new PageData();
		pd = this.getPageData();
		String username = pd.getString("username");
		String password = pd.getString("password");
		System.out.println(username+":"+password);
		
		map.put("result", errInfo);
		map.put("msg", msg);
		return AppUtil.returnObject(new PageData(), map);
	}
}
