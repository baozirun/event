package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.yjzh.DrpPlanBasicInformation;
import com.aifa.mins.feign.PojoFeignApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * @标题 	预案基本信息 Feign Api Client
 * @作者	LYY
 * @日期	2021-11-20 10:30:43
 * @版本	1.0.0
 */
@FeignClient(name="${server.drp.name:drp-server}",
	url="${server.drp.ip:}${server.drp.path:}",path = "/drp/planBasicInformation",
	contextId="DrpPlanBasicInformation",fallbackFactory = DrpPlanBasicInformationHystrix.class )
public interface DrpPlanBasicInformationApi extends PojoFeignApi<DrpPlanBasicInformation>{
	@PostMapping({"/findByEventId"})
	@ApiOperation("根据事件id查询预案信息")
	Results<List<DrpPlanBasicInformation>> findByEventId(@RequestBody Params<DrpPlanBasicInformation> params);
}
