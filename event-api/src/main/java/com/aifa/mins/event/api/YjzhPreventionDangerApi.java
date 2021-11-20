package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.yjzh.YjzhPreventionDanger;
import com.aifa.mins.feign.PojoFeignApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @标题 	 Feign Api Client
 * @作者	lux
 * @日期	2021-11-20 9:31:03
 * @版本	1.0.0
 */
@FeignClient(name="${server.demo.name:demo-server}",
	url="${server.demo.ip:}${server.demo.path:}",path = "/api/preventionDanger",
	contextId="YjzhPreventionDanger",fallbackFactory = YjzhPreventionDangerHystrix.class )
public interface YjzhPreventionDangerApi {

	@PostMapping({"/findByEvent"})
	@ApiOperation("临时风险源：根据事件范围查询隐患点(入参：事件发生经度和纬度)")
	Results<List<YjzhPreventionDanger>> findByEvent(@RequestBody Params<YjzhPreventionDanger> var1);

}
