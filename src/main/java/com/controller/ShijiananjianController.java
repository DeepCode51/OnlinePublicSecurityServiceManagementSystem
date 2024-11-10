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

import com.entity.ShijiananjianEntity;
import com.entity.view.ShijiananjianView;

import com.service.ShijiananjianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 事件案件
 * 后端接口
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
@RestController
@RequestMapping("/shijiananjian")
public class ShijiananjianController {
    @Autowired
    private ShijiananjianService shijiananjianService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShijiananjianEntity shijiananjian,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingwurenyuan")) {
			shijiananjian.setJinghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShijiananjianEntity> ew = new EntityWrapper<ShijiananjianEntity>();
                if(shijianstart!=null) ew.ge("shijian", shijianstart);
                if(shijianend!=null) ew.le("shijian", shijianend);

		PageUtils page = shijiananjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijiananjian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShijiananjianEntity shijiananjian, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shijianend,
		HttpServletRequest request){
        EntityWrapper<ShijiananjianEntity> ew = new EntityWrapper<ShijiananjianEntity>();
                if(shijianstart!=null) ew.ge("shijian", shijianstart);
                if(shijianend!=null) ew.le("shijian", shijianend);

		PageUtils page = shijiananjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijiananjian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShijiananjianEntity shijiananjian){
       	EntityWrapper<ShijiananjianEntity> ew = new EntityWrapper<ShijiananjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shijiananjian, "shijiananjian")); 
        return R.ok().put("data", shijiananjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShijiananjianEntity shijiananjian){
        EntityWrapper< ShijiananjianEntity> ew = new EntityWrapper< ShijiananjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shijiananjian, "shijiananjian")); 
		ShijiananjianView shijiananjianView =  shijiananjianService.selectView(ew);
		return R.ok("查询事件案件成功").put("data", shijiananjianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShijiananjianEntity shijiananjian = shijiananjianService.selectById(id);
		shijiananjian.setClicknum(shijiananjian.getClicknum()+1);
		shijiananjianService.updateById(shijiananjian);
        return R.ok().put("data", shijiananjian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShijiananjianEntity shijiananjian = shijiananjianService.selectById(id);
		shijiananjian.setClicknum(shijiananjian.getClicknum()+1);
		shijiananjianService.updateById(shijiananjian);
        return R.ok().put("data", shijiananjian);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ShijiananjianEntity shijiananjian = shijiananjianService.selectById(id);
        if(type.equals("1")) {
        	shijiananjian.setThumbsupnum(shijiananjian.getThumbsupnum()+1);
        } else {
        	shijiananjian.setCrazilynum(shijiananjian.getCrazilynum()+1);
        }
        shijiananjianService.updateById(shijiananjian);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShijiananjianEntity shijiananjian, HttpServletRequest request){
    	shijiananjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shijiananjian);
        shijiananjianService.insert(shijiananjian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShijiananjianEntity shijiananjian, HttpServletRequest request){
    	shijiananjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shijiananjian);
        shijiananjianService.insert(shijiananjian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShijiananjianEntity shijiananjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shijiananjian);
        shijiananjianService.updateById(shijiananjian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shijiananjianService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ShijiananjianEntity> wrapper = new EntityWrapper<ShijiananjianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingwurenyuan")) {
			wrapper.eq("jinghao", (String)request.getSession().getAttribute("username"));
		}

		int count = shijiananjianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
