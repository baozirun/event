package com.aifa.mins.event.model.yjzh;

import java.util.Date;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.aifa.mins.model.Pojo;
import com.aifa.mins.model.Validator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类名 <p>YjzhContingencyplansDisposeDespicable
 * 
 * @描述 YjzhContingencyplansDisposeDespicable类属性
 * 		<p>1.Long sid		
 * 		<p>2.Long tenantId		
 * 		<p>3.Long planId		
 * 		<p>4.String eventId		
 * 		<p>5.String eventStatus		
 * 		<p>6.Long disposeId		
 * 		<p>7.String type		
 * 		<p>8.String status		
 * 		<p>9.String content		
 * 		<p>10.Long executorId		
 * 		<p>11.String executor		
 * 		<p>12.String executorTel		
 * 		<p>13.String executorPosition		
 * 		<p>14.String senderOrg		
 * 		<p>15.String sender		
 * 		<p>16.Date timeLimit		
 * 		<p>17.Long createdBy		
 * 		<p>18.Date created		
 * 		<p>19.Long lastUpdatedBy		
 * 		<p>20.Date lastUpdated		
 * 		<p>21.String executorType		
 * 		<p>22.String title		
 *      
 * @数据库表名称:		YJZH_CONTINGENCYPLANS_DISPOSE_DESPICABLE
 * @数据库表备注:	 	
 * 
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 *
 */
@Data
public class YjzhContingencyplansDisposeDespicable extends Pojo{
	
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
	private Long planId;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：200")
	private String eventId;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：4")
	private String eventStatus;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：19")
	private Long disposeId;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：4")
	private String type;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：4")
	private String status;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：2,147,483,647")
	private String content;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：19")
	private Long executorId;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：100")
	private String executor;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：100")
	private String executorTel;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：200")
	private String executorPosition;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：200")
	private String senderOrg;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：200")
	private String sender;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：26")
	private Date timeLimit;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：50")
	private String executorType;
	/**
	 * 
	 */
	@ApiModelProperty(value="",notes="字符长度为：1,000")
	private String title;
	// fields end

	/**
	 * 非持久化属性
	 */
	@ApiModelProperty("主键集合")
	private List<Long> ids;
	
}
