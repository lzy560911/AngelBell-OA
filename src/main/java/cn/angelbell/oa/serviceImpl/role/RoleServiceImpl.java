package cn.angelbell.oa.serviceImpl.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.angelbell.oa.entity.Role;
import cn.angelbell.oa.mapper.role.RoleMapper;
import cn.angelbell.oa.service.role.RoleService;

/**
 * 
 * @ClassName: RoleServiceImpl
 * @Description: 角色类型业务逻辑处理
 * @author liziye
 * @date 2019.07.04
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class RoleServiceImpl implements RoleService{
	// 数据访问
    @Autowired
    private RoleMapper roleDao;

	@Override
	public List<Role> selectByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		List<Role> role = roleDao.selectByUserName(userName);
		return role;
	}

}
