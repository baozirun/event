package com.aifa.mins.event.server;

import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.core.security.SessionService;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.api.YjzhProvisioningApi;
import com.aifa.mins.event.model.yjzh.YjzhProvisioning;
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
 * @标题 YjzhProvisioning Controller 服务
 * 
 * @作者	lux
 * @日期	2021-11-2 14:15:42
 * @版本	1.0.0
 **/
@Slf4j
@RestController
@Api(tags = "资源调配管理服务")
@RequestMapping("/api/provisioning")
public class YjzhProvisioningController implements YjzhProvisioningApi {
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
	public Results<List<YjzhProvisioning>> find(Params<YjzhProvisioning> params) {
		log.debug("进入控制:查询YJZH_PROVISIONING列表方法,params:{}",params);
		Results<List<YjzhProvisioning>> results = new Results<>();
		LogsUtil.set(LogType.Query, "查询YJZH_PROVISIONING列表");


		
		// 统计数量
		Integer total=dataBaseService.selectOne("countYjzhProvisioning",params);
		params.setTotal(total);
		results.setTotal(total);
		LogsUtil.add("分页数据查询，数据总量count:"+total);
		
		// 执行查询
		List<YjzhProvisioning> rows = dataBaseService.selectListByPage("findYjzhProvisioning", params);
		LogsUtil.add("分页数据查询，记录数量size:"+rows.size());
		
		results.setBody(rows);
		results.setSuccess(true);
		LogsUtil.success();

		log.debug("退出控制:查询YJZH_PROVISIONING列表方法,params:{},result:{}",params,results.isSuccess());
		return results;
	}


	@Override
	public Results<Long> save(@Validated(Validator.save.class) YjzhProvisioning entity) {
		log.debug("进入控制:新增YJZH_PROVISIONING信息.entity:{}",entity);
		Results<Long> results = new Results<>();
		LogsUtil.set(LogType.Insert, "新增YJZH_PROVISIONING");
		// 参数处理
		//AssertUtil.service().notNull(entity, new String[] {"appId","name","title"},"参数%s不能为空");
		
		LogsUtil.add("设置默认属性");
		entity.setTenantId(sessionService.getTenantId());
		entity.setOrgId(sessionService.getOrgId());
		entity.setCreated(DateUtil.getSystemDate());
		entity.setCreatedBy(sessionService.getUserId());
		entity.setLastUpdated(DateUtil.getSystemDate());
		entity.setLastUpdatedBy(sessionService.getUserId());
		
		int len = dataBaseService.insert("addYjzhProvisioning", entity);
		LogsUtil.add("保存数据,len:"+len);
		
		results.setBody(entity.getSid());
		results.setSuccess(len>0);
		results.setMessage(len>0?"操作成功":"操作失败");
		LogsUtil.save(len>0, entity.getSid(), entity.getTitle());

		log.debug("退出控制:新增YJZH_PROVISIONING信息.entity:{},result:{}",entity,results.isSuccess());
		return results;
	}


	@Override
	public Results<Long> update(@Validated(Validator.update.class) YjzhProvisioning entity) {
		log.debug("进入控制:修改YJZH_PROVISIONING信息方法，entity:{}",entity);
		Results<Long> results = new Results<>();
		LogsUtil.set(LogType.Modify, "修改YJZH_PROVISIONING",entity.getSid());

		
		String[] fields = {"name","unitMeasure","demandQuantity","transferredQuantity","gapsNumber","destination","deploymentTime"};
		
		entity.setLastUpdated(DateUtil.getSystemDate());
		entity.setLastUpdatedBy(sessionService.getUserId());
		int len = dataBaseService.update("updateYjzhProvisioning", Updater.build(entity).fields(fields));
		LogsUtil.add("保存数据,len:"+len);
		
		results.setBody(entity.getSid());
		results.setSuccess(len>0);
		results.setMessage(len>0?"操作成功":"操作失败");
		LogsUtil.save(len>0, entity.getSid(), entity.getTitle());

		log.debug("退出控制:修改YJZH_PROVISIONING信息方法，entity:{},result:{}",entity,results.isSuccess());
		return results;
	}



	@Override
	public Results<List<YjzhProvisioning>> findByIds(Params<List<Long>> params) {
		log.debug("进入控制:批量查询YJZH_PROVISIONING信息方法，params:{}",params);
		Results<List<YjzhProvisioning>> results = new Results<>();
		LogsUtil.set(LogType.Query, "批量查询YJZH_PROVISIONING");
		// 参数处理
		AssertUtil.service().isTrue(params.getBody()!=null && !params.getBody().isEmpty(), "参数body不能为空");
		
		// 参数处理
		YjzhProvisioning entity=new YjzhProvisioning();
		entity.setIds(params.getBody());

		
		List<YjzhProvisioning> rows= dataBaseService.selectList("findByIdsYjzhProvisioning", entity);
		LogsUtil.add("批量查询数据:"+rows.size());
		
		results.setBody(rows);
		results.setSuccess(true);
		results.setMessage("操作成功");
		LogsUtil.success();

		log.debug("退出控制:批量查询YJZH_PROVISIONING信息方法，params:{},result:{}",params,results.isSuccess());
		return results;
	}


	@Override
	public Results<YjzhProvisioning> detail(Long sid) {
		log.debug("进入控制:查看YJZH_PROVISIONING详细信息方法，sid:{}",sid);
		Results<YjzhProvisioning> results = new Results<>();
		LogsUtil.set(LogType.Query, "查看YJZH_PROVISIONING详细",sid);
		// 参数处理
		AssertUtil.service().notNull(sid,"参数sid不能为空");
		
		// 参数处理
		YjzhProvisioning entity=new YjzhProvisioning();
		entity.setSid(sid);

		
		LogsUtil.add("查找记录");
		YjzhProvisioning tmp = dataBaseService.selectOne("findByIdYjzhProvisioning", entity);
		AssertUtil.service().notNull(tmp, "记录未找到");
					
		results.setBody(tmp);
		results.setSuccess(true);
		results.setMessage("操作成功");
		LogsUtil.success(tmp.getSid(), tmp.getTitle());

		log.debug("退出控制:查看YJZH_PROVISIONING详细信息方法，sid:{},result:{}",sid,results.isSuccess());
		return results;
	}
	

	@Override
	public Results<Long> delete(Params<List<Long>> params){
		log.debug("进入控制:删除YJZH_PROVISIONING信息方法，params:{}",params);
		Results<Long> results = new Results<>();
		LogsUtil.set(LogType.Delete, "删除YJZH_PROVISIONING");
		
		// 参数处理
		AssertUtil.service().isTrue(params.getBody()!=null && !params.getBody().isEmpty(), "参数body不能为空");
		
		// 参数处理
		YjzhProvisioning entity=new YjzhProvisioning();
		entity.setIds(params.getBody());

		
		// 执行删除
		LogsUtil.add("删除数ids:"+ JsonUtil.toJson(entity.getIds()));
		int count = dataBaseService.delete("deleteByIdYjzhProvisioning",entity);
		LogsUtil.add("成功删除记录数量:"+count);
		
		results.setSuccess(count>0);
		results.setMessage(count>0?"操作成功":"操作失败");
		results.setBody((long)count);
		LogsUtil.save(count>0);

		log.debug("退出控制:删除YJZH_PROVISIONING信息方法，params:{},result:{}",params,results.isSuccess());
		return results;
	}


//	@Override
//	public Results<List<YjzhProvisioning>> children(Long sid){
//		log.debug("进入控制:加载下级YJZH_PROVISIONING信息,sid:{}",sid);
//		Results<List<YjzhProvisioning>> results = new Results<>();
//		LogsUtil.set(LogType.Query, "加载下级YJZH_PROVISIONING信息",sid);
//		 //参数处理
//		AssertUtil.service().notNull(sid, "参数sid不能为空");
//		
//		// 执行查询
//        Params<YjzhProvisioning> params = new Params<>();
//        params.setBody(new YjzhProvisioning());
//        params.getBody().setParentId(sid);
//        LogsUtil.add("parentId:"+sid);
//
//		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
//			params.getBody().setTenantId(sessionService.getTenantId());
//			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
//				params.getBody().setOrgId(sessionService.getOrgId());
//			}
//		}
//		List<YjzhProvisioning> rows = dataBaseService.selectList("findYjzhProvisioning", params);
//		LogsUtil.add("下级YJZH_PROVISIONING记录数量:"+rows.size());
//		
//		results.setSuccess(true);
//		results.setBody(rows);
//		LogsUtil.success();
//
//		log.debug("退出控制:加载下级YJZH_PROVISIONING信息,sid:{},result:{}",sid,results.isSuccess());
//		return results;
//	}

}
