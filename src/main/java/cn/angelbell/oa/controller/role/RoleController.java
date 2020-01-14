package cn.angelbell.oa.controller.role;


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
 * 角色控制器.
 * @author liziye
 * @version 2019-11-23
 */

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController{
	

}
