package cn.angelbell.oa.mapper.role;

import cn.angelbell.oa.entity.Log;
import cn.angelbell.oa.entity.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int countByExample(LogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int deleteByExample(LogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int insert(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int insertSelective(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    List<Log> selectByExampleWithBLOBs(LogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    List<Log> selectByExample(LogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    Log selectByPrimaryKey(Integer logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") Log record, @Param("example") LogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Log record);
}