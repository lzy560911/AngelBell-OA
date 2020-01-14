package cn.angelbell.oa.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maxmind.geoip2.DatabaseReader;

import cn.angelbell.oa.entity.Visitnet;
import cn.angelbell.oa.service.access.AccessService;

/**
 * 
 * @description: 获取客户端IP地址
 * @author: paulandcode
 * @email: paulandcode@gmail.com
 * @since: 2018年9月17日 下午3:44:51
 */
@Controller
@RequestMapping(value = "/access")
public class AccessLog {
    private static Logger logger = LoggerFactory.getLogger(AccessLog.class);
    @Autowired
    private AccessService accessService;
    
    /**
     * 
     * @description: 获得国家 
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static String getCountry(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getCountry().getNames().get("zh-CN");
    }

    /**
     * 
     * @description: 获得省份 
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static String getProvince(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getMostSpecificSubdivision().getNames().get("zh-CN");
    }

    /**
     * 
     * @description: 获得城市 
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static String getCity(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getCity().getNames().get("zh-CN");
    }
    
    /**
     * 
     * @description: 获得经度 
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static Double getLongitude(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getLocation().getLongitude();
    }
    
    /**
     * 
     * @description: 获得纬度
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static Double getLatitude(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getLocation().getLatitude();
    }
    
    
    /**
     * 
     * @description: 添加用户访问日志
     * @param ip IP地址
     * @param address 详细地址
     * @param province 省份
     * @param city 城市
     * @param x 经度
     * @param y 维度
     * @return
     * @throws Exception
     */
    @RequestMapping("/log")
    @ResponseBody
    public void visitNet5(String ip,
    		String address, 
    		String province, 
    		String city, 
    		String x, 
    		String y, 
    		HttpServletRequest request 
    		) throws IOException {
    	
        int port = request.getRemotePort();  // TCP/IP端口
        String agent = request.getHeader("user-agent"); //浏览器信息
        String locationLat = "x:"+x+"-y:"+y;
        Date date = new Date(); //访问时间
        Visitnet net = new Visitnet();
        net.setProvince(province);
        net.setCity(city);
        net.setAddresses(address);
        net.setLocationlat(locationLat);
        net.setIp(ip);
        net.setPort(port+"");
        net.setAgent(agent);
        net.setCreatetime(date);
        accessService.insert(net);
        System.out.println(port+agent);
    }
    
    /*public static void main(String[] args) throws Exception {
    	// String path = req.getSession().getServletContext().getRealPath("/WEB-INF/classes/GeoLite2-City.mmdb");
    	String path = "D:/CSDN/GeoLite2-City.mmdb";
    	// 创建 GeoLite2 数据库
    	File database = new File(path);
    	// 读取数据库内容
    	DatabaseReader reader = new DatabaseReader.Builder(database).build();
    	// 访问IP
    	String ip = "222.222.226.212";
    	String site = "国家："+AccessLog.getCountry(reader, ip) + "\n省份：" + AccessLog.getProvince(reader, ip) + "\n城市：" + AccessLog.getCity(reader, ip)+ "\n经度：" + AccessLog.getLongitude(reader, ip)+ "\n维度：" + AccessLog.getLatitude(reader, ip);
    	
    	System.out.println(site);
	}*/
}
