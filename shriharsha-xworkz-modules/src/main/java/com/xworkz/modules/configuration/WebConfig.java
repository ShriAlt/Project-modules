package com.xworkz.modules.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.xworkz.modules")
public class WebConfig implements WebMvcConfigurer {

}
