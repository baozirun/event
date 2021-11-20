package com.aifa.mins.event.model.yjzh;

import java.util.Date;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.aifa.mins.model.Pojo;
import com.aifa.mins.model.Validator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类名 <p>YjzhContingencyplansDisposetaskResult
 * 
 * @描述 YjzhContingencyplansDisposetaskResult类属性
 * 		<p>1.Long sid		
 * 		<p>2.Long tenantId		
 * 		<p>3.Long despicableId		
 * 		<p>4.String content		
 * 		<p>5.Long createdBy		
 * 		<p>6.Date created		
 * 		<p>7.Long lastUpdatedBy		
 * 		<p>8.Date lastUpdated		
 * 		<p>9.String eventId		
 *      
 * @数据库表名称:		YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT
 * @数据库表备注:	 	
 * 
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 *
 */
@Data
public class YjzhContingencyplansDisposetaskResult extends Pojo{
	
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
	@ApiModelProperty(value="",notes="字符长度为：19")
	private Long despicableId;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：2,147,483,647")
	private String content;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：100")
	private String eventId;
	// fields end

	/**
	 * 非持久化属性
	 */
	@ApiModelProperty("主键集合")
	private List<Long> ids;
	
}
