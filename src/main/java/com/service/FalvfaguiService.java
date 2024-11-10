package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FalvfaguiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FalvfaguiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FalvfaguiView;


/**
 * 法律法规
 *
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface FalvfaguiService extends IService<FalvfaguiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FalvfaguiVO> selectListVO(Wrapper<FalvfaguiEntity> wrapper);
   	
   	FalvfaguiVO selectVO(@Param("ew") Wrapper<FalvfaguiEntity> wrapper);
   	
   	List<FalvfaguiView> selectListView(Wrapper<FalvfaguiEntity> wrapper);
   	
   	FalvfaguiView selectView(@Param("ew") Wrapper<FalvfaguiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FalvfaguiEntity> wrapper);
   	

}

