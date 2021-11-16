package com.aifa.mins.event.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @类名 <p>BaseSjjbjbsj
 * 
 * @描述 BaseSjjbjbsj类属性
 * 		<p>1.String jbbh		系统内部主键
 * 		<p>2.String xxbt		事件接报信息的标题
 * 		<p>3.String sjbh		突发事件的编号
 * 		<p>4.Date bssj		事件信息的上报时间
 * 		<p>5.String bsfsdm		事件信息的报送方式代码，包括1 （电话）、2 （传真）、3 （系 统）、4 （邮件）、9 （其他）
 * 		<p>6.String bsr		报送事件信息的人员姓名
 * 		<p>7.String bsdw		报送事件信息单位的名称
 * 		<p>8.String bsdwlxdh		报送事件信息单位的联系电话。多个电话用英文逗号分隔
 * 		<p>9.String sjlxdm		突发事件的类型代码
 * 		<p>10.String sjdjdm		突发事件的等级代码，包括1 （特别重大）、2 （重大）、3 （较 大）、4 （一般）
 * 		<p>11.Date sfsj		突发事件的发生时间
 * 		<p>12.String sfdd		突发事件的发生地点
 * 		<p>13.String sfxzhq		突发事件发生地点的行政区划代码，符合4. 3给出的要求
 * 		<p>14.String sjfwxzqh		突发事件影响范围内的行政区划代码。多个行政区划代码间 用英文逗号分隔
 * 		<p>15.String sjms		突发事件基本情况的描述
 * 		<p>16.String zbxtdm		突发事件发生地点平面坐标采用的坐标系统代码，见附录表A. 4
 * 		<p>17.BigDecimal jd		突发事件发生地点的经度。单位为度
 * 		<p>18.BigDecimal wd		突发事件发生地点的纬度。单位为度
 * 		<p>19.String gcjzdm		突发事件发生地点高程采用的高程基准代码，见附录表A. 5
 * 		<p>20.BigDecimal gc		突发事件发生地点的高程。单位为米
 * 		<p>21.String qfr		报送事件信息的签发人姓名
 * 		<p>22.Integer swrs		突发事件中的死亡人数。单位为人
 * 		<p>23.BigDecimal yxbj		突发事件影响范围的半径。单位为公里
 * 		<p>24.String yxcd		突发事件对自然环境、公共基础设施、居民生活、社会治安 等的影响程度
 * 		<p>25.String yxfw		突发事件影响的范围描述
 * 		<p>26.String zjjjss		突发事件造成的直接经济损失。单位为万元
 * 		<p>27.String ssqk		突发事件已造成的各种损失的描述
 * 		<p>28.String ycqqs		已经采取措施的描述
 * 		<p>29.String jzqk		已经进行的灾民救助情况描述
 * 		<p>30.String zyqq		向上级提出的支援请求描述
 * 		<p>31.String jsdw		事件信息的接收单位名称
 * 		<p>32.String jbxxlxdm		事件信息接报状态代码，包括1（首报）、2 （续报）、3 （重 报）、4 （核报）
 * 		<p>33.String ydbzdm		接收单位人员阅读事件信息的标志代码，包括1 （未阅读）、2 （已阅读）
 * 		<p>34.String sjlydw		该数据的来源单位代码，编码规则见附录B
 * 		<p>35.Date zjgxsj		该数据的最近更新时间
 * 		<p>36.String bz		报送单位报送突发事件信息时的备注信息
 * 		<p>37.Integer kblx		快报类别：0市事故快报，1区事故快报
 * 		<p>38.String fsyy		事件发生原因
 * 		<p>39.Integer swzs		伤亡总数
 * 		<p>40.Integer ssrs		受伤人数
 * 		<p>41.Integer xzrs		失踪人数
 * 		<p>42.String xxly		消息来源
 * 		<p>43.Integer ssqzrs		疏散群众人数
 * 		<p>44.Integer cyjyrs		参与救援人数
 * 		<p>45.Date jbsj		接报时间
 * 		<p>46.Date czsj		操作时间
 * 		<p>47.String ebsid		关联事故信息表SID，续报或者转报时，关联原事故记录
 *      
 * @数据库表名称:		BASE_SJJBJBSJ
 * @数据库表备注:	 	事件接报基本数据
 * 
 * @作者	Caesar
 * @日期	2021-11-16 16:49:51
 * @版本	1.0.0
 *
 */
@Data
public class BaseSjjbjbsj{
	
	// fields start
	/**
	 * 系统内部主键
	 */
	@ApiModelProperty(value="系统内部主键",notes="字符长度为：32")
	private String jbbh;
	/**
	 * 事件接报信息的标题
	 */
	@ApiModelProperty(value="事件接报信息的标题",notes="字符长度为：1,000")
	private String xxbt;
	/**
	 * 突发事件的编号
	 */
	@ApiModelProperty(value="突发事件的编号",notes="字符长度为：32")
	private String sjbh;
	/**
	 * 事件信息的上报时间
	 */
	@ApiModelProperty(value="事件信息的上报时间",notes="字符长度为：36")
	private Date bssj;
	/**
	 * 事件信息的报送方式代码，包括1 （电话）、2 （传真）、3 （系 统）、4 （邮件）、9 （其他）
	 */
	@ApiModelProperty(value="事件信息的报送方式代码，包括1 （电话）、2 （传真）、3 （系 统）、4 （邮件）、9 （其他）",notes="字符长度为：1")
	private String bsfsdm;
	/**
	 * 报送事件信息的人员姓名
	 */
	@ApiModelProperty(value="报送事件信息的人员姓名",notes="字符长度为：100")
	private String bsr;
	/**
	 * 报送事件信息单位的名称
	 */
	@ApiModelProperty(value="报送事件信息单位的名称",notes="字符长度为：100")
	private String bsdw;
	/**
	 * 报送事件信息单位的联系电话。多个电话用英文逗号分隔
	 */
	@ApiModelProperty(value="报送事件信息单位的联系电话。多个电话用英文逗号分隔",notes="字符长度为：200")
	private String bsdwlxdh;
	/**
	 * 突发事件的类型代码
	 */
	@ApiModelProperty(value="突发事件的类型代码",notes="字符长度为：10")
	private String sjlxdm;
	/**
	 * 突发事件的等级代码，包括1 （特别重大）、2 （重大）、3 （较 大）、4 （一般）
	 */
	@ApiModelProperty(value="突发事件的等级代码，包括1 （特别重大）、2 （重大）、3 （较 大）、4 （一般）",notes="字符长度为：1")
	private String sjdjdm;
	/**
	 * 突发事件的发生时间
	 */
	@ApiModelProperty(value="突发事件的发生时间",notes="字符长度为：36")
	private Date sfsj;
	/**
	 * 突发事件的发生地点
	 */
	@ApiModelProperty(value="突发事件的发生地点",notes="字符长度为：200")
	private String sfdd;
	/**
	 * 突发事件发生地点的行政区划代码，符合4. 3给出的要求
	 */
	@ApiModelProperty(value="突发事件发生地点的行政区划代码，符合4. 3给出的要求",notes="字符长度为：12")
	private String sfxzhq;
	/**
	 * 突发事件影响范围内的行政区划代码。多个行政区划代码间 用英文逗号分隔
	 */
	@ApiModelProperty(value="突发事件影响范围内的行政区划代码。多个行政区划代码间 用英文逗号分隔",notes="字符长度为：500")
	private String sjfwxzqh;
	/**
	 * 突发事件基本情况的描述
	 */
	@ApiModelProperty(value="突发事件基本情况的描述",notes="字符长度为：2,000")
	private String sjms;
	/**
	 * 突发事件发生地点平面坐标采用的坐标系统代码，见附录表A. 4
	 */
	@ApiModelProperty(value="突发事件发生地点平面坐标采用的坐标系统代码，见附录表 A. 4",notes="字符长度为：1")
	private String zbxtdm;
	/**
	 * 突发事件发生地点的经度。单位为度
	 */
	@ApiModelProperty(value="突发事件发生地点的经度。单位为度",notes="字符长度为：8")
	private BigDecimal jd;
	/**
	 * 突发事件发生地点的纬度。单位为度
	 */
	@ApiModelProperty(value="突发事件发生地点的纬度。单位为度",notes="字符长度为：7")
	private BigDecimal wd;
	/**
	 * 突发事件发生地点高程采用的高程基准代码，见附录表A. 5
	 */
	@ApiModelProperty(value="突发事件发生地点高程采用的高程基准代码，见附录表A. 5",notes="字符长度为：1")
	private String gcjzdm;
	/**
	 * 突发事件发生地点的高程。单位为米
	 */
	@ApiModelProperty(value="突发事件发生地点的高程。单位为米",notes="字符长度为：7")
	private BigDecimal gc;
	/**
	 * 报送事件信息的签发人姓名
	 */
	@ApiModelProperty(value="报送事件信息的签发人姓名",notes="字符长度为：100")
	private String qfr;
	/**
	 * 突发事件中的死亡人数。单位为人
	 */
	@ApiModelProperty(value="突发事件中的死亡人数。单位为人",notes="字符长度为：10")
	private Integer swrs;
	/**
	 * 突发事件影响范围的半径。单位为公里
	 */
	@ApiModelProperty(value="突发事件影响范围的半径。单位为公里",notes="字符长度为：11")
	private BigDecimal yxbj;
	/**
	 * 突发事件对自然环境、公共基础设施、居民生活、社会治安 等的影响程度
	 */
	@ApiModelProperty(value="突发事件对自然环境、公共基础设施、居民生活、社会治安 等的影响程度",notes="字符长度为：1,000")
	private String yxcd;
	/**
	 * 突发事件影响的范围描述
	 */
	@ApiModelProperty(value="突发事件影响的范围描述",notes="字符长度为：2,000")
	private String yxfw;
	/**
	 * 突发事件造成的直接经济损失。单位为万元
	 */
	@ApiModelProperty(value="突发事件造成的直接经济损失。单位为万元",notes="字符长度为：2,000")
	private String zjjjss;
	/**
	 * 突发事件已造成的各种损失的描述
	 */
	@ApiModelProperty(value="突发事件已造成的各种损失的描述",notes="字符长度为：1,000")
	private String ssqk;
	/**
	 * 已经采取措施的描述
	 */
	@ApiModelProperty(value="已经采取措施的描述",notes="字符长度为：1,000")
	private String ycqqs;
	/**
	 * 已经进行的灾民救助情况描述
	 */
	@ApiModelProperty(value="已经进行的灾民救助情况描述",notes="字符长度为：1,000")
	private String jzqk;
	/**
	 * 向上级提出的支援请求描述
	 */
	@ApiModelProperty(value="向上级提出的支援请求描述",notes="字符长度为：1,000")
	private String zyqq;
	/**
	 * 事件信息的接收单位名称
	 */
	@ApiModelProperty(value="事件信息的接收单位名称",notes="字符长度为：100")
	private String jsdw;
	/**
	 * 事件信息接报状态代码，包括1（首报）、2 （续报）、3 （重 报）、4 （核报）
	 */
	@ApiModelProperty(value="事件信息接报状态代码，包括1（首报）、2 （续报）、3 （重 报）、4 （核报）",notes="字符长度为：1")
	private String jbxxlxdm;
	/**
	 * 接收单位人员阅读事件信息的标志代码，包括1 （未阅读）、2 （已阅读）
	 */
	@ApiModelProperty(value="接收单位人员阅读事件信息的标志代码，包括1 （未阅读）、 2 （已阅读）",notes="字符长度为：1")
	private String ydbzdm;
	/**
	 * 该数据的来源单位代码，编码规则见附录B
	 */
	@ApiModelProperty(value="该数据的来源单位代码，编码规则见附录B",notes="字符长度为：9")
	private String sjlydw;
	/**
	 * 该数据的最近更新时间
	 */
	@ApiModelProperty(value="该数据的最近更新时间",notes="字符长度为：36")
	private Date zjgxsj;
	/**
	 * 报送单位报送突发事件信息时的备注信息
	 */
	@ApiModelProperty(value="报送单位报送突发事件信息时的备注信息",notes="字符长度为：500")
	private String bz;
	/**
	 * 快报类别：0市事故快报，1区事故快报
	 */
	@ApiModelProperty(value="快报类别：0市事故快报，1区事故快报",notes="字符长度为：10")
	private Integer kblx;
	/**
	 * 事件发生原因
	 */
	@ApiModelProperty(value="事件发生原因",notes="字符长度为：2,147,483,647")
	private String fsyy;
	/**
	 * 伤亡总数
	 */
	@ApiModelProperty(value="伤亡总数",notes="字符长度为：10")
	private Integer swzs;
	/**
	 * 受伤人数
	 */
	@ApiModelProperty(value="受伤人数",notes="字符长度为：10")
	private Integer ssrs;
	/**
	 * 失踪人数
	 */
	@ApiModelProperty(value="失踪人数",notes="字符长度为：10")
	private Integer xzrs;
	/**
	 * 消息来源
	 */
	@ApiModelProperty(value="消息来源",notes="字符长度为：50")
	private String xxly;
	/**
	 * 疏散群众人数
	 */
	@ApiModelProperty(value="疏散群众人数",notes="字符长度为：10")
	private Integer ssqzrs;
	/**
	 * 参与救援人数
	 */
	@ApiModelProperty(value="参与救援人数",notes="字符长度为：10")
	private Integer cyjyrs;
	/**
	 * 接报时间
	 */
	@ApiModelProperty(value="接报时间",notes="字符长度为：36")
	private Date jbsj;
	/**
	 * 操作时间
	 */
	@ApiModelProperty(value="操作时间",notes="字符长度为：36")
	private Date czsj;
	/**
	 * 关联事故信息表SID，续报或者转报时，关联原事故记录
	 */
	@ApiModelProperty(value="关联事故信息表SID，续报或者转报时，关联原事故记录",notes="字符长度为：50")
	private String ebsid;
	// fields end

	/**
	 * 非持久化属性
	 */
	@ApiModelProperty("主键集合")
	private List<String> ids;
	
}
