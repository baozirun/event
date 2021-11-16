package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.BaseSjjbjbsj;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * @标题 	事件接报基本数据 Feign Api Client
 * @作者	Caesar
 * @日期	2021-11-16 16:49:51
 * @版本	1.0.0
 */
@FeignClient(name="${server.demo.name:demo-server}",
	url="${server.demo.ip:}${server.demo.path:}",path = "/api/sjjbjbsj",
	contextId="BaseSjjbjbsj",fallbackFactory = BaseSjjbjbsjHystrix.class )
public interface BaseSjjbjbsjApi{

	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	@PostMapping("/find")
	@ApiOperation("分页查询")
	Results<List<BaseSjjbjbsj>> find(Params<BaseSjjbjbsj> params);

	/**
	 * 根据主键列表查询
	 * @param params
	 * @return
	 */
	@PostMapping("findByIds")
	@ApiOperation("根据主键列表查询")
	Results<List<BaseSjjbjbsj>> findByIds(Params<List<String>> params);

	/**
	 * 查询详情
	 * @param sid
	 * @return
	 */
	@PostMapping("detail")
	@ApiOperation("查询详情")
	Results<BaseSjjbjbsj> detail(String sid);
}
