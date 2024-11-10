package com.entity.view;

import com.entity.FalvfaguiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 法律法规
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
@TableName("falvfagui")
public class FalvfaguiView  extends FalvfaguiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FalvfaguiView(){
	}
 
 	public FalvfaguiView(FalvfaguiEntity falvfaguiEntity){
 	try {
			BeanUtils.copyProperties(this, falvfaguiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
