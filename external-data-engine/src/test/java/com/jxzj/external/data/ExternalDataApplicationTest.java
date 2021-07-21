package com.jxzj.external.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

@SpringBootApplication
@DubboComponentScan("com.jxzj.external.data.service")
@MapperScan("com.jxzj.external.data.dao")
public class ExternalDataApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(ExternalDataApplicationTest.class, args);
    }

}
