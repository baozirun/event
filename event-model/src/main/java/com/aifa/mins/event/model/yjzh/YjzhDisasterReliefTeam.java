package com.aifa.mins.event.model.yjzh;

import java.util.Date;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.aifa.mins.model.Pojo;
import com.aifa.mins.model.Validator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类名 <p>YjzhDisasterReliefTeam
 * 
 * @描述 YjzhDisasterReliefTeam类属性
 * 		<p>1.Long sid		
 * 		<p>2.Long tenantId		
 * 		<p>3.String name		
 * 		<p>4.String status		
 * 		<p>5.Integer numberPeople		
 * 		<p>6.String director		
 * 		<p>7.String directorTel		
 * 		<p>8.String longitude		
 * 		<p>9.String latitude		
 * 		<p>10.Long createdBy		
 * 		<p>11.Date created		
 * 		<p>12.Long lastUpdatedBy		
 * 		<p>13.Date lastUpdated		
 * 		<p>14.String eventId		
 *      
 * @数据库表名称:		YJZH_DISASTER_RELIEF_TEAM
 * @数据库表备注:	 	
 * 
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 *
 */
@Data
public class YjzhDisasterReliefTeam extends Pojo{
	
//	/**
//	 * 	数据验证demo
//	 */
//	@NotNull(message = "xxx不能为空",groups = {Validator.save.class,Validator.update.class})
//	@ApiModelProperty("demo")
//	private Long demo;
	
	// fields start
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：200")
	private String name;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：4")
	private String status;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：10")
	private Integer numberPeople;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：100")
	private String director;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：100")
	private String directorTel;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：100")
	private String longitude;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：100")
	private String latitude;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：50")
	private String eventId;

	private String title;
	// fields end

	/**
	 * 非持久化属性
	 */
	@ApiModelProperty("主键集合")
	private List<Long> ids;
	
}
