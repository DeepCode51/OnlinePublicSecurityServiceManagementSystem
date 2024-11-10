package com.entity.view;

import com.entity.JingwurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 警务人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
@TableName("jingwurenyuan")
public class JingwurenyuanView  extends JingwurenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingwurenyuanView(){
	}
 
 	public JingwurenyuanView(JingwurenyuanEntity jingwurenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, jingwurenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
