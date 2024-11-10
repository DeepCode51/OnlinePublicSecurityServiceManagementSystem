package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShijiananjianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShijiananjianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShijiananjianView;


/**
 * 事件案件
 *
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface ShijiananjianService extends IService<ShijiananjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShijiananjianVO> selectListVO(Wrapper<ShijiananjianEntity> wrapper);
   	
   	ShijiananjianVO selectVO(@Param("ew") Wrapper<ShijiananjianEntity> wrapper);
   	
   	List<ShijiananjianView> selectListView(Wrapper<ShijiananjianEntity> wrapper);
   	
   	ShijiananjianView selectView(@Param("ew") Wrapper<ShijiananjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShijiananjianEntity> wrapper);
   	

}

