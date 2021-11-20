package com.aifa.mins.event.model.yjzh;

import com.aifa.mins.model.Pojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @类名 <p>YjzhContingencyplansEventprogress
 * 
 * @描述 YjzhContingencyplansEventprogress类属性
 * 		<p>1.Long sid		系统主键
 * 		<p>2.Long tenantId		租户ID
 * 		<p>3.String eventId		突发事件id
 * 		<p>4.String eventName		事件名称
 * 		<p>5.String eventLevel		事件等级
 * 		<p>6.Long planId		指挥预案ID
 * 		<p>7.String status		指挥状态 1指挥中  2指挥结束
 * 		<p>8.Date startTime		开始指挥时间
 * 		<p>9.Date entTime		结束指挥时间
 * 		<p>10.Long createdBy		创建人
 * 		<p>11.Date created		创建时间
 * 		<p>12.Long lastUpdatedBy		最后更新人
 * 		<p>13.Date lastUpdated		最后更新时间
 *      
 * @数据库表名称:		YJZH_CONTINGENCYPLANS_EVENTPROGRESS
 * @数据库表备注:	 	
 * 
 * @作者	LYY
 * @日期	2021-11-20 10:37:37
 * @版本	1.0.0
 *
 */
@Data
public class YjzhContingencyplansEventprogress extends Pojo{
	
//	/**
//	 * 	数据验证demo
//	 */
//	@NotNull(message = "xxx不能为空",groups = {Validator.save.class,Validator.update.class})
//	@ApiModelProperty("demo")
//	private Long demo;
	
	// fields start
	/**
	 * 突发事件id
	 */
	@ApiModelProperty(value="突发事件id",notes="字符长度为：100")
	private String eventId;
	/**
	 * 事件名称
	 */
	@ApiModelProperty(value="事件名称",notes="字符长度为：500")
	private String eventName;
	/**
	 * 事件等级
	 */
	@ApiModelProperty(value="事件等级",notes="字符长度为：2")
	private String eventLevel;
	/**
	 * 指挥预案ID
	 */
	@ApiModelProperty(value="指挥预案ID",notes="字符长度为：19")
	private Long planId;
	/**
	 * 指挥状态 1指挥中  2指挥结束
	 */
	@ApiModelProperty(value="指挥状态 1指挥中  2指挥结束",notes="字符长度为：2")
	private String status;
	/**
	 * 开始指挥时间
	 */
	@ApiModelProperty(value="开始指挥时间",notes="字符长度为：26")
	private Date startTime;
	/**
	 * 结束指挥时间
	 */
	@ApiModelProperty(value="结束指挥时间",notes="字符长度为：26")
	private Date endTime;
	// fields end

	/**
	 * 非持久化属性
	 */
	@ApiModelProperty("主键集合")
	private List<Long> ids;

	private String title;
	
}
