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


import com.dao.DiscussshijiananjianDao;
import com.entity.DiscussshijiananjianEntity;
import com.service.DiscussshijiananjianService;
import com.entity.vo.DiscussshijiananjianVO;
import com.entity.view.DiscussshijiananjianView;

@Service("discussshijiananjianService")
public class DiscussshijiananjianServiceImpl extends ServiceImpl<DiscussshijiananjianDao, DiscussshijiananjianEntity> implements DiscussshijiananjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshijiananjianEntity> page = this.selectPage(
                new Query<DiscussshijiananjianEntity>(params).getPage(),
                new EntityWrapper<DiscussshijiananjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshijiananjianEntity> wrapper) {
		  Page<DiscussshijiananjianView> page =new Query<DiscussshijiananjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshijiananjianVO> selectListVO(Wrapper<DiscussshijiananjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshijiananjianVO selectVO(Wrapper<DiscussshijiananjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshijiananjianView> selectListView(Wrapper<DiscussshijiananjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshijiananjianView selectView(Wrapper<DiscussshijiananjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
