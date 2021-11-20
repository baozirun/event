package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.yjzh.YjzhContingencyplansDisposeDespicable;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;


import com.aifa.mins.feign.PojoFeignApi;
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
	url="${server.demo.ip:}${server.demo.path:}",path = "/api/contingencyplansDisposeDespicable",
	contextId="YjzhContingencyplansDisposeDespicable",fallbackFactory = YjzhContingencyplansDisposeDespicableHystrix.class )
public interface YjzhContingencyplansDisposeDespicableApi {

	@PostMapping({"/find"})
	@ApiOperation("任务指派（入参事件id: eventId）")
	Results<List<YjzhContingencyplansDisposeDespicable>> find(@RequestBody Params<YjzhContingencyplansDisposeDespicable> var1);
}
