package com.jxzj.external.data.job;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.jxzj.external.data.dao.InsureQuotationTaskMapper;
import com.jxzj.external.data.entity.insure.InsureQuotationTask;
import com.jxzj.external.data.service.insure.IAutoQuoteService;
import com.jxzj.external.data.service.insure.IInsureQuotationTaskService;
import com.jxzj.external.data.service.insure.IPingAnInsureLoginService;

@Component
public class GetPingAnInsurePdfJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetPingAnInsurePdfJob.class);

    @Autowired
    private IPingAnInsureLoginService pingAnInsureLoginService;

    @Autowired
    private IAutoQuoteService autoQuoteService;

    @Autowired
    private IInsureQuotationTaskService insureQuotationTaskService;

    @Autowired
    private InsureQuotationTaskMapper insureQuotationTaskMapper;

    /**
     * 自循环方式
     * 
     * @author heganghua
     * @date 2020/12/25
     * @return void
     */
    public void insureQuotationTask() {

        List<InsureQuotationTask> taskList = insureQuotationTaskService.queryInsureQuotaionTask();

        // 如何连接到一个现有chromeDriver实例
        ChromeDriver initWithChrome = pingAnInsureLoginService.initWithChrome();
        ChromeDriver driver = pingAnInsureLoginService.loginPingAnInsure(initWithChrome);
        ChromeDriver autoOperate = autoQuoteService.autoOperate(driver);

        while (true) {
            if (CollectionUtils.isEmpty(taskList)) {
                LOGGER.info("================ 进入休眠，保活状态中-时间间隔10S");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                driver.navigate().refresh();
                driver = autoQuoteService.specialVehicleSelect(driver);
            }
            for (InsureQuotationTask insureQuotationTask : taskList) {
                LOGGER.info(ReflectionToStringBuilder.toString(insureQuotationTask));
                driver = autoQuoteService.writeInData(autoOperate, insureQuotationTask);
                // 刷新， 然后重新选择特种车辆
                driver.navigate().refresh();
                driver = autoQuoteService.specialVehicleSelect(driver);
            }
            // 再次查询
            taskList = insureQuotationTaskService.queryInsureQuotaionTask();
        }
    }

    /**
     * 重制版
     * 
     * @author heganghua
     * @date 2020/12/25
     * @return void
     */
    public void insureQuotationTaskRemake() {
        // 如何连接到一个现有chromeDriver实例
        ChromeDriver initWithChrome = pingAnInsureLoginService.initWithChrome();
        ChromeDriver driver = pingAnInsureLoginService.loginPingAnByCookies(initWithChrome);

    }

    @Scheduled(fixedDelay = 10 * 1000)
    public void pingAnJob() {
        LOGGER.info("================》。。。。");
        LOGGER.info("================》。。。。");
        LOGGER.info("================》。。。。");
        // this.insureQuotationTaskRemake();
        this.insureQuotationTask();

    }

}
