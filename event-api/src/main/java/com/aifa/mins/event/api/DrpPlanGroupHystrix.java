package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.yjzh.DrpPlanGroup;
import com.aifa.mins.feign.hystrix.HystrixFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @标题 DrpPlanGroupApi 服务降级实现
 * @描述 1、可以设置默认降级实现
 *        2、也可以在Spring容器中注册自定义降级，bean name规范为 接口标题（首字母小写）
 * @作者	LYY
 * @日期	2021-11-20 11:01:59
 * @版本	1.0.0
 **/
@Component
public class DrpPlanGroupHystrix  extends HystrixFactory<DrpPlanGroupApi> {
    public DrpPlanGroupHystrix(){
        this.setDefaultFallback(new DrpPlanGroupApi(){
        	
        	@Override
			public Results<List<DrpPlanGroup>> find(Params<DrpPlanGroup> params) {
				Results<List<DrpPlanGroup>> result=new Results<>();
                result.setMessage("DrpPlanGroupApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> save(DrpPlanGroup entity) {
				Results<Long> result=new Results<>();
                result.setMessage("DrpPlanGroupApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> delete(Params<List<Long>> params) {
				Results<Long> result=new Results<>();
                result.setMessage("DrpPlanGroupApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> update(DrpPlanGroup entity) {
				Results<Long> result=new Results<>();
                result.setMessage("DrpPlanGroupApi 默认降级消息");
                return result;
			}

			@Override
			public Results<DrpPlanGroup> detail(Long sid) {
				Results<DrpPlanGroup> result=new Results<>();
                result.setMessage("DrpPlanGroupApi 默认降级消息");
                return result;
			}

//			@Override
//			public Results<List<DrpPlanGroup>> children(Long sid) {
//				Results<List<DrpPlanGroup>> result=new Results<>();
//                result.setMessage("DrpPlanGroupApi 默认降级消息");
//                return result;
//			}

			@Override
			public Results<List<DrpPlanGroup>> findByIds(Params<List<Long>> params) {
				Results<List<DrpPlanGroup>> result=new Results<>();
                result.setMessage("DrpPlanGroupApi 默认降级消息");
                return result;
			}

        });
    }
}
