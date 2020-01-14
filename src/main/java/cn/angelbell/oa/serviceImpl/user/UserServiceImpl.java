package cn.angelbell.oa.serviceImpl.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.User;
import cn.angelbell.oa.mapper.user.UserMapper;
import cn.angelbell.oa.service.user.UserService;
import cn.angelbell.oa.util.Md5Util;

/**
 * 
 * @ClassName: UserServiceImpl
 * @Description: 用户类型业务逻辑处理
 * @author liziye
 * @date 2019.07.04
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class UserServiceImpl implements UserService{
	
	// 数据访问
    @Autowired
    private UserMapper userDao;

	@Override
	public PageInfo<User> getUsersTypeList(Integer pageNum, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		//默认每页15条信息
		List<User> list = new ArrayList<User>();
		PageHelper.startPage(pageNum,pageSize);
		list = userDao.getList();
		PageInfo<User> userDaoPageInfo = new PageInfo<User>(list);
		return userDaoPageInfo;
	}

	@Override
	public User selectByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("this is the user impl !");
		return userDao.selectByUserName(userName);
	}

	@Override
	public int saveUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String pass = user.getPassword();
		String salt = user.getSalt();
		salt = Md5Util.StringInMd5(salt);
		String MD5Pass = new Md5Hash(pass,salt,1).toString(); //生成的密文
		user.setPassword(MD5Pass);
		user.setSalt(salt);
		return userDao.insert(user);
	}

}
