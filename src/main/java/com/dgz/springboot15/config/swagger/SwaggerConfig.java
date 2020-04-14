package com.dgz.springboot15.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2     //启用Swagger2
public class SwaggerConfig {

    /**
     *  配置Swagger信息,站点:localhost:80/swagger-ui.html
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dgz.springboot15.controller"))  //扫描控制器的包
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("springboot15项目API文档")
                        .description("各种整合")
                        .version("1.0.0")
                        .contact(new Contact("李大狗","mrdeng.club/word","1737245872@qq.com"))
                        .license("The Apache License")
                        .licenseUrl("mrdeng.club/word")
                        .build());
    }
}