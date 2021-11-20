package com.aifa.mins.event.server;


import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.core.security.SessionService;
import com.aifa.mins.core.security.UserRoles;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.api.YjzhPreventionDangerApi;
import com.aifa.mins.event.model.yjzh.YjzhPreventionDanger;
import com.aifa.mins.ibls.core.LogsUtil;
import com.aifa.mins.ibls.core.LogsUtil.LogType;
import com.aifa.mins.mybatis.DataBaseService;
import com.aifa.mins.mybatis.Updater;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @标题 YjzhPreventionDanger Controller 服务
 * 
 * @作者	pojofactory pojo builder
 * @日期	2021-8-10 17:27:44
 * @版本	1.0.0
 **/
@RefreshScope
@Slf4j
@RestController
@Api(tags = "灾情险情及风险隐患上报信息 管理服务")
@RequestMapping("/yjzh/preventionDanger")
public class YjzhPreventionDangerController implements YjzhPreventionDangerApi {
	/**
	 * 数据访问对象
	 */
	@Autowired
	private DataBaseService dataBaseService;

	/**
	 * 用户会话对象
	 */
	@Autowired
	private SessionService sessionService;




	@Override
	public Results<List<YjzhPreventionDanger>> findByEvent(Params<YjzhPreventionDanger> params) {
		log.debug("进入控制:查询YJZH_PREVENTION_DANGER列表方法,params:{}",params);
		Results<List<YjzhPreventionDanger>> results = new Results<>();
		LogsUtil.set(LogType.Query, "查询YJZH_PREVENTION_DANGER列表");

		AssertUtil.service().notNull(params.getBody(), new String[] {"longitude","latitude"},"参数%s不能为空");
		if(params.getBody()!=null){
			if("".equals(params.getBody().getLatitude())||"".equals(params.getBody().getLongitude())){
				results.setSuccess(false);
				results.setMessage("事件发生地经纬度为空！");
				return results;
			}
		}

		if(params.getBody().getDistance()==null){
			params.getBody().setDistance(1l);//默认1公里
		}


		// 统计数量
		Integer total=dataBaseService.selectOne("countYjzhPreventionDangerByEvent",params);
		params.setTotal(total);
		results.setTotal(total);
		LogsUtil.add("分页数据查询，数据总量count:"+total);

		// 执行查询
		List<YjzhPreventionDanger> rows = dataBaseService.selectListByPage("findYjzhPreventionDangerByEvent", params);
		LogsUtil.add("分页数据查询，记录数量size:"+rows.size());

		results.setBody(rows);
		results.setSuccess(true);
		LogsUtil.success();

		log.debug("退出控制:查询YJZH_PREVENTION_DANGER列表方法,params:{},result:{}",params,results.isSuccess());
		return results;
	}


}
