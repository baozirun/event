package com.aifa.mins.event.api;

import java.util.List;

import com.aifa.mins.event.model.yjzh.YjzhDisasterReliefTeam;
import org.springframework.stereotype.Component;


import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.feign.hystrix.HystrixFactory;

/**
 * @标题 YjzhDisasterReliefTeamApi 服务降级实现
 * @描述 1、可以设置默认降级实现
 *        2、也可以在Spring容器中注册自定义降级，bean name规范为 接口标题（首字母小写）
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 **/
@Component
public class YjzhDisasterReliefTeamHystrix  extends HystrixFactory<YjzhDisasterReliefTeamApi> {
    public YjzhDisasterReliefTeamHystrix(){
        this.setDefaultFallback(new YjzhDisasterReliefTeamApi(){
        	
        	@Override
			public Results<List<YjzhDisasterReliefTeam>> find(Params<YjzhDisasterReliefTeam> params) {
				Results<List<YjzhDisasterReliefTeam>> result=new Results<>();
                result.setMessage("YjzhDisasterReliefTeamApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> save(YjzhDisasterReliefTeam entity) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhDisasterReliefTeamApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> delete(Params<List<Long>> params) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhDisasterReliefTeamApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> update(YjzhDisasterReliefTeam entity) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhDisasterReliefTeamApi 默认降级消息");
                return result;
			}

			@Override
			public Results<YjzhDisasterReliefTeam> detail(Long sid) {
				Results<YjzhDisasterReliefTeam> result=new Results<>();
                result.setMessage("YjzhDisasterReliefTeamApi 默认降级消息");
                return result;
			}

//			@Override
//			public Results<List<YjzhDisasterReliefTeam>> children(Long sid) {
//				Results<List<YjzhDisasterReliefTeam>> result=new Results<>();
//                result.setMessage("YjzhDisasterReliefTeamApi 默认降级消息");
//                return result;
//			}

			@Override
			public Results<List<YjzhDisasterReliefTeam>> findByIds(Params<List<Long>> params) {
				Results<List<YjzhDisasterReliefTeam>> result=new Results<>();
                result.setMessage("YjzhDisasterReliefTeamApi 默认降级消息");
                return result;
			}

        });
    }
}
