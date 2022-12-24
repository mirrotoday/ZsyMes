package com.siyu.zsymes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket restApi() {
        // 指定扫描包路径
        //swagger访问：/api/base/swagger-ui.html
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("My Api")
                //.enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.siyu.zsymes.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact DEFAULT_CONTACT = new Contact("", "HTTP", "");
        return new ApiInfo("MES基础API文档", "Api Documentation",
                "1.0", "", DEFAULT_CONTACT,
                "Apache 2.0",
                "", new ArrayList());
    }

}
