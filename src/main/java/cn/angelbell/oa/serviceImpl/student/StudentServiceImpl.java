package cn.angelbell.oa.serviceImpl.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Student;
import cn.angelbell.oa.entity.StudentExample;
import cn.angelbell.oa.mapper.student.StudentMapper;
import cn.angelbell.oa.service.student.StudentService;

/**
 * 
 * @ClassName: StudentServiceImpl
 * @Description: 学生类型业务逻辑处理
 * @author liziye
 * @date 2019.07.15
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public PageInfo<Student> getStudentTypeList(Integer pageNum, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		PageHelper.startPage(pageNum,pageSize);
		list = studentMapper.getList();
		PageInfo<Student> studentPageInfo = new PageInfo<Student>(list);
		return studentPageInfo;
	}

	@Override
	public Student selectByUserName(String realName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByPrimaryKey(Integer studentID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Student> selectByExample(Integer pageNum, Integer pageSize, StudentExample example)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
