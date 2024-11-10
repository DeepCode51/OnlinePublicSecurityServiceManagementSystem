package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingwurenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingwurenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingwurenyuanView;


/**
 * 警务人员
 *
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface JingwurenyuanService extends IService<JingwurenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingwurenyuanVO> selectListVO(Wrapper<JingwurenyuanEntity> wrapper);
   	
   	JingwurenyuanVO selectVO(@Param("ew") Wrapper<JingwurenyuanEntity> wrapper);
   	
   	List<JingwurenyuanView> selectListView(Wrapper<JingwurenyuanEntity> wrapper);
   	
   	JingwurenyuanView selectView(@Param("ew") Wrapper<JingwurenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingwurenyuanEntity> wrapper);
   	

}

