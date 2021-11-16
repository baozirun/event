package com.aifa.mins.event.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.aifa.mins.feign.PojoFeignApi;

import com.aifa.mins.event.model.Books;

/**
 * @类名 <p>（应用接口开发样例）
 * 
 * @描述
 * 
 * @作者	Jeking Yang
 * @日期	2020-02-19
 * @版本	1.0.0
 *
 */
@FeignClient(name="event",
url="",path = "/books",
contextId="books",fallbackFactory = BooksHystrix.class )
public interface BooksApi extends PojoFeignApi<Books>{
	
	
	
}

