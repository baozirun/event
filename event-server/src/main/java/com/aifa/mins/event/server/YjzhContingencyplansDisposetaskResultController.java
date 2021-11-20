package com.aifa.mins.event.server;

import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.core.security.SessionService;
import com.aifa.mins.core.security.UserRoles;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.api.YjzhContingencyplansDisposetaskResultApi;
import com.aifa.mins.event.model.yjzh.YjzhContingencyplansDisposetaskResult;
import com.aifa.mins.event.model.yjzh.dto.YjzhPlansDisposetaskResultDto;
import com.aifa.mins.ibls.core.LogsUtil;
import com.aifa.mins.ibls.core.LogsUtil.LogType;
import com.aifa.mins.model.Validator;
import com.aifa.mins.mybatis.DataBaseService;
import com.aifa.mins.mybatis.Updater;
import com.aifa.mins.utils.DateUtil;
import com.aifa.mins.utils.JsonUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @标题 YjzhContingencyplansDisposetaskResult Controller 服务
 * 
 * @作者	lux
 * @日期	2021-10-28 15:24:06
 * @版本	1.0.0
 **/
@Slf4j
@RestController
@Api(tags = "事件事态跟踪管理服务")
@RequestMapping("/api/contingencyplansDisposetaskResult")
public class YjzhContingencyplansDisposetaskResultController implements YjzhContingencyplansDisposetaskResultApi {
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
	public Results<List<YjzhPlansDisposetaskResultDto>> findResult(Params<YjzhPlansDisposetaskResultDto> params) {
		log.debug("进入控制:查询YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT列表方法,params:{}",params);
		Results<List<YjzhPlansDisposetaskResultDto>> results = new Results<>();
		LogsUtil.set(LogType.Query, "查询YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT列表");

		// 执行查询
		List<YjzhPlansDisposetaskResultDto> rows = dataBaseService.selectList("findYjzhPlansDisposetaskResult", params);
		LogsUtil.add("分页数据查询，记录数量size:"+rows.size());
		
		results.setBody(rows);
		results.setSuccess(true);
		LogsUtil.success();

		log.debug("退出控制:查询YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT列表方法,params:{},result:{}",params,results.isSuccess());
		return results;
	}


	@Override
	public Results<Long> save(@Validated(Validator.save.class) YjzhContingencyplansDisposetaskResult entity) {
		log.debug("进入控制:新增YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息.entity:{}",entity);
		Results<Long> results = new Results<>();
		LogsUtil.set(LogType.Insert, "新增YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT");
		// 参数处理
		//AssertUtil.service().notNull(entity, new String[] {"appId","name","title"},"参数%s不能为空");
		
		LogsUtil.add("设置默认属性");
		entity.setTenantId(sessionService.getTenantId());
		entity.setOrgId(sessionService.getOrgId());
		entity.setCreated(DateUtil.getSystemDate());
		entity.setCreatedBy(sessionService.getUserId());
		entity.setLastUpdated(DateUtil.getSystemDate());
		entity.setLastUpdatedBy(sessionService.getUserId());
		
		int len = dataBaseService.insert("addYjzhContingencyplansDisposetaskResult", entity);
		LogsUtil.add("保存数据,len:"+len);
		
		results.setBody(entity.getSid());
		results.setSuccess(len>0);
		results.setMessage(len>0?"操作成功":"操作失败");
		LogsUtil.save(len>0, entity.getSid(), entity.getTitle());

		log.debug("退出控制:新增YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息.entity:{},result:{}",entity,results.isSuccess());
		return results;
	}


	@Override
	public Results<Long> update(@Validated(Validator.update.class) YjzhContingencyplansDisposetaskResult entity) {
		log.debug("进入控制:修改YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息方法，entity:{}",entity);
		Results<Long> results = new Results<>();
		LogsUtil.set(LogType.Modify, "修改YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT",entity.getSid());
		// 参数处理
		//AssertUtil.service().notNull(entity, new String[] {"sid","appId","name","title"},"参数%s不能为空");
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		String[] fields = {"taskId","eventId","content"};
		
		entity.setLastUpdated(DateUtil.getSystemDate());
		entity.setLastUpdatedBy(sessionService.getUserId());
		int len = dataBaseService.update("updateYjzhContingencyplansDisposetaskResult", Updater.build(entity).fields(fields));
		LogsUtil.add("保存数据,len:"+len);
		
		results.setBody(entity.getSid());
		results.setSuccess(len>0);
		results.setMessage(len>0?"操作成功":"操作失败");
		LogsUtil.save(len>0, entity.getSid(), entity.getTitle());

		log.debug("退出控制:修改YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息方法，entity:{},result:{}",entity,results.isSuccess());
		return results;
	}


	@Override
	public Results<List<YjzhContingencyplansDisposetaskResult>> find(Params<YjzhContingencyplansDisposetaskResult> params) {
		return null;
	}

	@Override
	public Results<List<YjzhContingencyplansDisposetaskResult>> findByIds(Params<List<Long>> params) {
		log.debug("进入控制:批量查询YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息方法，params:{}",params);
		Results<List<YjzhContingencyplansDisposetaskResult>> results = new Results<>();
		LogsUtil.set(LogType.Query, "批量查询YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT");
		// 参数处理
		AssertUtil.service().isTrue(params.getBody()!=null && !params.getBody().isEmpty(), "参数body不能为空");
		
		// 参数处理
		YjzhContingencyplansDisposetaskResult entity=new YjzhContingencyplansDisposetaskResult();
		entity.setIds(params.getBody());
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		List<YjzhContingencyplansDisposetaskResult> rows= dataBaseService.selectList("findByIdsYjzhContingencyplansDisposetaskResult", entity);
		LogsUtil.add("批量查询数据:"+rows.size());
		
		results.setBody(rows);
		results.setSuccess(true);
		results.setMessage("操作成功");
		LogsUtil.success();

		log.debug("退出控制:批量查询YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息方法，params:{},result:{}",params,results.isSuccess());
		return results;
	}


	@Override
	public Results<YjzhContingencyplansDisposetaskResult> detail(Long sid) {
		log.debug("进入控制:查看YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT详细信息方法，sid:{}",sid);
		Results<YjzhContingencyplansDisposetaskResult> results = new Results<>();
		LogsUtil.set(LogType.Query, "查看YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT详细",sid);
		// 参数处理
		AssertUtil.service().notNull(sid,"参数sid不能为空");
		
		// 参数处理
		YjzhContingencyplansDisposetaskResult entity=new YjzhContingencyplansDisposetaskResult();
		entity.setSid(sid);
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		LogsUtil.add("查找记录");
		YjzhContingencyplansDisposetaskResult tmp = dataBaseService.selectOne("findByIdYjzhContingencyplansDisposetaskResult", entity);
		AssertUtil.service().notNull(tmp, "记录未找到");
					
		results.setBody(tmp);
		results.setSuccess(true);
		results.setMessage("操作成功");
		LogsUtil.success(tmp.getSid(), tmp.getTitle());

		log.debug("退出控制:查看YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT详细信息方法，sid:{},result:{}",sid,results.isSuccess());
		return results;
	}
	

	@Override
	public Results<Long> delete(Params<List<Long>> params){
		log.debug("进入控制:删除YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息方法，params:{}",params);
		Results<Long> results = new Results<>();
		LogsUtil.set(LogType.Delete, "删除YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT");
		
		// 参数处理
		AssertUtil.service().isTrue(params.getBody()!=null && !params.getBody().isEmpty(), "参数body不能为空");
		
		// 参数处理
		YjzhContingencyplansDisposetaskResult entity=new YjzhContingencyplansDisposetaskResult();
		entity.setIds(params.getBody());
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		// 执行删除
		LogsUtil.add("删除数ids:"+JsonUtil.toJson(entity.getIds()));
		int count = dataBaseService.delete("deleteByIdYjzhContingencyplansDisposetaskResult",entity);
		LogsUtil.add("成功删除记录数量:"+count);
		
		results.setSuccess(count>0);
		results.setMessage(count>0?"操作成功":"操作失败");
		results.setBody((long)count);
		LogsUtil.save(count>0);

		log.debug("退出控制:删除YJZH_CONTINGENCYPLANS_DISPOSETASK_RESULT信息方法，params:{},result:{}",params,results.isSuccess());
		return results;
	}

}
