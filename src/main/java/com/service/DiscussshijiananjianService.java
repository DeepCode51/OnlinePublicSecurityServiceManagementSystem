package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshijiananjianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshijiananjianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshijiananjianView;


/**
 * 事件案件评论表
 *
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public interface DiscussshijiananjianService extends IService<DiscussshijiananjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshijiananjianVO> selectListVO(Wrapper<DiscussshijiananjianEntity> wrapper);
   	
   	DiscussshijiananjianVO selectVO(@Param("ew") Wrapper<DiscussshijiananjianEntity> wrapper);
   	
   	List<DiscussshijiananjianView> selectListView(Wrapper<DiscussshijiananjianEntity> wrapper);
   	
   	DiscussshijiananjianView selectView(@Param("ew") Wrapper<DiscussshijiananjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshijiananjianEntity> wrapper);
   	

}

