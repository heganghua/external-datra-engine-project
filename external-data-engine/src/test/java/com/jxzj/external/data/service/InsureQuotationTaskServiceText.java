package com.jxzj.external.data.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxzj.external.data.ExternalDataApplicationTest;
import com.jxzj.external.data.job.GetPingAnInsurePdfJob;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExternalDataApplicationTest.class)
public class InsureQuotationTaskServiceText {

    @Autowired
    private GetPingAnInsurePdfJob getPingAnInsurePdfJob;

    @Test
    public void text1() {
        getPingAnInsurePdfJob.insureQuotationTaskRemake();
    }

}
