package cn.angelbell.oa.serviceImpl.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.angelbell.oa.entity.Permission;
import cn.angelbell.oa.mapper.role.PermissionMapper;
import cn.angelbell.oa.service.role.PermissionService;

/**
 * 
 * @ClassName: RoleServiceImpl
 * @Description: 角色类型业务逻辑处理
 * @author liziye
 * @date 2019.07.04
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class PermissionServiceImpl implements PermissionService{
	
	// 数据访问
    @Autowired
    private PermissionMapper permissionDao;

	@Override
	public List<Permission> getPermissionsByUserName(String userName) {
		// TODO Auto-generated method stub
		List<Permission> permissionsList =  permissionDao.selectByUserName(userName);
		return permissionsList;
	}

}
