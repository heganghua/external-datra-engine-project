package com.jxzj.external.data.service.insure;

import com.jxzj.external.data.entity.insure.InsureQuotationTask;

public interface IAPIInsureQuotationService {

    /**
     * 根据行驶证图片，创建保险询价任务
     * 
     * @param imgKey 行驶证图片。不可空
     * @param userId 报价完成后，通知目标userId
     * @return
     */
    Long registerInsureQuotationTask(String imgKey, Long userId);

    /**
     * 根据任务id 查询保险询价任务详情
     * 
     * @param id
     * @return
     */
    InsureQuotationTask getTaskById(Long id);

}
