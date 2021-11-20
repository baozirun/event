package com.aifa.mins.event.model.yjzh.dto;

import com.aifa.mins.model.Pojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类名 <p>YjzhContingencyplansDisposetaskResult
 * 
 * @描述 YjzhContingencyplansDisposetaskResult类属性
 * 		<p>1.Long sid		系统主键
 * 		<p>2.Long tenantId		租户ID
 * 		<p>3.Long despicableId		指令下达ID
 * 		<p>4.String eventId		事件ID
 * 		<p>5.String content		反馈内容
 * 		<p>6.Long createdBy		创建人
 * 		<p>7.Date created		创建时间
 * 		<p>8.Long lastUpdatedBy		最后更新人
 * 		<p>9.Date lastUpdated		最后更新时间
 *      
 * @数据库表名称:		YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT
 * @数据库表备注:	 	
 * 
 * @作者	lux
 * @日期	2021-10-29 13:02:15
 * @版本	1.0.0
 *
 */
@Data
public class YjzhPlansDisposetaskResultDto extends Pojo{
	


	@ApiModelProperty(value="事件ID",notes="字符长度为：100")
	private String eventId;

	@ApiModelProperty(value="内容",notes="字符长度为：65,535")
	private String content;

	@ApiModelProperty(value="联系电话",notes="字符长度为：50")
	private String tel;

	@ApiModelProperty(value="姓名",notes="字符长度为：100")
	private String name;

	@ApiModelProperty(value="类型: 1.指令下达 2.指令反馈 3.公共信息",notes="字符长度为：100")
	private String type;



	
}
