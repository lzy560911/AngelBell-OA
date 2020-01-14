package cn.angelbell.oa.serviceImpl.parent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Parent;
import cn.angelbell.oa.entity.ParentExample;
import cn.angelbell.oa.mapper.parent.ParentMapper;
import cn.angelbell.oa.service.parent.ParentService;

/**
 * 
 * @ClassName: ParentServiceImpl
 * @Description: 家长类型业务逻辑处理
 * @author liziye
 * @date 2019.07.15
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class ParentServiceImpl implements ParentService{
	
	@Autowired
	private ParentMapper parentMapper;

	@Override
	public PageInfo<Parent> getParentTypeList(Integer pageNum, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<Parent> list = new ArrayList<Parent>();
		PageHelper.startPage(pageNum,pageSize);
		list = parentMapper.getList();
		PageInfo<Parent> parentPageInfo = new PageInfo<Parent>(list);
		return parentPageInfo;
	}

	@Override
	public Parent selectByUserName(String realName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByPrimaryKey(Integer studentID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Parent> selectByExample(Integer pageNum, Integer pageSize, ParentExample example)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
