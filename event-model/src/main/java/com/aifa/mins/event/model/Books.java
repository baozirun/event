package com.aifa.mins.event.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;

import com.aifa.mins.model.Pojo;
import com.aifa.mins.model.Validator;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类名 <p>（应用模型开发样例）
 * 
 * @描述 Fields
 * 		<p>1.String sid	   				编号
 * 		<p>2.String name	   			名称
 *      <p>3.String author	  			作者
 *      <p>4.Float	price	  			价格
 *      <p>5.Date 	publishsDate	  	日期
 *      
 * @数据库表名称:		BOOKS
 * @数据库表备注:	 	
 * 
 * @作者	Jason zou
 * @日期	2018-11-6 14:40:15
 * @版本	1.0.0
 *
 */
@Data
public class Books extends Pojo{
	
	private static final long serialVersionUID = 7343403054025771851L;

	
	/**
	 * 书籍名称
	 */
	@NotNull(message = "书籍名称不能为空",groups = {Validator.save.class,Validator.update.class})
	@ApiModelProperty("书籍名称")
	private String name;
	
	/**
	 * 作者
	 */
	@ApiModelProperty("作者")
	private String author;
	
	/**
	 * 价格
	 */
	@ApiModelProperty(value="价格",notes = "单元￥")
	private Float price;
	
	/**
	 * 发布日期
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="发布日期",notes = "时间格式:yyyy-MM-dd HH:mm:ss")
	private Date publishDate;
	
	////////////////
	// 非持久化属性
	private List<Long>  ids;
}
