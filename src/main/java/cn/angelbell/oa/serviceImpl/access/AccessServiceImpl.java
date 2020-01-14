package cn.angelbell.oa.serviceImpl.access;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.angelbell.oa.entity.Visitnet;
import cn.angelbell.oa.mapper.access.VisitnetMapper;
import cn.angelbell.oa.service.access.AccessService;


/**
 * 
 * @ClassName: CommentServiceImpl
 * @Description: 访问日志业务逻辑处理
 * @author liziye
 * @date 2019.07.15
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class AccessServiceImpl implements AccessService{
	
	@Autowired
	private VisitnetMapper visitnetMapper;

	@Override
	public int insert(Visitnet record) {
		// TODO Auto-generated method stub
		visitnetMapper.insert(record);
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getVisitorMap() {
		// TODO Auto-generated method stub
		return visitnetMapper.getVisitorMap();
	}

}
