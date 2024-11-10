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


import com.dao.ShijiananjianDao;
import com.entity.ShijiananjianEntity;
import com.service.ShijiananjianService;
import com.entity.vo.ShijiananjianVO;
import com.entity.view.ShijiananjianView;

@Service("shijiananjianService")
public class ShijiananjianServiceImpl extends ServiceImpl<ShijiananjianDao, ShijiananjianEntity> implements ShijiananjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShijiananjianEntity> page = this.selectPage(
                new Query<ShijiananjianEntity>(params).getPage(),
                new EntityWrapper<ShijiananjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShijiananjianEntity> wrapper) {
		  Page<ShijiananjianView> page =new Query<ShijiananjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShijiananjianVO> selectListVO(Wrapper<ShijiananjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShijiananjianVO selectVO(Wrapper<ShijiananjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShijiananjianView> selectListView(Wrapper<ShijiananjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShijiananjianView selectView(Wrapper<ShijiananjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
