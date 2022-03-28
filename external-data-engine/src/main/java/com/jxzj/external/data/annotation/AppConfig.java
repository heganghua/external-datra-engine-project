package com.jxzj.external.data.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({CustomConfiguration.class})
@Configuration
public class AppConfig {

}
