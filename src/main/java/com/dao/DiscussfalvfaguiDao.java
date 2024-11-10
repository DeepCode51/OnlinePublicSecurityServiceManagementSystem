package com.dao;

import com.entity.DiscussfalvfaguiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfalvfaguiVO;
import com.entity.view.DiscussfalvfaguiView;


/**
 * 法律法规评论表
 * 
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface DiscussfalvfaguiDao extends BaseMapper<DiscussfalvfaguiEntity> {
	
	List<DiscussfalvfaguiVO> selectListVO(@Param("ew") Wrapper<DiscussfalvfaguiEntity> wrapper);
	
	DiscussfalvfaguiVO selectVO(@Param("ew") Wrapper<DiscussfalvfaguiEntity> wrapper);
	
	List<DiscussfalvfaguiView> selectListView(@Param("ew") Wrapper<DiscussfalvfaguiEntity> wrapper);

	List<DiscussfalvfaguiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfalvfaguiEntity> wrapper);
	
	DiscussfalvfaguiView selectView(@Param("ew") Wrapper<DiscussfalvfaguiEntity> wrapper);
	

}
