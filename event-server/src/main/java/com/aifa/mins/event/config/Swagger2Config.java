package com.aifa.mins.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 微应用接口服务Swagger配置
 * 
 * @author Jeking Yang
 * @version 5.0.0
 * @since 2019.04.04
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true", matchIfMissing = true)
public class Swagger2Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.aifa.mins"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Aifa Mins event 接口文档")
                .description("Aifa Mins event 微应用开发平台接口说明文档")
                //服务条款网址
                .termsOfServiceUrl("https://www.it2000.com.cn")
                .version("1.0")
                .contact(new Contact("Jeking Yang", "http://www.it2000.com.cn", "yangguangjian@it2000.com.cn"))
                .build();
    }
}