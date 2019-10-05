package cn.angelbell.oa.service.role;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.angelbell.oa.entity.Permission;

/**
 * 
 * @ClassName: PermissionService
 * @Description: 权限业务逻辑接口
 * @author liziye
 * @date 2019.09.16
 */
@Service
public interface PermissionService {
	/**
     * 
     * @Title: selectByUserName
     * @Description: 多表查询，通过登录账号查询该账户所拥有的权限
     * @return
     * @throws Exception
     */
	List<Permission> getPermissionsByUserName(String userName);
}
