package com.aifa.mins.event.api;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.feign.hystrix.HystrixFactory;

import com.aifa.mins.event.model.Books;

/**
 * @类名
 *     BooksApi 服务降级实现
 * 
 * @描述 1、可以设置默认降级实现
 *       2、也可以在Spring容器中注册自定义降级，bean name规范为 接口类名（首字母小写）
 * 
 * @作者 Jeking Yang
 * @日期 2019-11-21
 * @版本 1.0.0
 */
@Component
public class BooksHystrix extends HystrixFactory<BooksApi> {

    public BooksHystrix() {
        // 设置默认降级实现
        this.setDefaultFallback(new BooksApi() {

        	@Override
			public Results<List<Books>> find(Params<Books> params) {
				Results<List<Books>> result=new Results<>();
                result.setMessage("BooksApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> save(Books entity) {
				Results<Long> result=new Results<>();
                result.setMessage("BooksApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> delete(Params<List<Long>> params) {
				Results<Long> result=new Results<>();
                result.setMessage("BooksApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> update(Books entity) {
				Results<Long> result=new Results<>();
                result.setMessage("BooksApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Books> detail(Long sid) {
				Results<Books> result=new Results<>();
                result.setMessage("BooksApi 默认降级消息");
                return result;
			}

			@Override
			public Results<List<Books>> findByIds(Params<List<Long>> params) {
				Results<List<Books>> result=new Results<>();
                result.setMessage("BooksApi 默认降级消息");
                return result;
			}
          
        });
    }
    
}