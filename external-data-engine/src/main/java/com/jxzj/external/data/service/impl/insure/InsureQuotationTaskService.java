package com.jxzj.external.data.service.impl.insure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jxzj.external.data.dao.InsureQuotationTaskMapper;
import com.jxzj.external.data.entity.insure.InsureQuotationTask;
import com.jxzj.external.data.service.insure.IInsureQuotationTaskService;

@Service
public class InsureQuotationTaskService implements IInsureQuotationTaskService {

    @Autowired
    private InsureQuotationTaskMapper insureQuotationTaskMapper;

    @Override
    public List<InsureQuotationTask> queryInsureQuotaionTask() {
        List<
            InsureQuotationTask> taskList =
                insureQuotationTaskMapper.selectList(new LambdaQueryWrapper<InsureQuotationTask>()
                    .select(InsureQuotationTask::getId, InsureQuotationTask::getCustomerName,
                        InsureQuotationTask::getIdCard, InsureQuotationTask::getLicensePlate,
                        InsureQuotationTask::getEngineNo, InsureQuotationTask::getVin,
                        InsureQuotationTask::getUnladenMass, InsureQuotationTask::getFirstRegisterDate)
                    .eq(InsureQuotationTask::getState, 1));
        return taskList;
    }

    // @Override
    // public void updateInsureQuotationTaskByVehicleFrameNo(InsureQuotationTask entity) {
    //
    // InsureQuotationTask update = new InsureQuotationTask();
    //
    // insureQuotationTaskMapper.updateInsureQuotationTaskByVehicleFrameNo(entity);
    // }

}
