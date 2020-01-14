package cn.angelbell.oa.service.comment;

import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Comment;
import cn.angelbell.oa.entity.CommentExample;

/**
 * 
 * @ClassName: CommentService
 * @Description: 评论业务逻辑接口
 * @author liziye
 * @date 2019.12.11
 */
@Service
public interface CommentService {
	/**
     * 
     * @Title: getCommentTypeList
     * @Description: 从数据库中获取全部评论信息
     * @throws Exception
     */
	PageInfo<Comment> getCommentList(Integer pageNum, Integer pageSize) throws Exception;
    
    /**
     * 
     * @Title: selectByUserName
     * @Description: 根据评论教师姓名查询
     * @param commentator 评论人
     * @throws Exception
     */
	Comment selectByUserName(String commentator) throws Exception;
    
    
    /**
     * @Title: deleteByPrimaryKey
     * @Description: 指定ID删除信息
     * @param studentID 评论ID
     * @throws Exception
     */
    Boolean deleteByPrimaryKey(Integer commentID) throws Exception;
    
    /**
     * @Title: selectByExample
     * @Description: 按条件查询评论信息
     * @param example 查询条件
     * @throws Exception
     */
    PageInfo<Comment> selectByExample(Integer pageNum, Integer pageSize,CommentExample example) throws Exception;
}
