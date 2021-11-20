package com.aifa.mins.event.server;

import cn.hutool.core.util.StrUtil;
import com.aifa.mins.core.SidGenerator;
import com.aifa.mins.core.exception.AssertUtil;
import com.aifa.mins.core.security.SessionService;
import com.aifa.mins.core.security.UserRoles;
import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.api.DrpPlanBasicInformationApi;
import com.aifa.mins.event.model.yjzh.DrpPlanBasicInformation;
import com.aifa.mins.event.model.yjzh.YjzhContingencyplansEventprogress;
import com.aifa.mins.ibls.core.LogsUtil;
import com.aifa.mins.ibls.core.LogsUtil.LogType;
import com.aifa.mins.model.Validator;
import com.aifa.mins.mybatis.DataBaseService;
import com.aifa.mins.utils.BeanUtil;
import com.aifa.mins.utils.DateUtil;
import com.aifa.mins.utils.JsonUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @标题 DrpPlanBasicInformation Controller 服务
 * @作者 pojofactory pojo builderplanNumber
 * @日期 2020-9-4 13:38:49
 * @版本 1.0.0
 **/
@Slf4j
@RestController
@Api(tags = "DrpPlanBasicInformation 预案基本信息 管理服务")
@RequestMapping("/drp/planBasicInformation")
public class DrpPlanBasicInformationController implements DrpPlanBasicInformationApi {
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
    private SidGenerator sidGenerator;


    @Override
    public Results<List<DrpPlanBasicInformation>> find(@RequestBody Params<DrpPlanBasicInformation> params) {
        System.out.println(JsonUtil.toJson(params));
        log.debug("进入控制:查询预案基本信息列表方法,params:{}", params);
        Results<List<DrpPlanBasicInformation>> results = new Results<>();
        LogsUtil.set(LogType.Query, "查询预案基本信息列表");
        // 参数处理
//			AssertUtil.service().notNull(params.getBody(), new String[] {"appId"},"参数%s不能为空");
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
//            params.getBody().setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //params.getBody().setOrgId(sessionService.getOrgId());
            }
        }

        // 统计数量
        Integer total = dataBaseService.selectOne("countDrpPlanBasicInformation", params);
        params.setTotal(total);
        results.setTotal(total);
        LogsUtil.add("分页数据查询，数据总量count:" + total);

        // 执行查询
        List<DrpPlanBasicInformation> rows = dataBaseService.selectListByPage("findDrpPlanBasicInformation", params);
        LogsUtil.add("分页数据查询，记录数量size:" + rows.size());
        //根据事件id查询“YJZH_CONTINGENCYPLANS_EVENTPROGRESS”中的预案列表
        //判断是否传入事件id
        if (StrUtil.isNotBlank(params.getBody().getEventId())) {
            //包装查询条件
            YjzhContingencyplansEventprogress plansEventprogressQuery = new YjzhContingencyplansEventprogress();
            plansEventprogressQuery.setEventId(params.getBody().getEventId());
            //根据事件id获取对应预案id信息
            List<YjzhContingencyplansEventprogress> plansEventprogresss = dataBaseService.selectList("findYjzhContingencyplansEventprogressByEvent", plansEventprogressQuery);
            if (plansEventprogresss.size() > 0) {
                //组织数据返回
                List<Long> planCollect = plansEventprogresss.stream().map(t -> t.getPlanId()).collect(Collectors.toList());
                rows.stream().forEach(c -> {
                    if (planCollect.contains(c.getSid())) {
                        c.setEventId(params.getBody().getEventId());
                    }
                });
            }
        }


        results.setBody(rows);
        results.setSuccess(true);
        LogsUtil.success();

        log.debug("退出控制:查询预案基本信息列表方法,params:{},result:{}", params, results.isSuccess());
        return results;
    }


    @Override
    public Results<List<DrpPlanBasicInformation>> findByEventId(@RequestBody Params<DrpPlanBasicInformation> params) {
        System.out.println(JsonUtil.toJson(params));
        log.debug("进入控制:根据事件id查询预案基本信息列表方法,params:{}", params);
        Results<List<DrpPlanBasicInformation>> results = new Results<>();
        AssertUtil.service().notNull(params.getBody(), new String[]{"eventId"}, "参数%s不能为空");
        //包装查询条件
        LogsUtil.set(LogType.Query, "根据事件id查询预案id列表");
        YjzhContingencyplansEventprogress plansEventprogressQuery = new YjzhContingencyplansEventprogress();
        plansEventprogressQuery.setEventId(params.getBody().getEventId());
        //根据事件id获取对应预案id信息
        List<YjzhContingencyplansEventprogress> plansEventprogresss = dataBaseService.selectList("findYjzhContingencyplansEventprogressByEvent", plansEventprogressQuery);
        AssertUtil.service().notEmpty(plansEventprogresss, "该事件没有绑定预案");
        LogsUtil.set(LogType.Query, "查询预案基本信息列表");
        AssertUtil.service().notNull(plansEventprogresss.get(0), new String[]{"planId"}, "获取不到该事件预案");
        params.getBody().setSid(plansEventprogresss.get(0).getPlanId());
        // 统计数量
        Integer total = dataBaseService.selectOne("countDrpPlanBasicInformation", params);
        params.setTotal(total);
        results.setTotal(total);
        LogsUtil.add("分页数据查询，数据总量count:" + total);
        // 执行查询
        List<DrpPlanBasicInformation> rows = dataBaseService.selectListByPage("findDrpPlanBasicInformation", params);
        LogsUtil.add("分页数据查询，记录数量size:" + rows.size());
        results.setBody(rows);
        results.setSuccess(true);
        LogsUtil.success();

        log.debug("退出控制:查询预案基本信息列表方法,params:{},result:{}", params, results.isSuccess());
        return results;
    }





    @Transactional
    @Override
    public Results<Long> update(@Validated(Validator.update.class) DrpPlanBasicInformation entity) {
        log.debug("进入控制:修改预案基本信息信息方法，entity:{}", entity);
        Results<Long> results = new Results<>();
        LogsUtil.set(LogType.Modify, "修改预案基本信息", entity.getSid());
        // 参数处理
        //龙跃云 2021-10-22 13:42:52  删除对planNumber、planTemplateId、eventLevel、versionNumber三个字段的非空判断
        if (StrUtil.isBlank(entity.getHeadquartersOffice())) {
            AssertUtil.service().notNull(entity, new String[]{"sid", "planName", "planCategory", "eventType", "location"}, "参数%s不能为空");
        } else {
            AssertUtil.service().notNull(entity, new String[]{"sid", "headquartersOffice"}, "参数%s不能为空");
        }
        DrpPlanBasicInformation tmp = new DrpPlanBasicInformation();
        tmp.setSid(entity.getSid());
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            tmp.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //tmp.setOrgId(sessionService.getOrgId());
            }
        }
        LogsUtil.add("查找记录");
        tmp = dataBaseService.selectOne("findByIdDrpPlanBasicInformation", tmp);
        AssertUtil.service().notNull(tmp, "记录未找到");
        //龙跃云 2021-10-25 17:30:49 修复update中属性复制不完整的bug
        String[] fields = getNullPropertyNames(entity);
        /*String fields[] = {"planNumber", "planName", "versionNumber", "planCategory", "scope", "planTemplateId"
                , "eventType", "planThe", "eventLevel", "documentNumber", "earlywarningReport", "emergencySupport", "postDisposal"
                , "preparationDepartment", "issuingDepartment", "issueTime", "planClassification","headquartersOffice"};*/

        BeanUtil.copy(entity, tmp, fields);
        //重新生成versionNumber
        tmp.setVersionNumber(this.getHanyuPinyinFirst(tmp.getPlanName()) + dateToString(tmp.getReleaseTime(), "yyyyMMdd"));
        tmp.setLastUpdated(DateUtil.getSystemDate());
        tmp.setLastUpdatedBy(sessionService.getUserId());
        int len = dataBaseService.update("updateDrpPlanBasicInformation", tmp);
        //龙跃云 2021-11-3 17:48:48 保存历史记录
        if (StrUtil.isBlank(entity.getHeadquartersOffice())) {
            tmp.setCreated(DateUtil.getSystemDate());
            tmp.setLastUpdated(DateUtil.getSystemDate());
            int addDrpPlanBasicInformationHis = dataBaseService.update("addDrpPlanBasicInformationHis", tmp);

        }
        LogsUtil.add("保存数据,len:" + len);

        results.setBody(entity.getSid());
        results.setSuccess(len > 0);
        results.setMessage(len > 0 ? "操作成功" : "操作失败");
        LogsUtil.save(len > 0, entity.getSid(), entity.getPlanName());

        log.debug("退出控制:修改预案基本信息信息方法，entity:{},result:{}", entity, results.isSuccess());
        return results;
    }


    @Override
    public Results<List<DrpPlanBasicInformation>> findByIds(Params<List<Long>> params) {
        log.debug("进入控制:批量查询预案基本信息信息方法，params:{}", params);
        Results<List<DrpPlanBasicInformation>> results = new Results<>();
        LogsUtil.set(LogType.Query, "批量查询预案基本信息");
        // 参数处理
        AssertUtil.service().isTrue(params.getBody() != null && !params.getBody().isEmpty(), "参数body不能为空");

        // 参数处理
        DrpPlanBasicInformation entity = new DrpPlanBasicInformation();
        entity.setIds(params.getBody());
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            entity.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //entity.setOrgId(sessionService.getOrgId());
            }
        }

        List<DrpPlanBasicInformation> rows = dataBaseService.selectList("findByIdsDrpPlanBasicInformation", entity);
        LogsUtil.add("批量查询数据:" + rows.size());

        results.setBody(rows);
        results.setSuccess(true);
        results.setMessage("操作成功");
        LogsUtil.success();

        log.debug("退出控制:批量查询预案基本信息信息方法，params:{},result:{}", params, results.isSuccess());
        return results;
    }

    @Override
    public Results<Long> save(@RequestBody DrpPlanBasicInformation entity) {
        log.debug("进入控制:新增预案基本信息信息.entity:{}", entity);
        Results<Long> results = new Results<>();
        LogsUtil.set(LogType.Insert, "新增预案基本信息");
        // 参数处理
        //龙跃云 2021-10-22 13:42:52  删除对planNumber、planTemplateId、eventLevel、versionNumber三个字段的非空判断,versionNo自动生成
        AssertUtil.service().notNull(entity, new String[]{"planName", "planCategory", "eventType", "location"}, "参数%s不能为空");

        Long sid = sidGenerator.generate();
        LogsUtil.add("设置默认属性");
        entity.setSid(sid);
        entity.setPlanStatus(0);
        entity.setIsDelete(0);
        entity.setTenantId(sessionService.getTenantId());
        entity.setOrgId(sessionService.getOrgId());
        entity.setCreated(DateUtil.getSystemDate());
        entity.setCreatedBy(sessionService.getUserId());
        entity.setLastUpdated(DateUtil.getSystemDate());
        entity.setLastUpdatedBy(sessionService.getUserId());
        entity.setVersionNumber(this.getHanyuPinyinFirst(entity.getPlanName()) + dateToString(entity.getReleaseTime(), "yyyyMMdd"));

        int len = dataBaseService.insertWithId("addDrpPlanBasicInformation", entity);
        //龙跃云 2021-11-3 17:48:48 保存历史记录
        int addDrpPlanBasicInformationHis = dataBaseService.update("addDrpPlanBasicInformationHis", entity);
        LogsUtil.add("保存数据,len:" + len);

        results.setBody(entity.getSid());
        results.setSuccess(len > 0);
        results.setMessage(len > 0 ? "操作成功" : "操作失败");
        LogsUtil.save(len > 0, entity.getSid(), entity.getPlanName());

        log.debug("退出控制:新增预案基本信息信息.entity:{},result:{}", entity, results.isSuccess());
        return results;
    }


    @Override
    public Results<DrpPlanBasicInformation> detail(Long sid) {
        log.debug("进入控制:查看预案基本信息详细信息方法，sid:{}", sid);
        Results<DrpPlanBasicInformation> results = new Results<>();
        LogsUtil.set(LogType.Query, "查看预案基本信息详细", sid);
        // 参数处理
        AssertUtil.service().notNull(sid, "参数sid不能为空");

        // 参数处理
        DrpPlanBasicInformation entity = new DrpPlanBasicInformation();
        entity.setSid(sid);
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            entity.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //entity.setOrgId(sessionService.getOrgId());
            }
        }

        LogsUtil.add("查找记录");
        DrpPlanBasicInformation tmp = dataBaseService.selectOne("findByIdDrpPlanBasicInformation", entity);
        AssertUtil.service().notNull(tmp, "记录未找到");

        results.setBody(tmp);
        results.setSuccess(true);
        results.setMessage("操作成功");
        LogsUtil.success(tmp.getSid(), tmp.getPlanName());

        log.debug("退出控制:查看预案基本信息详细信息方法，sid:{},result:{}", sid, results.isSuccess());
        return results;
    }


    @Override
    public Results<Long> delete(Params<List<Long>> params) {
        log.debug("进入控制:删除预案基本信息信息方法，params:{}", params);
        Results<Long> results = new Results<>();
        LogsUtil.set(LogType.Delete, "删除预案基本信息");

        // 参数处理
        AssertUtil.service().isTrue(params.getBody() != null && !params.getBody().isEmpty(), "参数body不能为空");

        // 参数处理
        DrpPlanBasicInformation entity = new DrpPlanBasicInformation();
        entity.setIds(params.getBody());
        if (!sessionService.isAdministrator() && !sessionService.getUserRoles().contains(UserRoles.SUPPER_ADMIN.value())) {
            entity.setTenantId(sessionService.getTenantId());
            if (!sessionService.getUserRoles().contains(UserRoles.TENANT_ADMIN.value())) {
                //entity.setOrgId(sessionService.getOrgId());
            }
        }

        // 执行删除
        LogsUtil.add("删除数ids:" + JsonUtil.toJson(entity.getIds()));
        int count = dataBaseService.delete("deleteByIdDrpPlanBasicInformation", entity);
        LogsUtil.add("成功删除记录数量:" + count);

        results.setSuccess(count > 0);
        results.setMessage(count > 0 ? "操作成功" : "操作失败");
        results.setBody((long) count);
        LogsUtil.save(count > 0);

        log.debug("退出控制:删除预案基本信息信息方法，params:{},result:{}", params, results.isSuccess());
        return results;
    }




    private String getIdsStr(Map<Long, Long> sidMap, String idsStr, List<String> idList) {
        for (int i = 0; i < idList.size(); i++) {
            Long id = Long.valueOf(idList.get(i));
            if (i == (idList.size() - 1)) {
                idsStr += sidMap.get(id);
            } else {
                idsStr += sidMap.get(id) + ",";
            }
        }
        return idsStr;
    }

    private String getJsonXmlStr(Map<Long, Long> sidMap, String jsonXml) {
        for (Long key : sidMap.keySet()) {
            boolean status = jsonXml.contains(String.valueOf(key));
            if (status) {
                jsonXml = jsonXml.replace(String.valueOf(key), String.valueOf(sidMap.get(key)));
            }
        }
        return jsonXml;
    }

    /*
    实现汉字转换拼音，并且把韵母大写以便于识别，非汉字类型不转换
     */
    private String getHanyuPinyinFirst(String ChineseLanguage) {

        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        StringBuilder hanyupinyin = new StringBuilder();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 输出拼音全部小写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            for (int i = 0; i < cl_chars.length; i++) {
                if (String.valueOf(cl_chars[i]).matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音
                    hanyupinyin.append((PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0]).substring(0, 1));
                } else {// 如果字符不是中文,则不转换
                    hanyupinyin.append(cl_chars[i]);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            log.error("拼音转换失败");
        }
        return hanyupinyin.toString();
    }

    private String dateToString(Date date, String pattern) {
        //龙跃云 2021-10-25 17:31:34对日期格式转换异常进行捕获
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
            String format = dateTimeFormatter.format(localDateTime);
            return format;
        } catch (Exception e) {
            log.error("日期格式转换失败");
        }
        return null;

    }

    //龙跃云，获取对象非空字段
    public String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue != null)
                if (!"class".equals(pd.getName())) {
                    emptyNames.add(pd.getName());
                }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
