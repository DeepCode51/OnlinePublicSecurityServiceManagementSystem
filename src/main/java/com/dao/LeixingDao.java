package com.dao;

import com.entity.LeixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LeixingVO;
import com.entity.view.LeixingView;


/**
 * 类型
 * 
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface LeixingDao extends BaseMapper<LeixingEntity> {
	
	List<LeixingVO> selectListVO(@Param("ew") Wrapper<LeixingEntity> wrapper);
	
	LeixingVO selectVO(@Param("ew") Wrapper<LeixingEntity> wrapper);
	
	List<LeixingView> selectListView(@Param("ew") Wrapper<LeixingEntity> wrapper);

	List<LeixingView> selectListView(Pagination page,@Param("ew") Wrapper<LeixingEntity> wrapper);
	
	LeixingView selectView(@Param("ew") Wrapper<LeixingEntity> wrapper);
	

}
