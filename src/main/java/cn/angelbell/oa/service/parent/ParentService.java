package cn.angelbell.oa.service.parent;

import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Parent;
import cn.angelbell.oa.entity.ParentExample;

/**
 * 
 * @ClassName: ParentService
 * @Description: 家长业务逻辑接口
 * @author liziye
 * @date 2019.12.11
 */
@Service
public interface ParentService {
	/**
     * 
     * @Title: getStudentTypeList
     * @Description: 从数据库中获取全部家长信息
     * @throws Exception
     */
	PageInfo<Parent> getParentTypeList(Integer pageNum, Integer pageSize) throws Exception;
    
    /**
     * 
     * @Title: selectByUserName
     * @Description: 根据家长真实姓名进行查询指定信息
     * @param realName 真实姓名
     * @throws Exception
     */
	Parent selectByUserName(String realName) throws Exception;
    
    
    /**
     * @Title: deleteByPrimaryKey
     * @Description: 指定ID删除信息
     * @param studentID 家长ID
     * @throws Exception
     */
    Boolean deleteByPrimaryKey(Integer studentID) throws Exception;
    
    /**
     * @Title: selectByExample
     * @Description: 按条件查询家长信息
     * @param example 查询条件
     * @throws Exception
     */
    PageInfo<Parent> selectByExample(Integer pageNum, Integer pageSize,ParentExample example) throws Exception;
}
