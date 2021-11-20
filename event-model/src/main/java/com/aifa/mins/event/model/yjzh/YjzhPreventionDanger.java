package com.aifa.mins.event.model.yjzh;

import java.util.Date;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.aifa.mins.model.Pojo;
import com.aifa.mins.model.Validator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类名 <p>YjzhPreventionDanger
 * 
 * @描述 YjzhPreventionDanger类属性
 * 		<p>1.Long sid		
 * 		<p>2.Long tenantId		
 * 		<p>3.String source		
 * 		<p>4.String name		
 * 		<p>5.String adder		
 * 		<p>6.String adderGis		
 * 		<p>7.String reportor		
 * 		<p>8.String phone		
 * 		<p>9.String detail		
 * 		<p>10.String status		
 * 		<p>11.Long createdBy		
 * 		<p>12.Date created		
 * 		<p>13.Long lastUpdatedBy		
 * 		<p>14.Date lastUpdated		
 * 		<p>15.String longitude		
 * 		<p>16.String latitude		
 * 		<p>17.Date occurrenceTime		
 * 		<p>18.Long accidentType		
 * 		<p>19.String areaName		
 * 		<p>20.Long areaId		
 * 		<p>21.Date reportTime		
 *      
 * @数据库表名称:		YJZH_PREVENTION_DANGER
 * @数据库表备注:	 	
 * 
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 *
 */
@Data
public class YjzhPreventionDanger extends Pojo{
	
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
	@ApiModelProperty(value="",notes="字符长度为：40")
	private String source;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：2,000")
	private String name;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：2,000")
	private String adder;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：400")
	private String adderGis;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：200")
	private String reportor;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：200")
	private String phone;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：2,147,483,647")
	private String detail;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：8")
	private String status;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：50")
	private String longitude;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：50")
	private String latitude;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：26")
	private Date occurrenceTime;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：19")
	private Long accidentType;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：50")
	private String areaName;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：19")
	private Long areaId;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：26")
	private Date reportTime;
	// fields end

	@ApiModelProperty(value="公里范围过滤")
	private Long distance;

	private String title;

	/**
	 * 非持久化属性
	 */
	@ApiModelProperty("主键集合")
	private List<Long> ids;
	
}
