package com.study.configuration;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * 功能描述: swagger3 配置类
 * @author husong
 * @date 2022 年 12 月 13 日 17:30
 */
@Configuration
@EnableOpenApi
public class Swagger3Configuration {
    @Value("spring.application.name")
    String serviceName; //服务器名
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(serviceName+"服务接口文档")
                .description("REST API接口统一响应接口实体")
                .contact(new Contact("学习swagger3", "http://www.studySwagger3.cn", "1318973@foxmail.com"))
                .version("1.0")
                .build();
    }

//
//    private List<ApiKey> securitySchemes() {
//        List<ApiKey> apiKeyList = Lists.newArrayList();
//        apiKeyList.add(new ApiKey(HttpHeaders.AUTHORIZATION, HttpHeaders.AUTHORIZATION, "header"));
//        apiKeyList.add(new ApiKey("Cache-Authorization", "Cache-Authorization", "header"));
//        return apiKeyList;
//    }
//
//    private List<SecurityContext> securityContexts() {
//        List<SecurityContext> securityContexts = Lists.newArrayList();
//        securityContexts.add(SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                .build());
//        return securityContexts;
//    }
//
//    List<SecurityReference> defaultAuth() {
//        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
//        authorizationScopes[0] = new AuthorizationScope("read", "read all");
//        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
//        authorizationScopes[2] = new AuthorizationScope("write", "write all");
//        List<SecurityReference> securityReferences = Lists.newArrayList();
//        securityReferences.add(new SecurityReference(HttpHeaders.AUTHORIZATION, authorizationScopes));
//        securityReferences.add(new SecurityReference("Cache-Authorization", authorizationScopes));
//        return securityReferences;
//    }

}
