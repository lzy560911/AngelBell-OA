package cn.angelbell.oa.service.role;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.angelbell.oa.entity.Role;


/**
 * 
 * @ClassName: RoleService
 * @Description: 角色业务逻辑接口
 * @author liziye
 * @date 2019.09.16
 */
@Service
public interface RoleService {
	
	/**
     * 
     * @Title: selectByUserName
     * @Description: 多表查询，通过登录账号查询该账户所拥有的角色
     * @return
     * @throws Exception
     */
	List<Role> selectByUserName(String userName) throws Exception;

}
