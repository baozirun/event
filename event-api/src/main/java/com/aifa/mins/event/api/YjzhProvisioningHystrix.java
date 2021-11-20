package com.aifa.mins.event.api;

import java.util.List;

import com.aifa.mins.event.model.yjzh.YjzhProvisioning;
import org.springframework.stereotype.Component;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.feign.hystrix.HystrixFactory;

/**
 * @标题 YjzhProvisioningApi 服务降级实现
 * @描述 1、可以设置默认降级实现
 *        2、也可以在Spring容器中注册自定义降级，bean name规范为 接口标题（首字母小写）
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 **/
@Component
public class YjzhProvisioningHystrix  extends HystrixFactory<YjzhProvisioningApi> {
    public YjzhProvisioningHystrix(){
        this.setDefaultFallback(new YjzhProvisioningApi(){
        	
        	@Override
			public Results<List<YjzhProvisioning>> find(Params<YjzhProvisioning> params) {
				Results<List<YjzhProvisioning>> result=new Results<>();
                result.setMessage("YjzhProvisioningApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> save(YjzhProvisioning entity) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhProvisioningApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> delete(Params<List<Long>> params) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhProvisioningApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> update(YjzhProvisioning entity) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhProvisioningApi 默认降级消息");
                return result;
			}

			@Override
			public Results<YjzhProvisioning> detail(Long sid) {
				Results<YjzhProvisioning> result=new Results<>();
                result.setMessage("YjzhProvisioningApi 默认降级消息");
                return result;
			}

//			@Override
//			public Results<List<YjzhProvisioning>> children(Long sid) {
//				Results<List<YjzhProvisioning>> result=new Results<>();
//                result.setMessage("YjzhProvisioningApi 默认降级消息");
//                return result;
//			}

			@Override
			public Results<List<YjzhProvisioning>> findByIds(Params<List<Long>> params) {
				Results<List<YjzhProvisioning>> result=new Results<>();
                result.setMessage("YjzhProvisioningApi 默认降级消息");
                return result;
			}

        });
    }
}
