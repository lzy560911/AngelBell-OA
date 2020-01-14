package cn.angelbell.oa.service.teacher;



import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Teacher;
import cn.angelbell.oa.entity.TeacherExample;

/**
 * 
 * @ClassName: TeacherService
 * @Description: 教师业务逻辑接口
 * @author liziye
 * @date 2019.07.15
 */
@Service
public interface TeacherService {
	
	/**
     * @Title: getTeacherTypeList
     * @Description: 从数据库中获取全部教师信息
     * @throws Exception
     */
	PageInfo<Teacher> getTeacherTypeList(Integer pageNum, Integer pageSize) throws Exception;
    
    /**
     * 
     * @Title: selectByUserName
     * @Description: 根据教师真实姓名进行查询指定信息
     * @param realName 教师真实姓名
     * @throws Exception
     */
    Teacher selectByUserName(String realName) throws Exception;
    
    
    /**
     * @Title: deleteByPrimaryKey
     * @Description: 指定ID删除信息
     * @param teacherID 教师ID
     * @throws Exception
     */
    Boolean deleteByPrimaryKey(Integer teacherID) throws Exception;
    
    /**
     * @Title: selectByExample
     * @Description: 按条件查询教师信息
     * @param example 查询条件
     * @throws Exception
     */
    PageInfo<Teacher> selectByExample(Integer pageNum, Integer pageSize,TeacherExample example) throws Exception;
    
    /**
     * @Title: selectCount
     * @Description: 查询教师数量
     * @param 
     * @throws Exception
     */
    Integer selectCount() throws Exception;
}
