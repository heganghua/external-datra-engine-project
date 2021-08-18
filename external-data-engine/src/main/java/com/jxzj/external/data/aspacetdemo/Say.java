package com.jxzj.external.data.aspacetdemo;

import org.springframework.stereotype.Component;

import com.jxzj.external.data.entity.insure.InsureQuotationTask;

@Component
public class Say implements ISay {

    @Override
    public InsureQuotationTask sayHello(String str) {
        System.out.println("say hello word!" + str);
        InsureQuotationTask insureQuotationTask = new InsureQuotationTask();
        insureQuotationTask.setId(1L);
        insureQuotationTask.setState(999);
        return insureQuotationTask;
    }

    @Override
    public String getStr(String str) {
        // int i = 5 / 0;
        System.out.println("【哦豁， 异常了】");
        return str.toUpperCase();
    }

}
