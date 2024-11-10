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


import com.dao.FalvfaguiDao;
import com.entity.FalvfaguiEntity;
import com.service.FalvfaguiService;
import com.entity.vo.FalvfaguiVO;
import com.entity.view.FalvfaguiView;

@Service("falvfaguiService")
public class FalvfaguiServiceImpl extends ServiceImpl<FalvfaguiDao, FalvfaguiEntity> implements FalvfaguiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FalvfaguiEntity> page = this.selectPage(
                new Query<FalvfaguiEntity>(params).getPage(),
                new EntityWrapper<FalvfaguiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FalvfaguiEntity> wrapper) {
		  Page<FalvfaguiView> page =new Query<FalvfaguiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FalvfaguiVO> selectListVO(Wrapper<FalvfaguiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FalvfaguiVO selectVO(Wrapper<FalvfaguiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FalvfaguiView> selectListView(Wrapper<FalvfaguiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FalvfaguiView selectView(Wrapper<FalvfaguiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
