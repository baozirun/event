package com.aifa.mins.event.server;

import cn.hutool.core.util.StrUtil;
import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.core.security.SessionService;
import com.aifa.mins.core.security.UserRoles;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.api.DrpPlanGroupApi;
import com.aifa.mins.event.model.yjzh.DrpPlanGroup;
import com.aifa.mins.event.model.yjzh.DrpPlanGroupUsers;
import com.aifa.mins.ibls.core.LogsUtil;
import com.aifa.mins.ibls.core.LogsUtil.LogType;
import com.aifa.mins.model.Validator;
import com.aifa.mins.mybatis.DataBaseService;
import com.aifa.mins.system.sys.api.SysUserApi;
import com.aifa.mins.system.sys.model.SysUser;
import com.aifa.mins.utils.BeanUtil;
import com.aifa.mins.utils.DateUtil;
import com.aifa.mins.utils.JsonUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @标题 DrpPlanGroup Controller 服务
 * @作者 pojofactory pojo builder
 * @日期 2020-9-9 10:19:01
 * @版本 1.0.0
 **/
@Slf4j
@RestController
@Api(tags = "DrpPlanGroup 数字化预案群组表 管理服务")
@RequestMapping("/drp/planGroup")
public class DrpPlanGroupController implements DrpPlanGroupApi {
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

    @Autowired
    private SysUserApi sysUserApi;


    @Override
    public Results<List<DrpPlanGroup>> find(Params<DrpPlanGroup> params) {
        log.debug("进入控制:查询数字化预案群组表列表方法,params:{}", params);
        Results<List<DrpPlanGroup>> results = new Results<>();
        LogsUtil.set(LogType.Query, "查询数字化预案群组表列表");
        // 参数处理
//			AssertUtil.service().notNull(params.getBody(), new String[] {"appId"},"参数%s不能为空");
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            params.getBody().setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //params.getBody().setOrgId(sessionService.getOrgId());
            }
        }
        List<String> eventLevelList=new ArrayList<>();
        DrpPlanGroup planGroupParams = params.getBody();
        if(StrUtil.isNotBlank(planGroupParams.getEventLevel())){
            if(planGroupParams.getEventLevel().contains(",")){

                String[] split = planGroupParams.getEventLevel().split(",");
                Arrays.stream(split).forEach(c->{
                    eventLevelList.add(c);
                });
                planGroupParams.setDrpEventLevelList(eventLevelList);
            }else{
                eventLevelList.add(planGroupParams.getEventLevel());
            }
            planGroupParams.setDrpEventLevelList(eventLevelList);
            params.setBody(planGroupParams);
        }
         // 统计数量
        Integer total = dataBaseService.selectOne("countDrpPlanGroup", params);
        params.setTotal(total);
        results.setTotal(total);
        LogsUtil.add("分页数据查询，数据总量count:" + total);

        // 执行查询
        List<DrpPlanGroup> rows = dataBaseService.selectListByPage("findDrpPlanGroup", params);
        rows.stream().forEach(v -> {
            v.setAuthorityMemberList(getDrpPlanGroupUsersList(v.getSid()));
            v.setDrpPlanGroupUsersList(getDrpPlanGroupUsersList(v.getSid()));
        });
        LogsUtil.add("分页数据查询，记录数量size:" + rows.size());

        results.setBody(rows);
        results.setSuccess(true);
        LogsUtil.success();

        log.debug("退出控制:查询数字化预案群组表列表方法,params:{},result:{}", params, results.isSuccess());
        return results;
    }


    @Override
    @Transactional
    public Results<Long> save(@Validated(Validator.save.class) DrpPlanGroup entity) {
        log.debug("进入控制:新增数字化预案群组表信息.entity:{}", entity);
        Results<Long> results = new Results<>();
        LogsUtil.set(LogType.Insert, "新增数字化预案群组表");
        // 参数处理
        //龙跃云 2021-10-26 10:26:32 删除"locationName"字段非空判断
        AssertUtil.service().notNull(entity, new String[]{"basicInformationId", "groupName"}, "参数%s不能为空");
        AssertUtil.service().notEmpty(entity.getAuthorityMemberList(), "专项指挥机构成员为空");
        LogsUtil.add("设置默认属性");
        entity.setTenantId(sessionService.getTenantId());
        entity.setOrgId(sessionService.getOrgId());
        entity.setCreated(DateUtil.getSystemDate());
        entity.setCreatedBy(sessionService.getUserId());
        entity.setLastUpdated(DateUtil.getSystemDate());
        entity.setLastUpdatedBy(sessionService.getUserId());

        //保存数字化预案群组信息
        int len = dataBaseService.insert("addDrpPlanGroup", entity);
        LogsUtil.add("保存数据,len:" + len);

        /**
         * 龙跃云 2021-10-26 10:13:17 重新组装 专项指挥机构成员 数据
         */
        List<DrpPlanGroupUsers> authorityMemberList = new ArrayList<>();
        entity.getAuthorityMemberList().forEach(t ->
        {
            t.setPlanGroupId(entity.getSid());
            dataBaseService.insert("addDrpPlanGroupUsers", t);
        });
		/*List<DrpPlanGroupUsers> drpPlanGroupUsersList=new ArrayList<>();
		//遍历数字化预案组长信息
		entity.getLeaderUserIds().forEach(v->{
			DrpPlanGroupUsers drpPlanGroupUsers=new DrpPlanGroupUsers();
			drpPlanGroupUsers.setUserId(v);
			drpPlanGroupUsers.setUserType(1);
			drpPlanGroupUsersList.add(drpPlanGroupUsers);
		});

		//遍历数字化预案组员信息
		entity.getCrewUserIds().forEach(v->{
			DrpPlanGroupUsers drpPlanGroupUsers=new DrpPlanGroupUsers();
			drpPlanGroupUsers.setUserId(v);
			drpPlanGroupUsers.setUserType(0);
			drpPlanGroupUsersList.add(drpPlanGroupUsers);
		});

		//保存数字化预案组长和组员信息
		drpPlanGroupUsersList.forEach(v->{
			v.setPlanGroupId(entity.getSid());
			v.setTenantId(sessionService.getTenantId());
			v.setOrgId(sessionService.getOrgId());
			v.setCreated(DateUtil.getSystemDate());
			v.setCreatedBy(sessionService.getUserId());
			v.setLastUpdated(DateUtil.getSystemDate());
			v.setLastUpdatedBy(sessionService.getUserId());
			dataBaseService.insert("addDrpPlanGroupUsers", v);
		});*/

        results.setBody(entity.getSid());
        results.setSuccess(len > 0);
        results.setMessage(len > 0 ? "操作成功" : "操作失败");
        LogsUtil.save(len > 0, entity.getSid(), entity.getGroupName());

        log.debug("退出控制:新增数字化预案群组表信息.entity:{},result:{}", entity, results.isSuccess());
        return results;
    }


    @Override
    @Transactional
    public Results<Long> update(@Validated(Validator.update.class) DrpPlanGroup entity) {
        log.debug("进入控制:修改数字化预案群组表信息方法，entity:{}", entity);
        Results<Long> results = new Results<>();
        LogsUtil.set(LogType.Modify, "修改数字化预案群组表", entity.getSid());
        // 参数处理
        //龙跃云 2021-10-26 10:26:32 删除"locationName"字段非空判断
        AssertUtil.service().notNull(entity, new String[]{"sid", "basicInformationId", "groupName"}, "参数%s不能为空");

        DrpPlanGroup tmp = new DrpPlanGroup();
        tmp.setSid(entity.getSid());
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            tmp.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //tmp.setOrgId(sessionService.getOrgId());
            }
        }
        LogsUtil.add("查找记录");
        tmp = dataBaseService.selectOne("findByIdDrpPlanGroup", tmp);
        AssertUtil.service().notNull(tmp, "记录未找到");
        //龙跃云 2021-10-26 10:44:28 新增eventLevel字段更新
        String fields[] = {"basicInformationId", "groupName", "groupDes", "eventLevel", "longitude", "latitude", "locationName"};

        BeanUtil.copy(entity, tmp, fields);
        tmp.setLastUpdated(DateUtil.getSystemDate());
        tmp.setLastUpdatedBy(sessionService.getUserId());
        int len = dataBaseService.update("updateDrpPlanGroup", tmp);
        LogsUtil.add("保存数据,len:" + len);

        //先根据组id删除对应的人员
        DrpPlanGroupUsers groupUsers = new DrpPlanGroupUsers();
        groupUsers.setPlanGroupId(tmp.getSid());
        dataBaseService.delete("deleteByGroupIdDrpPlanGroupUsers", groupUsers);
        LogsUtil.add("更新数据,len:" + len);

        /**
         * 龙跃云 2021-10-26 10:13:17 重新组装 专项指挥机构成员 数据
         */
        List<DrpPlanGroupUsers> authorityMemberList = new ArrayList<>();
        entity.getAuthorityMemberList().forEach(t ->
        {
            t.setPlanGroupId(entity.getSid());
            dataBaseService.insert("addDrpPlanGroupUsers", t);
        });
		/*List<DrpPlanGroupUsers> drpPlanGroupUsersList=new ArrayList<>();
		//遍历数字化预案组长信息
		entity.getLeaderUserIds().forEach(v->{
			DrpPlanGroupUsers drpPlanGroupUsers=new DrpPlanGroupUsers();
			drpPlanGroupUsers.setUserId(v);
			drpPlanGroupUsers.setUserType(1);
			drpPlanGroupUsersList.add(drpPlanGroupUsers);
		});

		//遍历数字化预案组员信息
		entity.getCrewUserIds().forEach(v->{
			DrpPlanGroupUsers drpPlanGroupUsers=new DrpPlanGroupUsers();
			drpPlanGroupUsers.setUserId(v);
			drpPlanGroupUsers.setUserType(0);
			drpPlanGroupUsersList.add(drpPlanGroupUsers);
		});

		//保存数字化预案组长和组员信息
		drpPlanGroupUsersList.forEach(v->{
			v.setPlanGroupId(entity.getSid());
			v.setTenantId(sessionService.getTenantId());
			v.setOrgId(sessionService.getOrgId());
			v.setCreated(DateUtil.getSystemDate());
			v.setCreatedBy(sessionService.getUserId());
			v.setLastUpdated(DateUtil.getSystemDate());
			v.setLastUpdatedBy(sessionService.getUserId());
			dataBaseService.insert("addDrpPlanGroupUsers", v);
		});*/

        results.setBody(entity.getSid());
        results.setSuccess(len > 0);
        results.setMessage(len > 0 ? "操作成功" : "操作失败");
        LogsUtil.save(len > 0, entity.getSid(), entity.getGroupName());

        log.debug("退出控制:修改数字化预案群组表信息方法，entity:{},result:{}", entity, results.isSuccess());
        return results;
    }


    @Override
    public Results<List<DrpPlanGroup>> findByIds(Params<List<Long>> params) {
        log.debug("进入控制:批量查询数字化预案群组表信息方法，params:{}", params);
        Results<List<DrpPlanGroup>> results = new Results<>();
        LogsUtil.set(LogType.Query, "批量查询数字化预案群组表");
        // 参数处理
        AssertUtil.service().isTrue(params.getBody() != null && !params.getBody().isEmpty(), "参数body不能为空");

        // 参数处理
        DrpPlanGroup entity = new DrpPlanGroup();
        entity.setIds(params.getBody());
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            entity.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //entity.setOrgId(sessionService.getOrgId());
            }
        }

        List<DrpPlanGroup> rows = dataBaseService.selectList("findByIdsDrpPlanGroup", entity);
        LogsUtil.add("批量查询数据:" + rows.size());

        results.setBody(rows);
        results.setSuccess(true);
        results.setMessage("操作成功");
        LogsUtil.success();

        log.debug("退出控制:批量查询数字化预案群组表信息方法，params:{},result:{}", params, results.isSuccess());
        return results;
    }


    @Override
    public Results<DrpPlanGroup> detail(Long sid) {
        log.debug("进入控制:查看数字化预案群组表详细信息方法，sid:{}", sid);
        Results<DrpPlanGroup> results = new Results<>();
        LogsUtil.set(LogType.Query, "查看数字化预案群组表详细", sid);
        // 参数处理
        AssertUtil.service().notNull(sid, "参数sid不能为空");

        // 参数处理
        DrpPlanGroup entity = new DrpPlanGroup();
        entity.setSid(sid);
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            entity.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //entity.setOrgId(sessionService.getOrgId());
            }
        }

        LogsUtil.add("查找记录");
        DrpPlanGroup tmp = dataBaseService.selectOne("findByIdDrpPlanGroup", entity);
        AssertUtil.service().notNull(tmp, "记录未找到");

//        tmp = getLeaderAndCrewUserId(tmp);
        tmp.setAuthorityMemberList(getDrpPlanGroupUsersList(tmp.getSid()));

        results.setBody(tmp);
        results.setSuccess(true);
        results.setMessage("操作成功");
        LogsUtil.success(tmp.getSid(), tmp.getGroupName());

        log.debug("退出控制:查看数字化预案群组表详细信息方法，sid:{},result:{}", sid, results.isSuccess());
        return results;
    }


    @Override
    @Transactional
    public Results<Long> delete(Params<List<Long>> params) {
        log.debug("进入控制:删除数字化预案群组表信息方法，params:{}", params);
        Results<Long> results = new Results<>();
        LogsUtil.set(LogType.Delete, "删除数字化预案群组表");

        // 参数处理
        AssertUtil.service().isTrue(params.getBody() != null && !params.getBody().isEmpty(), "参数body不能为空");

        // 参数处理
        DrpPlanGroup entity = new DrpPlanGroup();
        entity.setIds(params.getBody());
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            entity.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //entity.setOrgId(sessionService.getOrgId());
            }
        }

        // 执行删除
        LogsUtil.add("删除数ids:" + JsonUtil.toJson(entity.getIds()));
        int count = dataBaseService.delete("deleteByIdDrpPlanGroup", entity);
        LogsUtil.add("成功删除记录数量:" + count);

        //先根据组id删除对应的人员
        DrpPlanGroupUsers groupUsers = new DrpPlanGroupUsers();
        groupUsers.setPlanGroupId(entity.getIds().get(0));
        dataBaseService.delete("deleteByGroupIdDrpPlanGroupUsers", groupUsers);

        results.setSuccess(count > 0);
        results.setMessage(count > 0 ? "操作成功" : "操作失败");
        results.setBody((long) count);
        LogsUtil.save(count > 0);

        log.debug("退出控制:删除数字化预案群组表信息方法，params:{},result:{}", params, results.isSuccess());
        return results;
    }

    /**
     * 根据群组id获取对应的组长和组员的userId
     */
    private DrpPlanGroup getLeaderAndCrewUserId(DrpPlanGroup drpPlanGroup) {
        Params<DrpPlanGroupUsers> params = new Params<>();
        DrpPlanGroupUsers drpPlanGroupUsers = new DrpPlanGroupUsers();
        drpPlanGroupUsers.setPlanGroupId(drpPlanGroup.getSid());
        params.setBody(drpPlanGroupUsers);
        List<DrpPlanGroupUsers> rows = dataBaseService.selectList("findDrpPlanGroupUsers", params);
        List<Long> leaderUserIds = new ArrayList<>();
        List<Long> crewUserIds = new ArrayList<>();
        rows.forEach(v -> {
            if (v.getUserType() == 0) {
                crewUserIds.add(v.getUserId());
            } else {
                leaderUserIds.add(v.getUserId());
            }
        });
        drpPlanGroup.setLeaderUserIds(leaderUserIds);
        drpPlanGroup.setCrewUserIds(crewUserIds);
        return drpPlanGroup;
    }

    /**
     * 根据群组id获取对应的组长和组员集合信息
     */
    private List<DrpPlanGroupUsers> getDrpPlanGroupUsersList(Long planGroupId) {
        // 执行查询
        Params<DrpPlanGroupUsers> params = new Params<>();
        DrpPlanGroupUsers drpPlanGroupUsers = new DrpPlanGroupUsers();
        drpPlanGroupUsers.setPlanGroupId(planGroupId);
        params.setBody(drpPlanGroupUsers);
        List<DrpPlanGroupUsers> rows = dataBaseService.selectList("findDrpPlanGroupUsers", params);
        LogsUtil.add("分页数据查询，记录数量size:" + rows.size());

        getSysUser(rows);
        return rows;
    }

    private void getSysUser(List<DrpPlanGroupUsers> rows) {
        List<Long> listUserId = new ArrayList<>();
        rows.stream().forEach(ptm -> {
            listUserId.add(ptm.getUserId());
        });

        Map<Long, SysUser> userMap = new HashMap<>();
        Params<List<Long>> userParams = new Params<>();
        userParams.setBody(listUserId);
        Results<List<SysUser>> sysUserList = sysUserApi.findByIds(userParams);
        if (sysUserList != null && sysUserList.isSuccess()) {
            sysUserList.getBody().stream().forEach(user -> {
                userMap.put(user.getSid(), user);
            });
        }

        rows.stream().forEach(ptm -> {
            SysUser sysUser = userMap.get(ptm.getUserId());
            if (sysUser != null) {
                ptm.setRealName(sysUser.getRealName());
                ptm.setTel(sysUser.getTel());
            }
        });
    }


}
