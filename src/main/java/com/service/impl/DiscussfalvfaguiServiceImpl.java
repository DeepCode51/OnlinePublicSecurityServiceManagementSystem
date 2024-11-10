package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussfalvfaguiDao;
import com.entity.DiscussfalvfaguiEntity;
import com.service.DiscussfalvfaguiService;
import com.entity.vo.DiscussfalvfaguiVO;
import com.entity.view.DiscussfalvfaguiView;

@Service("discussfalvfaguiService")
public class DiscussfalvfaguiServiceImpl extends ServiceImpl<DiscussfalvfaguiDao, DiscussfalvfaguiEntity> implements DiscussfalvfaguiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfalvfaguiEntity> page = this.selectPage(
                new Query<DiscussfalvfaguiEntity>(params).getPage(),
                new EntityWrapper<DiscussfalvfaguiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfalvfaguiEntity> wrapper) {
		  Page<DiscussfalvfaguiView> page =new Query<DiscussfalvfaguiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussfalvfaguiVO> selectListVO(Wrapper<DiscussfalvfaguiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussfalvfaguiVO selectVO(Wrapper<DiscussfalvfaguiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussfalvfaguiView> selectListView(Wrapper<DiscussfalvfaguiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfalvfaguiView selectView(Wrapper<DiscussfalvfaguiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
