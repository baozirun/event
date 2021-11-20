package com.aifa.mins.event.model.yjzh;

import com.aifa.mins.model.Pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.List;

/**
 * @类名 <p>DrpPlanGroupUsers
 * @描述 DrpPlanGroupUsers类属性
 * <p>1.Long sid		主键ID
 * <p>2.Long userId		用户ID
 * <p>3.Long tenantId		租户ID
 * <p>4.Long orgId		所属部门id
 * <p>5.Long planGroupId		数字化预案群组ID
 * <p>6.Integer userType		人员类型（0.组员，1.组长）
 * <p>7.Date created		创建时间
 * <p>8.Long createdBy		创建人id
 * <p>9.Date lastUpdated		更新时间
 * <p>10.Long lastUpdatedBy		更新人id
 * @数据库表名称: DRP_PLAN_GROUP_USERS
 * @数据库表备注: 数字化预案组员
 * @作者 LYY
 * @日期 2021-11-20 10:58:40
 * @版本 1.0.0
 */
@Data
@ApiModel(value = "DrpPlanGroupUsers对象", description = "数字化预案组员")
public class DrpPlanGroupUsers extends Pojo {

//	/**
//	 * 	数据验证demo
//	 */
//	@NotNull(message = "xxx不能为空",groups = {Validator.save.class,Validator.update.class})
//	@ApiModelProperty("demo")
//	private Long demo;

    // fields start
    /**
     * 数字化预案群组ID
     */
    @ApiModelProperty("数字化预案群组ID")
    private Long planGroupId;
    /**
     * 人员类型（0.组员，1.组长）
     */
    @ApiModelProperty("人员类型（0.组员，1.组长）")
    private Integer userType;
    // fields end

    ///////////////
    // 非持久化属性
    @ApiModelProperty("主键集合")
    private List<Long> ids;

    /**
     * 专项指挥机构成员id
     * 龙跃云 2021-10-26 09:33:41 新增
     */
    @ApiModelProperty("专项指挥机构成员id")
    private String authorityMemberId;

    /**
     * 专项指挥机构成员全称
     * 龙跃云 2021-10-26 09:33:41 新增
     */
    @ApiModelProperty("专项指挥机构成员全称")
    private String authorityMemberName;


    @Transient
    @ApiModelProperty("真实姓名")
    private String realName;

    @Transient
    @ApiModelProperty("联系电话")
    private String tel;
}
