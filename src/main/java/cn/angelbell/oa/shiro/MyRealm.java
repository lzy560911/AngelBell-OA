package cn.angelbell.oa.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.angelbell.oa.entity.Permission;
import cn.angelbell.oa.entity.Role;
import cn.angelbell.oa.entity.User;
import cn.angelbell.oa.service.role.PermissionService;
import cn.angelbell.oa.service.role.RoleService;
import cn.angelbell.oa.service.user.UserService;

/**
 * 
 * @ClassName: MyRealm
 * @Description: 自定义realm
 * @author cheng
 * @date 2017年10月9日 上午10:54:00
 */
public class MyRealm extends AuthorizingRealm {
	
	@Resource
    private UserService userService;
	
	@Resource
    private RoleService roleService;
	
	@Resource
    private PermissionService permissionService;

    /**
     * 用于认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("使用了自定义的realm,用户认证...");
        System.out.println("用户名:" + ((UsernamePasswordToken) token).getUsername());
        System.out.println("密码:" + new String(((UsernamePasswordToken) token).getPassword()));

        // 获取用户名
        String userName = (String) token.getPrincipal();
        User userInfo = null;
        try {
            userInfo = userService.selectByUserName(userName);
           
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(userInfo != null){
			String password = userInfo.getPassword();
	        ByteSource salt = ByteSource.Util.bytes(userInfo.getSalt());
	        System.out.println(password+":"+salt);
	        // 与UsernamePasswordToken(userName, password)进行比较
	        // 区别UsernamePasswordToken(userName, password)中的password是用户输入的密码，即没有加密过的密码
	        // SimpleAuthenticationInfo(userName, password, ByteSource.Util.bytes(salt), this.getName())中的password是数据库中的密码，即加密过后的密码
	        return new SimpleAuthenticationInfo(userName, password, salt, this.getName());
		}
		return null;
    }

    /**
     * 用于授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("使用了自定义的realm,用户授权...");
        String userName=(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<String>();
        List<Role> rolesByUserName = null;
		try {
			rolesByUserName = roleService.selectByUserName(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(Role role:rolesByUserName) {
            roles.add(role.getName());
        }
        List<Permission> permissionsByUserName = permissionService.getPermissionsByUserName(userName);
        for(Permission permission:permissionsByUserName) {
            info.addStringPermission(permission.getName());
        }
        info.setRoles(roles);
        return info;
    }

}