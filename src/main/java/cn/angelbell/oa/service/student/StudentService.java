package cn.angelbell.oa.service.student;

import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import cn.angelbell.oa.entity.Student;
import cn.angelbell.oa.entity.StudentExample;

/**
 * 
 * @ClassName: StudentService
 * @Description: 学生业务逻辑接口
 * @author liziye
 * @date 2019.12.11
 */
@Service
public interface StudentService {
	/**
     * 
     * @Title: getStudentTypeList
     * @Description: 从数据库中获取全部学生信息
     * @throws Exception
     */
	PageInfo<Student> getStudentTypeList(Integer pageNum, Integer pageSize) throws Exception;
    
    /**
     * 
     * @Title: selectByUserName
     * @Description: 根据学生真实姓名进行查询指定信息
     * @param realName 教师真实姓名
     * @throws Exception
     */
	Student selectByUserName(String realName) throws Exception;
    
    
    /**
     * @Title: deleteByPrimaryKey
     * @Description: 指定ID删除信息
     * @param studentID 学生ID
     * @throws Exception
     */
    Boolean deleteByPrimaryKey(Integer studentID) throws Exception;
    
    /**
     * @Title: selectByExample
     * @Description: 按条件查询学生信息
     * @param example 查询条件
     * @throws Exception
     */
    PageInfo<Student> selectByExample(Integer pageNum, Integer pageSize,StudentExample example) throws Exception;
    
    /**
     * @Title: selectCount
     * @Description: 查询教师数量
     * @param 
     * @throws Exception
     */
    Integer selectCount() throws Exception;
}
