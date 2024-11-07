package com.example.teachplatform.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {
    @Bean
    public GroupedOpenApi userApi() {      // create an api group
        return GroupedOpenApi.builder()
                .group("TeachPlatform-api")         // group name
                .pathsToMatch("/api/**")  // interface request path rule
                .build();
    }



    /***
     * @description customise interface information
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("TeachPlatform API document")
                        .version("1.0")
                        .description("teach platform API document")
                        .contact(new Contact().name("Jerry"))); // set author name
    }

}