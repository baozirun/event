package com.aifa.mins.event.model.yjzh;

import com.aifa.mins.model.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;

/**
 * @类名 <p>DrpPlanBasicInformation
 * @描述 DrpPlanBasicInformation类属性
 * <p>1.Long sid		主键ID
 * <p>2.Long userId		用户ID
 * <p>3.Long tenantId		租户ID
 * <p>4.Long orgId		所属部门id
 * <p>5.String planNumber		预案编号
 * <p>6.String planName		预案名称
 * <p>7.String versionNumber		版本号
 * <p>8.Integer planCategory		预案类别（1.综合类应急预案，2.专项应急预案，3.现场应急预案，4.单项应急预案）
 * <p>9.String scope		适用范围
 * <p>10.Integer eventLevel		事件级别（1.特别严重(I级)，2.严重(II级)，3.较大事故(III级)，4.一般事故(IV级)）
 * <p>11.String eventType		事件类别（多个类别以逗号隔开）
 * <p>12.String planThe		预案摘要
 * <p>13.Integer planStatus		预案状态（0.草稿，1.待审核，2.审核通过，3.审核不通过）
 * <p>14.Long auditUserId		审核人ID
 * <p>15.Date auditTime		审核时间
 * <p>16.Date releaseTime		发布时间
 * <p>17.Integer isDelete		是否删除（0.否，1.是）
 * <p>18.Date created		创建时间
 * <p>19.Long createdBy		创建人id
 * <p>20.Date lastUpdated		更新时间
 * <p>21.Long lastUpdatedBy		更新人id
 * @数据库表名称: DRP_PLAN_BASIC_INFORMATION
 * @数据库表备注: 预案基本信息
 * @作者 LYY
 * @日期 2021-11-20 10:31:35
 * @版本 1.0.0
 */
@Data
@ApiModel(value = "DrpPlanBasicInformation对象", description = "预案基本信息")
public class DrpPlanBasicInformation extends Pojo {

    //	/**
    //	 * 	数据验证demo
    //	 */
    //	@NotNull(message = "xxx不能为空",groups = {Validator.save.class,Validator.update.class})
    //	@ApiModelProperty("demo")
    //	private Long demo;
    //2021-10-21 16:49:49 龙跃云修改了planClassification->postDisposal的字段
    //2021-10-27 14:06:11 新增 LOCATION HEADQUARTERS_OFFICE字段

    // fields start
    /**
     * 预案模板ID
     */
    @ApiModelProperty("预案模板ID")
    private Long planTemplateId;
    /**
     * 预案编号
     */
    @ApiModelProperty("预案编号")
    private String planNumber;
    /**
     * 预案名称
     */
    @ApiModelProperty("预案名称")
    private String planName;
    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    private String versionNumber;
    /**
     * 预案类型（1.总体预案，2.专项预案，3.部门预案，4.单位和基层组织预案，5其他预案
     */
    @ApiModelProperty("预案类型（1.总体预案，2.专项预案，3.部门预案，4.单位和基层组织预案，5.其他预案）")
    private Integer planCategory;
    /**
     * 适用范围
     */
    @ApiModelProperty("适用范围")
    private String scope;
    /**
     * 事件级别（1.重大、特别重大级别突发事件，2.较大级别及敏感突发事件，3.较大临界突发事件，4.一般级别突发事件）
     */
    @ApiModelProperty("事件级别（1.重大、特别重大级别突发事件，2.较大级别及敏感突发事件，3.较大临界突发事件，4.一般级别突发事件）")
    private Integer eventLevel;
    /**
     * 事件类别（多个类别以逗号隔开，'27':'自然灾害','26':'地质伤害','25':'森林火灾','6':'车辆伤害','28':'其他','3':'道路交通','4':'水上交通','5':'物体打击','6':'车辆伤害','7':'机械伤害','1':'矿工企业','2':'火灾','9':'触电','23':'中毒和窒息','14':'坍塌','11':'灼烫','21':'容器爆炸','8':'起重伤害','20':'锅炉爆炸','22':'其他爆炸','10':'淹溺','12':'危化事故','24':'其他伤害'）
     */
    @ApiModelProperty("事件类型（多个类别以逗号隔开，'27':'自然灾害','26':'地质伤害','25':'森林火灾','6':'车辆伤害','28':'其他','3':'道路交通','4':'水上交通','5':'物体打击','6':'车辆伤害','7':'机械伤害','1':'矿工企业','2':'火灾','9':'触电','23':'中毒和窒息','14':'坍塌','11':'灼烫','21':'容器爆炸','8':'起重伤害','20':'锅炉爆炸','22':'其他爆炸','10':'淹溺','12':'危化事故','24':'其他伤害'）")
    private String eventType;
    /**
     * 预案摘要
     */
    @ApiModelProperty("总则（预案摘要）")
    private String planThe;
    /**
     * 预案状态（0:'草稿',1:'待审核',2:'审核不通过',3:'审核通过'）
     */
    @ApiModelProperty("预案状态（0:'草稿',1:'待审核',2:'审核不通过',3:'审核通过'）")
    private Integer planStatus;

    /**
     * 预案分级(0.国家级应急预案、1.省级应急预案、2.市级应急预案、3.区级应急预案、4.街镇级应急预案、5.社区级应急预案、6.企业级应急预案)")
     */
    @ApiModelProperty("预案分级(0.国家级应急预案、1.省级应急预案、2.市级应急预案、3.区级应急预案、4.街镇级应急预案、5.社区级应急预案、6.企业级应急预案)")
    private String planClassification;

    /**
     * 文号
     */
    @ApiModelProperty("文号")
    private String documentNumber;

    /**
     * 编制部门
     */
    @ApiModelProperty("编制部门")
    private String preparationDepartment;

    /**
     * 印发部门
     */
    @ApiModelProperty("印发部门")
    private String issuingDepartment;

    /**
     * 印发日期
     */
    @ApiModelProperty(
            value = "印发日期",
            notes = "时间格式:yyyy-MM-dd"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date issueTime;

    /**
     * 预警报告
     */
    @ApiModelProperty("预警报告")
    private String earlywarningReport;

    /**
     * 应急保障
     */
    @ApiModelProperty("应急保障")
    private String emergencySupport;


    /**
     * 后期处置
     */
    @ApiModelProperty("后期处置")
    private String postDisposal;


    /**
     * 位置信息
     */
    @ApiModelProperty("区域位置信息")
    private String location;


    /**
     * 指挥部办公室
     */
    @ApiModelProperty("指挥部办公室")
    private String headquartersOffice;

    /**
     * 审核人ID
     */
    @ApiModelProperty("审核人ID")
    private Long auditUserId;
    /**
     * 审核时间
     */
    @ApiModelProperty(
            value = "审核时间",
            notes = "时间格式:yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date auditTime;
    /**
     * 发布日期
     */
    @ApiModelProperty(
            value = "发布日期",
            notes = "时间格式:yyyy-MM-dd"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date releaseTime;
    /**
     * 是否删除（0.否，1.是）
     */
    @ApiModelProperty("是否删除（0.否，1.是）")
    private Integer isDelete;
    /**
     * 工作流程模型ID
     */
    @ApiModelProperty("工作流程模型ID")
    private String flowModelId;
    /**
     * 模型json数据
     */
    @ApiModelProperty("模型json数据")
    private String modelJson;
    // fields end

    ///////////////
    // 非持久化属性
    @ApiModelProperty("主键集合")
    private List<Long> ids;

    @ApiModelProperty("是否不用过滤草稿状态")
    @Transient
    private Boolean isFilterDraft;

    /**
     * 突发事件id
     */
    @ApiModelProperty(value="突发事件id",notes="字符长度为：100")
    @Transient
    private String eventId;



}
