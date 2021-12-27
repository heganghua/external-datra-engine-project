package com.jxzj.external.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@DubboComponentScan("com.jxzj.external.data.service")
@MapperScan("com.jxzj.external.data.dao")
@EnableSwagger2
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
public class JxzjExternalDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxzjExternalDataApplication.class, args);
    }
}
