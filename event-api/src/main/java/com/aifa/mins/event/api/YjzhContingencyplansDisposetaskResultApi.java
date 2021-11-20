package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.yjzh.YjzhContingencyplansDisposetaskResult;
import com.aifa.mins.event.model.yjzh.dto.YjzhPlansDisposetaskResultDto;
import com.aifa.mins.feign.PojoFeignApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @标题 	 Feign Api Client
 * @作者	LYY
 * @日期	2021-11-20 11:07:16
 * @版本	1.0.0
 */
@FeignClient(name="${server.demo.name:demo-server}",
	url="${server.demo.ip:}${server.demo.path:}",path = "/api/contingencyplansDisposetaskResult",
	contextId="YjzhContingencyplansDisposetaskResult",fallbackFactory = YjzhContingencyplansDisposetaskResultHystrix.class )
public interface YjzhContingencyplansDisposetaskResultApi extends PojoFeignApi<YjzhContingencyplansDisposetaskResult>{


	@PostMapping({"/findResult"})
	@ApiOperation("查询事件信息动态")
	Results<List<YjzhPlansDisposetaskResultDto>> findResult(@RequestBody Params<YjzhPlansDisposetaskResultDto> var1);

}
