package cn.angelbell.oa.serviceImpl.teacher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Teacher;
import cn.angelbell.oa.entity.TeacherExample;
import cn.angelbell.oa.mapper.teacher.TeacherMapper;
import cn.angelbell.oa.service.teacher.TeacherService;

/**
 * 
 * @ClassName: TeacherServiceImpl
 * @Description: 教师类型业务逻辑处理
 * @author liziye
 * @date 2019.07.15
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public PageInfo<Teacher> getTeacherTypeList(Integer pageNum, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> list = new ArrayList<Teacher>();
		PageHelper.startPage(pageNum,pageSize);
		list = teacherMapper.getList();
		PageInfo<Teacher> TeacherPageInfo = new PageInfo<Teacher>(list);
		return TeacherPageInfo;
	}

	@Override
	public Teacher selectByUserName(String realName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByPrimaryKey(Integer teacherID) throws Exception {
		// TODO Auto-generated method stub
		int delCode = teacherMapper.deleteByPrimaryKey(teacherID);
		System.out.println("code is --->"+delCode);
		if(delCode == 0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public PageInfo<Teacher> selectByExample(Integer pageNum, Integer pageSize,TeacherExample example) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> list = new ArrayList<Teacher>();
		PageHelper.startPage(pageNum,pageSize);
		list = teacherMapper.selectByExample(example);
		PageInfo<Teacher> TeacherPageInfo = new PageInfo<Teacher>(list);
		return TeacherPageInfo;
	}
}
