package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussshijiananjianEntity;
import com.entity.view.DiscussshijiananjianView;

import com.service.DiscussshijiananjianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 事件案件评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
@RestController
@RequestMapping("/discussshijiananjian")
public class DiscussshijiananjianController {
    @Autowired
    private DiscussshijiananjianService discussshijiananjianService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshijiananjianEntity discussshijiananjian,
		HttpServletRequest request){
        EntityWrapper<DiscussshijiananjianEntity> ew = new EntityWrapper<DiscussshijiananjianEntity>();

		PageUtils page = discussshijiananjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshijiananjian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshijiananjianEntity discussshijiananjian, 
		HttpServletRequest request){
        EntityWrapper<DiscussshijiananjianEntity> ew = new EntityWrapper<DiscussshijiananjianEntity>();

		PageUtils page = discussshijiananjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshijiananjian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshijiananjianEntity discussshijiananjian){
       	EntityWrapper<DiscussshijiananjianEntity> ew = new EntityWrapper<DiscussshijiananjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshijiananjian, "discussshijiananjian")); 
        return R.ok().put("data", discussshijiananjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshijiananjianEntity discussshijiananjian){
        EntityWrapper< DiscussshijiananjianEntity> ew = new EntityWrapper< DiscussshijiananjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshijiananjian, "discussshijiananjian")); 
		DiscussshijiananjianView discussshijiananjianView =  discussshijiananjianService.selectView(ew);
		return R.ok("查询事件案件评论表成功").put("data", discussshijiananjianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshijiananjianEntity discussshijiananjian = discussshijiananjianService.selectById(id);
        return R.ok().put("data", discussshijiananjian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshijiananjianEntity discussshijiananjian = discussshijiananjianService.selectById(id);
        return R.ok().put("data", discussshijiananjian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshijiananjianEntity discussshijiananjian, HttpServletRequest request){
    	discussshijiananjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshijiananjian);
        discussshijiananjianService.insert(discussshijiananjian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshijiananjianEntity discussshijiananjian, HttpServletRequest request){
    	discussshijiananjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshijiananjian);
        discussshijiananjianService.insert(discussshijiananjian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussshijiananjianEntity discussshijiananjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshijiananjian);
        discussshijiananjianService.updateById(discussshijiananjian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshijiananjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussshijiananjianEntity> wrapper = new EntityWrapper<DiscussshijiananjianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussshijiananjianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
