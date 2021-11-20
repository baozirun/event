package com.aifa.mins.event.server;

import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.core.security.SessionService;
import com.aifa.mins.core.security.UserRoles;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.api.YjzhContingencyplansDisposeDespicableApi;
import com.aifa.mins.event.model.yjzh.YjzhContingencyplansDisposeDespicable;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @标题 YjzhContingencyplansDisposeDespicable Controller 服务
 *
 * @作者	lux
 * @日期	2021-10-27 9:53:17
 * @版本	1.0.0
 **/
@Slf4j
@RestController
@Api(tags = "指令下达管理服务")
@RequestMapping("/api/plansDisDespicable")
public class YjzhContingencyplansDisposeDespicableController implements YjzhContingencyplansDisposeDespicableApi {
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
  public Results<List<YjzhContingencyplansDisposeDespicable>> find(Params<YjzhContingencyplansDisposeDespicable> params) {
    log.debug("进入控制:查询YJZH_CONTINGENCYPLANS_DISPOSE_DESPICABLE列表方法,params:{}",params);
    Results<List<YjzhContingencyplansDisposeDespicable>> results = new Results<>();
    LogsUtil.set(LogType.Query, "查询YJZH_CONTINGENCYPLANS_DISPOSE_DESPICABLE列表");


    // 统计数量
    Integer total=dataBaseService.selectOne("countYjzhContingencyplansDisposeDespicable",params);
    params.setTotal(total);
    results.setTotal(total);
    LogsUtil.add("分页数据查询，数据总量count:"+total);

    // 执行查询
    params.setSortName("CREATED");
    params.setSortOrder("ASC");
    List<YjzhContingencyplansDisposeDespicable> rows = dataBaseService.selectListByPage("findYjzhContingencyplansDisposeDespicable", params);
    LogsUtil.add("分页数据查询，记录数量size:"+rows.size());

    results.setBody(rows);
    results.setSuccess(true);
    LogsUtil.success();

    log.debug("退出控制:查询YJZH_CONTINGENCYPLANS_DISPOSE_DESPICABLE列表方法,params:{},result:{}",params,results.isSuccess());
    return results;
  }


}
