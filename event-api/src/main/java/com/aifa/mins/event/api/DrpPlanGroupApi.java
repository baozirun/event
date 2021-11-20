package com.aifa.mins.event.api;

import com.aifa.mins.event.model.yjzh.DrpPlanGroup;
import com.aifa.mins.feign.PojoFeignApi;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * @标题 	数字化预案群组表 Feign Api Client
 * @作者	LYY
 * @日期	2021-11-20 11:01:51
 * @版本	1.0.0
 */
@FeignClient(name="${server.drp.name:drp-server}",
	url="${server.drp.ip:}${server.drp.path:}",path = "/drp/planGroup",
	contextId="DrpPlanGroup",fallbackFactory = DrpPlanGroupHystrix.class )
public interface DrpPlanGroupApi extends PojoFeignApi<DrpPlanGroup>{
	
}
