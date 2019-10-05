package cn.angelbell.oa.serviceImpl.leader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.angelbell.oa.entity.Leader;
import cn.angelbell.oa.entity.LeaderExample;
import cn.angelbell.oa.mapper.leader.LeaderMapper;
import cn.angelbell.oa.service.leader.LeaderService;

/**
 * 
 * @ClassName: TeacherServiceImpl
 * @Description: 教师类型业务逻辑处理
 * @author liziye
 * @date 2019.07.15
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class LeaderServiceImpl implements LeaderService{
	
	@Autowired
	private LeaderMapper leaderMapper;

	@Override
	public PageInfo<Leader> getLeaderTypeList(Integer pageNum, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<Leader> list = new ArrayList<Leader>();
		PageHelper.startPage(pageNum,pageSize);
		list = leaderMapper.getList();
		PageInfo<Leader> TeacherPageInfo = new PageInfo<Leader>(list);
		return TeacherPageInfo;
	}

	@Override
	public Leader selectByUserName(String leaderName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByPrimaryKey(Integer leaderID) throws Exception {
		// TODO Auto-generated method stub
		int delCode = leaderMapper.deleteByPrimaryKey(leaderID);
		System.out.println("code is --->"+delCode);
		if(delCode == 0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public PageInfo<Leader> selectByExample(Integer pageNum, Integer pageSize,LeaderExample example) throws Exception {
		// TODO Auto-generated method stub
		List<Leader> list = new ArrayList<Leader>();
		PageHelper.startPage(pageNum,pageSize);
		list = leaderMapper.selectByExample(example);
		PageInfo<Leader> TeacherPageInfo = new PageInfo<Leader>(list);
		return TeacherPageInfo;
	}
}
