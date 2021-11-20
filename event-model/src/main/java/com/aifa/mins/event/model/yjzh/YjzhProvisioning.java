package com.aifa.mins.event.model.yjzh;

import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.aifa.mins.model.Pojo;
import com.aifa.mins.model.Validator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类名 <p>YjzhProvisioning
 * 
 * @描述 YjzhProvisioning类属性
 * 		<p>1.Long sid		
 * 		<p>2.Long tenantId		
 * 		<p>3.String name		
 * 		<p>4.String unitMeasure		
 * 		<p>5.BigDecimal demandQuantity		
 * 		<p>6.BigDecimal transferredQuantity		
 * 		<p>7.BigDecimal gapsNumber		
 * 		<p>8.String destination		
 * 		<p>9.Date deploymentTime		
 * 		<p>10.Long createdBy		
 * 		<p>11.Date created		
 * 		<p>12.Long lastUpdatedBy		
 * 		<p>13.Date lastUpdated		
 * 		<p>14.String eventId		
 *      
 * @数据库表名称:		YJZH_PROVISIONING
 * @数据库表备注:	 	
 * 
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 *
 */
@Data
public class YjzhProvisioning extends Pojo{
	
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
	@ApiModelProperty(value="",notes="字符长度为：400")
	private String name;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：20")
	private String unitMeasure;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：19")
	private BigDecimal demandQuantity;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：19")
	private BigDecimal transferredQuantity;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：19")
	private BigDecimal gapsNumber;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：1,000")
	private String destination;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：26")
	private Date deploymentTime;
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
