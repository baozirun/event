package com.aifa.mins.event.api;

import com.aifa.mins.event.model.yjzh.YjzhDisasterReliefTeam;
import org.springframework.cloud.openfeign.FeignClient;

import com.aifa.mins.feign.PojoFeignApi;


/**
 * @标题 	 Feign Api Client
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 */
@FeignClient(name="${server.demo.name:demo-server}",
	url="${server.demo.ip:}${server.demo.path:}",path = "/api/disasterReliefTeam",
	contextId="YjzhDisasterReliefTeam",fallbackFactory = YjzhDisasterReliefTeamHystrix.class )
public interface YjzhDisasterReliefTeamApi extends PojoFeignApi<YjzhDisasterReliefTeam>{
	
}
