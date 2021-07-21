package com.jxzj.external.data.service.impl.insure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.alibaba.dubbo.config.annotation.Service;
import com.jxzj.external.data.dao.InsureQuotationTaskMapper;
import com.jxzj.external.data.entity.insure.InsureQuotationTask;
import com.jxzj.external.data.service.insure.IAPIInsureQuotationService;

@Service
public class InsureQuotationService implements IAPIInsureQuotationService {

    @Autowired
    private InsureQuotationTaskMapper insureQuotationTaskMapper;

    @Override
    public Long registerInsureQuotationTask(String imgKey, Long replyUserId) {

        Assert.hasLength(imgKey, "行驶证图片oss key不能为空");

        InsureQuotationTask entity = new InsureQuotationTask();
        // 暂时写死。来源=1 为钉钉应用h5页
        entity.setQuotationSource(1);
        entity.setReplyUserId(replyUserId);
        entity.setVehicleLicenseImgKey(imgKey);

        insureQuotationTaskMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public InsureQuotationTask getTaskById(Long id) {
        Assert.notNull(id, "任务id不能为空");
        return insureQuotationTaskMapper.selectById(id);
    }

}
