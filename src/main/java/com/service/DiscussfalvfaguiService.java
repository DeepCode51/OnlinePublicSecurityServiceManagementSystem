package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfalvfaguiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfalvfaguiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfalvfaguiView;


/**
 * 法律法规评论表
 *
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface DiscussfalvfaguiService extends IService<DiscussfalvfaguiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfalvfaguiVO> selectListVO(Wrapper<DiscussfalvfaguiEntity> wrapper);
   	
   	DiscussfalvfaguiVO selectVO(@Param("ew") Wrapper<DiscussfalvfaguiEntity> wrapper);
   	
   	List<DiscussfalvfaguiView> selectListView(Wrapper<DiscussfalvfaguiEntity> wrapper);
   	
   	DiscussfalvfaguiView selectView(@Param("ew") Wrapper<DiscussfalvfaguiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfalvfaguiEntity> wrapper);
   	

}

