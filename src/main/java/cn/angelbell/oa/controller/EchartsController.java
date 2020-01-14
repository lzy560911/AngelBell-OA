package cn.angelbell.oa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.util.JSONPObject;

import cn.angelbell.oa.service.access.AccessService;


/**
 * 
 * @author 管理员
 *
 */
@Controller
@RequestMapping(value = "/echarts")
public class EchartsController extends BaseController{
	
	@Autowired
    private AccessService accessService;
	
	/**
	 * 跳转到访问量热力图
	 */
	@RequestMapping(value="/visitorMap")
	public ModelAndView visitorMap() throws Exception{
		logBefore(logger, "跳转至访问量热力图");
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("echarts/visitorMap");
		return mv;
	}
	
	/**
	 * 获取热力图数据信息
	 */
	@RequestMapping(value="/getVisitorMap",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
	@ResponseBody
	public JSONPObject getVisitorMap(@RequestParam String callback) throws Exception{
		logBefore(logger, "获取热力图数据信息");
		List<HashMap<String, Object>> list = accessService.getVisitorMap();
		String replaceKeyName = "locationLat";
		for(int i = 0; i < list.size();i++){
			for (String key : list.get(i).keySet()) {
				if(key.equals(replaceKeyName)){
					String locationLat = (String) list.get(i).get(key);
					list.get(i).put(key, locationLat.replace("x:","").replace("-y:", ","));
				}
				System.out.println("key:" + key + ",value:" + list.get(i).get(key));
		    }
			System.out.println("\n");
		}
		return new JSONPObject(callback, list);
	}
}
