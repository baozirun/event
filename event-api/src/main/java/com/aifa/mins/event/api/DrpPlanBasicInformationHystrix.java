package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.yjzh.DrpPlanBasicInformation;
import com.aifa.mins.feign.hystrix.HystrixFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @标题 DrpPlanBasicInformationApi 服务降级实现
 * @描述 1、可以设置默认降级实现
 *        2、也可以在Spring容器中注册自定义降级，bean name规范为 接口标题（首字母小写）
 * @作者	LYY
 * @日期	2021-11-20 10:30:57
 * @版本	1.0.0
 **/
@Component
public class DrpPlanBasicInformationHystrix  extends HystrixFactory<DrpPlanBasicInformationApi> {
    public DrpPlanBasicInformationHystrix(){
        this.setDefaultFallback(new DrpPlanBasicInformationApi(){



			@Override
			public Results<List<DrpPlanBasicInformation>> find(Params<DrpPlanBasicInformation> params) {
				Results<List<DrpPlanBasicInformation>> result=new Results<>();
                result.setMessage("DrpPlanBasicInformationApi 默认降级消息");
                return result;
			}

			@Override
			public Results<List<DrpPlanBasicInformation>> findByIds(Params<List<Long>> params) {
				Results<List<DrpPlanBasicInformation>> result=new Results<>();
				result.setMessage("DrpPlanBasicInformationApi 默认降级消息");
				return result;
			}

			@Override
			public Results<Long> save(DrpPlanBasicInformation entity) {
				Results<Long> result=new Results<>();
                result.setMessage("DrpPlanBasicInformationApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> delete(Params<List<Long>> params) {
				Results<Long> result=new Results<>();
                result.setMessage("DrpPlanBasicInformationApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> update(DrpPlanBasicInformation entity) {
				Results<Long> result=new Results<>();
                result.setMessage("DrpPlanBasicInformationApi 默认降级消息");
                return result;
			}

			@Override
			public Results<DrpPlanBasicInformation> detail(Long sid) {
				Results<DrpPlanBasicInformation> result=new Results<>();
                result.setMessage("DrpPlanBasicInformationApi 默认降级消息");
                return result;
			}

			@Override
			public Results<List<DrpPlanBasicInformation>> findByEventId(Params<DrpPlanBasicInformation> params) {
				Results<List<DrpPlanBasicInformation>> result=new Results<>();
				result.setMessage("DrpPlanBasicInformationApi 默认降级消息");
				return result;
			}

        });
    }
}
