package com.entity.vo;

import com.entity.ShijiananjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 事件案件
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-07-29 07:56:23
 */
public class ShijiananjianVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shijian;
		
	/**
	 * 类型
	 */
	
	private String leixing;
		
	/**
	 * 发生地
	 */
	
	private String fashengdi;
		
	/**
	 * 主要参与人物
	 */
	
	private String zhuyaocanyurenwu;
		
	/**
	 * 事件内容
	 */
	
	private String shijianneirong;
		
	/**
	 * 处理方式
	 */
	
	private String chulifangshi;
		
	/**
	 * 警号
	 */
	
	private String jinghao;
		
	/**
	 * 图片封面
	 */
	
	private String tupianfengmian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：时间
	 */
	 
	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}
	
	/**
	 * 获取：时间
	 */
	public Date getShijian() {
		return shijian;
	}
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
				
	
	/**
	 * 设置：发生地
	 */
	 
	public void setFashengdi(String fashengdi) {
		this.fashengdi = fashengdi;
	}
	
	/**
	 * 获取：发生地
	 */
	public String getFashengdi() {
		return fashengdi;
	}
				
	
	/**
	 * 设置：主要参与人物
	 */
	 
	public void setZhuyaocanyurenwu(String zhuyaocanyurenwu) {
		this.zhuyaocanyurenwu = zhuyaocanyurenwu;
	}
	
	/**
	 * 获取：主要参与人物
	 */
	public String getZhuyaocanyurenwu() {
		return zhuyaocanyurenwu;
	}
				
	
	/**
	 * 设置：事件内容
	 */
	 
	public void setShijianneirong(String shijianneirong) {
		this.shijianneirong = shijianneirong;
	}
	
	/**
	 * 获取：事件内容
	 */
	public String getShijianneirong() {
		return shijianneirong;
	}
				
	
	/**
	 * 设置：处理方式
	 */
	 
	public void setChulifangshi(String chulifangshi) {
		this.chulifangshi = chulifangshi;
	}
	
	/**
	 * 获取：处理方式
	 */
	public String getChulifangshi() {
		return chulifangshi;
	}
				
	
	/**
	 * 设置：警号
	 */
	 
	public void setJinghao(String jinghao) {
		this.jinghao = jinghao;
	}
	
	/**
	 * 获取：警号
	 */
	public String getJinghao() {
		return jinghao;
	}
				
	
	/**
	 * 设置：图片封面
	 */
	 
	public void setTupianfengmian(String tupianfengmian) {
		this.tupianfengmian = tupianfengmian;
	}
	
	/**
	 * 获取：图片封面
	 */
	public String getTupianfengmian() {
		return tupianfengmian;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
