package com.aifa.mins.event.api;

import java.util.List;

import com.aifa.mins.event.model.yjzh.YjzhPreventionDanger;
import org.springframework.stereotype.Component;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.feign.hystrix.HystrixFactory;

/**
 * @标题 YjzhPreventionDangerApi 服务降级实现
 * @描述 1、可以设置默认降级实现
 *        2、也可以在Spring容器中注册自定义降级，bean name规范为 接口标题（首字母小写）
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 **/
@Component
public class YjzhPreventionDangerHystrix  extends HystrixFactory<YjzhPreventionDangerApi> {
    public YjzhPreventionDangerHystrix(){
        this.setDefaultFallback(new YjzhPreventionDangerApi(){

			@Override
			public Results<List<YjzhPreventionDanger>> findByEvent(Params<YjzhPreventionDanger> var1) {
				Results<List<YjzhPreventionDanger>> result=new Results<>();
				result.setMessage("YjzhPreventionDangerApi 默认降级消息");
				return result;
			}

        });
    }
}
