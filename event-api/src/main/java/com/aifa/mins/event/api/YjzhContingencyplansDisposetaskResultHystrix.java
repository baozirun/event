package com.aifa.mins.event.api;

import com.aifa.mins.dto.Params;
import com.aifa.mins.dto.Results;
import com.aifa.mins.event.model.yjzh.YjzhContingencyplansDisposetaskResult;
import com.aifa.mins.event.model.yjzh.dto.YjzhPlansDisposetaskResultDto;
import com.aifa.mins.feign.hystrix.HystrixFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @标题 YjzhContingencyplansDisposetaskResultApi 服务降级实现
 * @描述 1、可以设置默认降级实现
 *        2、也可以在Spring容器中注册自定义降级，bean name规范为 接口标题（首字母小写）
 * @作者	LYY
 * @日期	2021-11-20 11:07:25
 * @版本	1.0.0
 **/
@Component
public class YjzhContingencyplansDisposetaskResultHystrix  extends HystrixFactory<YjzhContingencyplansDisposetaskResultApi> {
    public YjzhContingencyplansDisposetaskResultHystrix(){
        this.setDefaultFallback(new YjzhContingencyplansDisposetaskResultApi(){



			@Override
			public Results<List<YjzhPlansDisposetaskResultDto>> findResult(Params<YjzhPlansDisposetaskResultDto> var1) {
				Results<List<YjzhPlansDisposetaskResultDto>> result=new Results<>();
				result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
				return result;
			}

			@Override
			public Results<List<YjzhContingencyplansDisposetaskResult>> find(Params<YjzhContingencyplansDisposetaskResult> params) {
				Results<List<YjzhContingencyplansDisposetaskResult>> result=new Results<>();
                result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> save(YjzhContingencyplansDisposetaskResult entity) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> delete(Params<List<Long>> params) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
                return result;
			}

			@Override
			public Results<Long> update(YjzhContingencyplansDisposetaskResult entity) {
				Results<Long> result=new Results<>();
                result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
                return result;
			}

			@Override
			public Results<YjzhContingencyplansDisposetaskResult> detail(Long sid) {
				Results<YjzhContingencyplansDisposetaskResult> result=new Results<>();
                result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
                return result;
			}

//			@Override
//			public Results<List<YjzhContingencyplansDisposetaskResult>> children(Long sid) {
//				Results<List<YjzhContingencyplansDisposetaskResult>> result=new Results<>();
//                result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
//                return result;
//			}

			@Override
			public Results<List<YjzhContingencyplansDisposetaskResult>> findByIds(Params<List<Long>> params) {
				Results<List<YjzhContingencyplansDisposetaskResult>> result=new Results<>();
                result.setMessage("YjzhContingencyplansDisposetaskResultApi 默认降级消息");
                return result;
			}

        });
    }
}
