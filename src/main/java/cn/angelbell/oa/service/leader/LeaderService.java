package cn.angelbell.oa.service.leader;



import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Leader;
import cn.angelbell.oa.entity.LeaderExample;

/**
 * 
 * @ClassName: TeacherService
 * @Description: 教师业务逻辑接口
 * @author liziye
 * @date 2019.07.15
 */
@Service
public interface LeaderService {
	/**
     * 
     * @Title: getTeacherTypeList
     * @Description: 从数据库中获取全部教师信息
     * @throws Exception
     */
	PageInfo<Leader> getLeaderTypeList(Integer pageNum, Integer pageSize) throws Exception;
    
    /**
     * 
     * @Title: selectByUserName
     * @Description: 根据教师真实姓名进行查询指定信息
     * @param realName 教师真实姓名
     * @throws Exception
     */
	Leader selectByUserName(String leaderName) throws Exception;
    
    
    /**
     * @Title: deleteByPrimaryKey
     * @Description: 指定ID删除信息
     * @param teacherID 教师ID
     * @throws Exception
     */
    Boolean deleteByPrimaryKey(Integer leaderID) throws Exception;
    
    /**
     * @Title: selectByExample
     * @Description: 按条件查询教师信息
     * @param example 查询条件
     * @throws Exception
     */
    PageInfo<Leader> selectByExample(Integer pageNum, Integer pageSize,LeaderExample example) throws Exception;
}
