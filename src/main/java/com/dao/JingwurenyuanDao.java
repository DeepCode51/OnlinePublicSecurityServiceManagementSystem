package com.dao;

import com.entity.JingwurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingwurenyuanVO;
import com.entity.view.JingwurenyuanView;


/**
 * 警务人员
 * 
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface JingwurenyuanDao extends BaseMapper<JingwurenyuanEntity> {
	
	List<JingwurenyuanVO> selectListVO(@Param("ew") Wrapper<JingwurenyuanEntity> wrapper);
	
	JingwurenyuanVO selectVO(@Param("ew") Wrapper<JingwurenyuanEntity> wrapper);
	
	List<JingwurenyuanView> selectListView(@Param("ew") Wrapper<JingwurenyuanEntity> wrapper);

	List<JingwurenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JingwurenyuanEntity> wrapper);
	
	JingwurenyuanView selectView(@Param("ew") Wrapper<JingwurenyuanEntity> wrapper);
	

}
