package com.aifa.mins.event.model.yjzh;

import com.aifa.mins.model.Pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.List;

/**
 * @类名 <p>DrpPlanGroup
 * @描述 DrpPlanGroup类属性
 * <p>1.Long sid		主键ID
 * <p>2.Long userId		用户ID
 * <p>3.Long tenantId		租户ID
 * <p>4.Long orgId		所属部门id
 * <p>5.Long basicInformationId		预案基本信息ID
 * <p>6.String groupName		群组名称
 * <p>7.String groupDes		群组描述
 * <p>8.Date created		创建时间
 * <p>9.Long createdBy		创建人id
 * <p>10.Date lastUpdated		更新时间
 * <p>11.Long lastUpdatedBy		更新人id
 * @数据库表名称: DRP_PLAN_GROUP
 * @数据库表备注: 数字化预案群组表
 * @作者 LYY
 * @日期 2021-11-20 10:57:37
 * @版本 1.0.0
 */
@Data
@ApiModel(value = "DrpPlanGroup对象", description = "数字化预案群组表")
public class DrpPlanGroup extends Pojo {

//	/**
//	 * 	数据验证demo
//	 */
//	@NotNull(message = "xxx不能为空",groups = {Validator.save.class,Validator.update.class})
//	@ApiModelProperty("demo")
//	private Long demo;

    // fields start
    /**
     * 预案基本信息ID
     */
    @ApiModelProperty("预案基本信息ID")
    private Long basicInformationId;
    /**
     * 群组名称
     * 龙跃云 2021-10-26 09:27:40 修改字段描述  从“群组名称”--> "专项指挥机构名称"
     */
    @ApiModelProperty("专项指挥机构名称")
    private String groupName;
    /**
     * 群组描述
     * 龙跃云 2021-10-26 09:27:40 修改字段描述  从“群组描述”--> "职责"
     */
    @ApiModelProperty("职责")
    private String groupDes;


    /**
     * 龙跃云 2021-10-26 09:27:40 新加事件级别（1.重大、特别重大级别突发事件，2.较大级别及敏感突发事件，3.较大临界突发事件，4.一般级别突发事件）字段
     */
    @ApiModelProperty("事件级别（1.重大、特别重大级别突发事件，2.较大级别及敏感突发事件，3.较大临界突发事件，4.一般级别突发事件）")
    private String eventLevel;

    /**
     * 龙跃云 2021-10-26 09:27:40 新加专项指挥机构成员集合属性
     */
    @Transient
    @ApiModelProperty("专项指挥机构成员集合")
    private List<DrpPlanGroupUsers> authorityMemberList;


    /**
     * 经度
     */
    @ApiModelProperty("经度")
    private String longitude;
    /**
     * 纬度
     */
    @ApiModelProperty("纬度")
    private String latitude;
    /**
     * 地址描述
     */
    @ApiModelProperty("地址描述")
    private String locationName;
    // fields end

    ///////////////
    // 非持久化属性
    @ApiModelProperty("主键集合")
    private List<Long> ids;

    @Transient
    @ApiModelProperty("组长userid集合")
    private List<Long> leaderUserIds;

    @Transient
    @ApiModelProperty("组员userid集合")
    private List<Long> crewUserIds;

    @Transient
    @ApiModelProperty("组员集合")
    private List<DrpPlanGroupUsers> drpPlanGroupUsersList;


    @Transient
    @ApiModelProperty("事件等级集合")
    private List<String> drpEventLevelList;

}
