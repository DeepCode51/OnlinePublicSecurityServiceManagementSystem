package com.dao;

import com.entity.ShijiananjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShijiananjianVO;
import com.entity.view.ShijiananjianView;


/**
 * 事件案件
 * 
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface ShijiananjianDao extends BaseMapper<ShijiananjianEntity> {
	
	List<ShijiananjianVO> selectListVO(@Param("ew") Wrapper<ShijiananjianEntity> wrapper);
	
	ShijiananjianVO selectVO(@Param("ew") Wrapper<ShijiananjianEntity> wrapper);
	
	List<ShijiananjianView> selectListView(@Param("ew") Wrapper<ShijiananjianEntity> wrapper);

	List<ShijiananjianView> selectListView(Pagination page,@Param("ew") Wrapper<ShijiananjianEntity> wrapper);
	
	ShijiananjianView selectView(@Param("ew") Wrapper<ShijiananjianEntity> wrapper);
	

}
