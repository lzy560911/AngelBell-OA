package cn.angelbell.oa.mapper.parent;

import cn.angelbell.oa.entity.Parent;
import cn.angelbell.oa.entity.ParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int countByExample(ParentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int deleteByExample(ParentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer parentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int insert(Parent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int insertSelective(Parent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    List<Parent> selectByExample(ParentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    Parent selectByPrimaryKey(Integer parentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Parent record, @Param("example") ParentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Parent record, @Param("example") ParentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Parent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table parent_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Parent record);
    
    /**
     * 
     * @Title: getList
     * @Description: 获取所有家长列表
     * @return
     * @throws Exception
     */
    List<Parent> getList() throws Exception;
}