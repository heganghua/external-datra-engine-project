package com.jxzj.external.data.service.insure;

import java.util.List;

import com.jxzj.external.data.entity.insure.InsureQuotationTask;

public interface IInsureQuotationTaskService {

    /**
     * 查询待报价的询价单列表
     * 
     * @return
     */
    List<InsureQuotationTask> queryInsureQuotaionTask();

    /**
     * 修改车辆信息
     * 
     * @author heganghua
     * @date 2020/12/23
     * @param entity
     * @return void
     */
    // void updateInsureQuotationTaskByVehicleFrameNo(InsureQuotationTask entity);

}
