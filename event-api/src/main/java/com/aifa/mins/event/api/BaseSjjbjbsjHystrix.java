package com.aifa.mins.event.api;

import java.util.List;
import org.springframework.stereotype.Component;

import com.aifa.mins.event.model.BaseSjjbjbsj;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.feign.hystrix.HystrixFactory;

/**
 * @标题 BaseSjjbjbsjApi 服务降级实现
 * @描述 1、可以设置默认降级实现
 *        2、也可以在Spring容器中注册自定义降级，bean name规范为 接口标题（首字母小写）
 * @作者	Caesar
 * @日期	2021-11-16 16:49:51
 * @版本	1.0.0
 **/
@Component
public class BaseSjjbjbsjHystrix  extends HystrixFactory<BaseSjjbjbsjApi> {
    public BaseSjjbjbsjHystrix(){
        this.setDefaultFallback(new BaseSjjbjbsjApi(){
        	
        	@Override
			public Results<List<BaseSjjbjbsj>> find(Params<BaseSjjbjbsj> params) {
				Results<List<BaseSjjbjbsj>> result=new Results<>();
                result.setMessage("BaseSjjbjbsjApi 默认降级消息");
                return result;
			}

			@Override
			public Results<BaseSjjbjbsj> detail(String sid) {
				Results<BaseSjjbjbsj> result=new Results<>();
                result.setMessage("BaseSjjbjbsjApi 默认降级消息");
                return result;
			}

//			@Override
//			public Results<List<BaseSjjbjbsj>> children(Long sid) {
//				Results<List<BaseSjjbjbsj>> result=new Results<>();
//                result.setMessage("BaseSjjbjbsjApi 默认降级消息");
//                return result;
//			}

			@Override
			public Results<List<BaseSjjbjbsj>> findByIds(Params<List<String>> params) {
				Results<List<BaseSjjbjbsj>> result=new Results<>();
                result.setMessage("BaseSjjbjbsjApi 默认降级消息");
                return result;
			}

			@Override
			public Results<List<BaseSjjbjbsj>> findResubmit(Params<BaseSjjbjbsj> params) {
				Results<List<BaseSjjbjbsj>> result=new Results<>();
                result.setMessage("BaseSjjbjbsjApi 默认降级消息");
                return result;
			}

        });
    }
}
