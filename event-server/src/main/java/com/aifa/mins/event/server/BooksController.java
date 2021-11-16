package com.aifa.mins.event.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.core.exception.ServiceException;
import com.aifa.mins.core.security.SessionService;
import com.aifa.mins.core.security.UserRoles;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.ibls.core.LogsUtil;
import com.aifa.mins.ibls.core.LogsUtil.LogType;
import com.aifa.mins.model.Validator;

import com.aifa.mins.event.api.BooksApi;
import com.aifa.mins.event.model.Books;
import com.aifa.mins.mybatis.DataBaseService;
import com.aifa.mins.mybatis.Updater;
import com.aifa.mins.utils.BeanUtil;
import com.aifa.mins.utils.DateUtil;
import com.aifa.mins.utils.JsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @类名 <p>（应用服务开发样例）
 * 
 * @描述
 * 
 * @作者	Jason zou
 * @日期	2018-11-06
 * @版本	1.0.0
 *
 */
@Slf4j
@RestController
@Api(tags="书籍管理接口")
@RequestMapping("/books")
public class BooksController implements BooksApi{
	
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
	public Results<List<Books>> find(Params<Books> params){
		log.debug("进入控制:查询书籍信息方法,prama:{}",params);
		LogsUtil.set(LogType.Query, "查询书籍信息");
		
		// 参数处理
		// .....
		AssertUtil.service().notNull(params.getBody(),new String[] {"author","name"}, "参数%s不能为空");
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			params.getBody().setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				params.getBody().setOrgId(sessionService.getOrgId());
			}
		}
		
		// 统计数据总量
		Integer total=dataBaseService.selectOne("countBooks",params);
		params.setTotal(total);
		LogsUtil.add("分页数据查询，数据总量count:"+total);
		
		// 执行分页查询
		List<Books> rows=dataBaseService.selectListByPage("findBooks", params);
		LogsUtil.add("分页数据查询，记录数量size:"+rows.size());
		
		Results<List<Books>> results=Results.success(rows).setTotal(total);
		LogsUtil.success();
		
		log.debug("退出控制:查询书籍信息方法,prama:{},results:{}",params,results.isSuccess());
		return results;
	}
	
	@Override
	public Results<Long> save(@Validated(Validator.save.class) Books entity) {
		log.debug("进入控制:新增书籍信息方法,entry:{}",entity);
		LogsUtil.set(LogType.Insert, "新增书籍信息");
		
		// 参数处理
		//AssertUtil.service().notNull(entry.getName(), "书籍名称不能为空");
		
		LogsUtil.add("设置默认属性");
		entity.setTenantId(sessionService.getTenantId());
		entity.setOrgId(sessionService.getOrgId());
		entity.setCreated(DateUtil.getSystemDate());
		entity.setCreatedBy(sessionService.getUserId());
		entity.setLastUpdated(DateUtil.getSystemDate());
		entity.setLastUpdatedBy(sessionService.getUserId());
		
		int len = dataBaseService.insert("addBooks",entity);
		LogsUtil.add("保存数据,len:"+len);
		
		// 设置响应
		Results<Long> results = Results.build(len>0,entity.getSid());
		LogsUtil.save(len>0, entity.getSid(), entity.getName());
		
		log.debug("退出控制:新增书籍信息方法,entry:{},sid:{},results:{}",entity,results.getBody(),results.isSuccess());
		return results;
	}


	@Override
	@PostMapping("/update")
	@ApiOperation(value="修改",notes="修改书籍信息,只能修改：{\"author\",\"name\",\"price\"}")
	public Results<Long> update(@Validated(Validator.update.class) Books entity) {
		log.debug("进入控制:修改书籍信息方法,sid:{}",entity.getSid());
		LogsUtil.set(LogType.Modify, "修改流程意见摸版");
		LogsUtil.setTarget(entity.getSid(), entity.getName());
		
		// 参数处理
		//AssertUtil.service().notNull(entry.getSid(), "参数sid不能为空");
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		String fields[] = {"author","name","price"};
		
		entity.setLastUpdated(DateUtil.getSystemDate());
		entity.setLastUpdatedBy(sessionService.getUserId());
		int len = dataBaseService.update("updateFlwExtOpinion", Updater.build(entity).fields(fields));
		LogsUtil.add("保存数据,len:"+len);
		
		Results<Long> results = Results.build(len>0,entity.getSid());
		LogsUtil.save(len>0);
		
		log.debug("退出控制:修改书籍信息方法,sid:{},results:{}",entity.getSid(),results.isSuccess());
		return results;
	}

	@Override
	public Results<List<Books>> findByIds(Params<List<Long>> params) {
		log.debug("进入控制:批量查询书籍方法，params:{}",params);
		LogsUtil.set(LogType.Query, "批量查询书籍");
		// 参数处理
		AssertUtil.service().isTrue(params.getBody()!=null && !params.getBody().isEmpty(), "参数body不能为空");
		
		// 参数处理
		Books entity=new Books();
		entity.setIds(params.getBody());
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		List<Books> rows= dataBaseService.selectList("findByIdsBooks", entity);
		LogsUtil.add("批量查询数据:"+rows.size());
		
		Results<List<Books>> results = Results.success(rows);
		LogsUtil.success();

		log.debug("退出控制:批量查询书籍方法，params:{},result:{}",params,results.isSuccess());
		return results;
	}

	@Override
	public Results<Long> delete(Params<List<Long>> params) {
		log.debug("进入控制:删除书籍方法，params:{}",params);
		LogsUtil.set(LogType.Delete, "删除书籍");
		
		// 参数处理
		AssertUtil.service().isTrue(params.getBody()!=null && !params.getBody().isEmpty(), "参数body不能为空");
		
		// 参数处理
		Books entity=new Books();
		entity.setIds(params.getBody());
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		// 执行删除
		LogsUtil.add("删除数ids:"+JsonUtil.toJson(entity.getIds()));
		int len = dataBaseService.delete("deleteByIdBooks",entity);
		LogsUtil.add("成功删除记录数量:"+len);
		
		Results<Long> results=Results.success((long)len);
		LogsUtil.save(len>0);

		log.debug("退出控制:删除流程意见摸版信息方法，params:{},result:{}",params,results.isSuccess());
		return results;
	}


	@Override
	public Results<Books> detail(Long sid) {
		log.debug("进入控制:查看书籍详情方法，sid:{}",sid);
		LogsUtil.set(LogType.Query, "查看书籍详情",sid);
		// 参数处理
		AssertUtil.service().notNull(sid,"参数sid不能为空");
		
		// 参数处理
		Books entity=new Books();
		entity.setSid(sid);
		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
			entity.setTenantId(sessionService.getTenantId());
			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
				entity.setOrgId(sessionService.getOrgId());
			}
		}
		
		LogsUtil.add("查找记录");
		Books tmp = dataBaseService.selectOne("findByIdBooks", entity);
		AssertUtil.service().notNull(tmp, "记录未找到");
					
		Results<Books> results=Results.success(tmp);
		LogsUtil.success(tmp.getSid(), tmp.getName());

		log.debug("退出控制:查看流程意见摸版详细信息方法，sid:{},result:{}",sid,results.isSuccess());
		return results;
	}



}
