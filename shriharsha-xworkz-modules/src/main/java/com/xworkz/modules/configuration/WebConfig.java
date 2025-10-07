package com.xworkz.modules.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz.modules")
@EnableWebMvc
@EnableScheduling
public class WebConfig implements WebMvcConfigurer {

    public WebConfig(){
        System.out.println("running webConfig ");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
   public InternalResourceViewResolver internalResourceViewResolver(){
       return new InternalResourceViewResolver("/",".jsp");
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Serve Swagger UI webjar
//        registry.addResourceHandler("/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/4.15.5/");
//
//        // Serve OpenAPI JSON
//        registry.addResourceHandler("/v3/api-docs/**")
//                .addResourceLocations("classpath:/META-INF/resources/");
//    }

}
