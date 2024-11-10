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


import com.dao.JingwurenyuanDao;
import com.entity.JingwurenyuanEntity;
import com.service.JingwurenyuanService;
import com.entity.vo.JingwurenyuanVO;
import com.entity.view.JingwurenyuanView;

@Service("jingwurenyuanService")
public class JingwurenyuanServiceImpl extends ServiceImpl<JingwurenyuanDao, JingwurenyuanEntity> implements JingwurenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingwurenyuanEntity> page = this.selectPage(
                new Query<JingwurenyuanEntity>(params).getPage(),
                new EntityWrapper<JingwurenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingwurenyuanEntity> wrapper) {
		  Page<JingwurenyuanView> page =new Query<JingwurenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JingwurenyuanVO> selectListVO(Wrapper<JingwurenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JingwurenyuanVO selectVO(Wrapper<JingwurenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JingwurenyuanView> selectListView(Wrapper<JingwurenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingwurenyuanView selectView(Wrapper<JingwurenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
