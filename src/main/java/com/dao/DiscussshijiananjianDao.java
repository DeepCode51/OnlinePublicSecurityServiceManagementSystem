package com.dao;

import com.entity.DiscussshijiananjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshijiananjianVO;
import com.entity.view.DiscussshijiananjianView;


/**
 * 事件案件评论表
 * 
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface DiscussshijiananjianDao extends BaseMapper<DiscussshijiananjianEntity> {
	
	List<DiscussshijiananjianVO> selectListVO(@Param("ew") Wrapper<DiscussshijiananjianEntity> wrapper);
	
	DiscussshijiananjianVO selectVO(@Param("ew") Wrapper<DiscussshijiananjianEntity> wrapper);
	
	List<DiscussshijiananjianView> selectListView(@Param("ew") Wrapper<DiscussshijiananjianEntity> wrapper);

	List<DiscussshijiananjianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshijiananjianEntity> wrapper);
	
	DiscussshijiananjianView selectView(@Param("ew") Wrapper<DiscussshijiananjianEntity> wrapper);
	

}
