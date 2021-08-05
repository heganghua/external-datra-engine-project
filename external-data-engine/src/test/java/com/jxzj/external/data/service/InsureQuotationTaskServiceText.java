package com.jxzj.external.data.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxzj.external.data.aspacetdemo.Say;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsureQuotationTaskServiceText {

    @Autowired
    private Say say;

    @Test
    public void text1() {
        say.sayHello("changsha");
    }

    @Test
    public void test3() throws Exception {

        say.getStr("abcdefg");
    }

}
