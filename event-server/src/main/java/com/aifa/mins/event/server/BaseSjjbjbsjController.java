package com.aifa.mins.event.server;

import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.api.BaseSjjbjbsjApi;
import com.aifa.mins.event.model.BaseSjjbjbsj;
import com.aifa.mins.ibls.core.LogsUtil;
import com.aifa.mins.ibls.core.LogsUtil.LogType;
import com.aifa.mins.mybatis.DataBaseService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @标题 BaseSjjbjbsj Controller 服务
 * 
 * @作者	Caesar
 * @日期	2021-11-16 16:49:51
 * @版本	1.0.0
 **/
@Slf4j
@RestController
@Api(tags = "BaseSjjbjbsj 事件接报基本数据 管理服务")
@RequestMapping("/api/sjjbjbsj")
public class BaseSjjbjbsjController implements BaseSjjbjbsjApi{
	/**
	 * 数据访问对象
	 */
	@Autowired
	private DataBaseService dataBaseService;
	
	@Override
	public Results<List<BaseSjjbjbsj>> find(Params<BaseSjjbjbsj> params) {
		log.debug("进入控制:查询BASE_SJJBJBSJ列表方法,params:{}",params);
		Results<List<BaseSjjbjbsj>> results = new Results<>();
		LogsUtil.set(LogType.Query, "查询BASE_SJJBJBSJ列表");
		
		// 统计数量
		Integer total=dataBaseService.selectOne("countBaseSjjbjbsj",params);
		params.setTotal(total);
		results.setTotal(total);
		LogsUtil.add("分页数据查询，数据总量count:"+total);
		
		// 执行查询
		List<BaseSjjbjbsj> rows = dataBaseService.selectListByPage("findBaseSjjbjbsj", params);
		LogsUtil.add("分页数据查询，记录数量size:"+rows.size());
		
		results.setBody(rows);
		results.setSuccess(true);
		LogsUtil.success();

		log.debug("退出控制:查询BASE_SJJBJBSJ列表方法,params:{},result:{}",params,results.isSuccess());
		return results;
	}


	@Override
	public Results<List<BaseSjjbjbsj>> findByIds(Params<List<String>> params) {
		log.debug("进入控制:批量查询BASE_SJJBJBSJ信息方法，params:{}",params);
		Results<List<BaseSjjbjbsj>> results = new Results<>();
		LogsUtil.set(LogType.Query, "批量查询BASE_SJJBJBSJ");
		// 参数处理
		AssertUtil.service().isTrue(params.getBody()!=null && !params.getBody().isEmpty(), "参数body不能为空");
		
		// 参数处理
		BaseSjjbjbsj entity=new BaseSjjbjbsj();
		entity.setIds(params.getBody());
		
		List<BaseSjjbjbsj> rows= dataBaseService.selectList("findByIdsBaseSjjbjbsj", entity);
		LogsUtil.add("批量查询数据:"+rows.size());
		
		results.setBody(rows);
		results.setSuccess(true);
		results.setMessage("操作成功");
		LogsUtil.success();

		log.debug("退出控制:批量查询BASE_SJJBJBSJ信息方法，params:{},result:{}",params,results.isSuccess());
		return results;
	}


	@Override
	public Results<BaseSjjbjbsj> detail(String sid) {
		log.debug("进入控制:查看BASE_SJJBJBSJ详细信息方法，sid:{}",sid);
		Results<BaseSjjbjbsj> results = new Results<>();
		LogsUtil.set(LogType.Query, "查看BASE_SJJBJBSJ详细",null);
		// 参数处理
		AssertUtil.service().notNull(sid,"参数sid不能为空");
		
		// 参数处理
		BaseSjjbjbsj entity=new BaseSjjbjbsj();
		entity.setJbbh(sid);
		
		LogsUtil.add("查找记录");
		BaseSjjbjbsj tmp = dataBaseService.selectOne("findByIdBaseSjjbjbsj", entity);
		AssertUtil.service().notNull(tmp, "记录未找到");
					
		results.setBody(tmp);
		results.setSuccess(true);
		results.setMessage("操作成功");
		LogsUtil.success(null, null);

		log.debug("退出控制:查看BASE_SJJBJBSJ详细信息方法，sid:{},result:{}",sid,results.isSuccess());
		return results;
	}


	@Override
	public Results<List<BaseSjjbjbsj>> findResubmit(Params<BaseSjjbjbsj> params) {
		log.debug("进入控制:查询BASE_SJJBJBSJ列表方法,params:{}",params);
		Results<List<BaseSjjbjbsj>> results = new Results<>();
		LogsUtil.set(LogType.Query, "查询BASE_SJJBJBSJ列表");
		
		// 统计数量
		Integer total=dataBaseService.selectOne("countBaseSjjbjbsj",params);
		params.setTotal(total);
		LogsUtil.add("分页数据查询，数据总量count:"+total);
		
		// 执行查询
		List<BaseSjjbjbsj> rows = dataBaseService.selectListByPage("findBaseSjjbjbsjTreeList", params);
		LogsUtil.add("分页数据查询，记录数量size:"+rows.size());
		List<BaseSjjbjbsj> newList = new ArrayList<>();
		if (rows != null && rows.size() > 0) {
			// 数据处理
			int i = 0;
			List<BaseSjjbjbsj> childrenSjjbjbsj = rows.get(0).getChildren();
			while (childrenSjjbjbsj != null && childrenSjjbjbsj.size() > 0) {
				newList.add(childrenSjjbjbsj.get(0));
				childrenSjjbjbsj = childrenSjjbjbsj.get(0).getChildren();
				newList.get(i).setChildren(null);
				i++;
				if (i == 200) {
					LogsUtil.add("循环次数："+i+"！！！");
					break;
				}
			}
		}
		
		results.setTotal(newList!=null&&newList.size()>0?newList.size():0);
		results.setBody(newList);
		results.setSuccess(true);
		LogsUtil.success();

		log.debug("退出控制:查询BASE_SJJBJBSJ列表方法,params:{},result:{}",params,results.isSuccess());
		return results;
	}
	

//	@Override
//	public Results<List<BaseSjjbjbsj>> children(Long sid){
//		log.debug("进入控制:加载下级BASE_SJJBJBSJ信息,sid:{}",sid);
//		Results<List<BaseSjjbjbsj>> results = new Results<>();
//		LogsUtil.set(LogType.Query, "加载下级BASE_SJJBJBSJ信息",sid);
//		 //参数处理
//		AssertUtil.service().notNull(sid, "参数sid不能为空");
//
//		// 执行查询
//        Params<BaseSjjbjbsj> params = new Params<>();
//        params.setBody(new BaseSjjbjbsj());
//        params.getBody().setParentId(sid);
//        LogsUtil.add("parentId:"+sid);
//
//		if(!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
//			params.getBody().setTenantId(sessionService.getTenantId());
//			if(!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
//				params.getBody().setOrgId(sessionService.getOrgId());
//			}
//		}
//		List<BaseSjjbjbsj> rows = dataBaseService.selectList("findBaseSjjbjbsj", params);
//		LogsUtil.add("下级BASE_SJJBJBSJ记录数量:"+rows.size());
//
//		results.setSuccess(true);
//		results.setBody(rows);
//		LogsUtil.success();
//
//		log.debug("退出控制:加载下级BASE_SJJBJBSJ信息,sid:{},result:{}",sid,results.isSuccess());
//		return results;
//	}

}
