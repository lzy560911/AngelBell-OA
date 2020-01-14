package cn.angelbell.oa.service.access;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import cn.angelbell.oa.entity.Visitnet;

/**
 * 
 * @ClassName: AccessService
 * @Description: 访问日志业务逻辑接口
 * @author liziye
 * @date 2020.01.07
 */
@Service
public interface AccessService {
	
	/**
     * @Title: insert
     * @Description: 插入访问量信息
     * @throws Exception
     */
	int insert(Visitnet record);
	
	/**
     * @Title: List
     * @Description: 获取热力图信息
     * @throws Exception
     */
	List<HashMap<String, Object>> getVisitorMap();
    
}
