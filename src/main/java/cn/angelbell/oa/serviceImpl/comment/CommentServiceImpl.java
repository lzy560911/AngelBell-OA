package cn.angelbell.oa.serviceImpl.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Comment;
import cn.angelbell.oa.entity.CommentExample;
import cn.angelbell.oa.mapper.comment.CommentMapper;
import cn.angelbell.oa.service.comment.CommentService;


/**
 * 
 * @ClassName: CommentServiceImpl
 * @Description: 评论类型业务逻辑处理
 * @author liziye
 * @date 2019.07.15
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public PageInfo<Comment> getCommentList(Integer pageNum, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> list = new ArrayList<Comment>();
		PageHelper.startPage(pageNum,pageSize);
		list = commentMapper.getList();
		PageInfo<Comment> TeacherPageInfo = new PageInfo<Comment>(list);
		return TeacherPageInfo;
	}

	@Override
	public Comment selectByUserName(String commentator) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByPrimaryKey(Integer commentID) throws Exception {
		// TODO Auto-generated method stub
		int delCode = commentMapper.deleteByPrimaryKey(commentID);
		System.out.println("code is --->"+delCode);
		if(delCode == 0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public PageInfo<Comment> selectByExample(Integer pageNum, Integer pageSize,CommentExample example) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> list = new ArrayList<Comment>();
		PageHelper.startPage(pageNum,pageSize);
		list = commentMapper.selectByExample(example);
		PageInfo<Comment> TeacherPageInfo = new PageInfo<Comment>(list);
		return TeacherPageInfo;
	}
}
