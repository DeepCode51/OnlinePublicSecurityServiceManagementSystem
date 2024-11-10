package com.dao;

import com.entity.FalvfaguiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FalvfaguiVO;
import com.entity.view.FalvfaguiView;


/**
 * 法律法规
 * 
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface FalvfaguiDao extends BaseMapper<FalvfaguiEntity> {
	
	List<FalvfaguiVO> selectListVO(@Param("ew") Wrapper<FalvfaguiEntity> wrapper);
	
	FalvfaguiVO selectVO(@Param("ew") Wrapper<FalvfaguiEntity> wrapper);
	
	List<FalvfaguiView> selectListView(@Param("ew") Wrapper<FalvfaguiEntity> wrapper);

	List<FalvfaguiView> selectListView(Pagination page,@Param("ew") Wrapper<FalvfaguiEntity> wrapper);
	
	FalvfaguiView selectView(@Param("ew") Wrapper<FalvfaguiEntity> wrapper);
	

}
