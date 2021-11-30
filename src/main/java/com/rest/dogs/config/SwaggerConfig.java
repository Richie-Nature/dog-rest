package com.rest.dogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dog-Breed API",
                "This API returns a list of dogs and their breeds",
                "1.0",
                "http://localhost:8000",
                new Contact(
                        "Imoh Obot",
                        "github.com/Richie-Nature",
                        "imohobot.dev@gmail.com"),
                "My License", "http://localhost:8000/#", Collections.emptyList()
        );
    }
    /**
     *
     * .select()
     *                 .apis(RequestHandlerSelectors.basePackage("com.atividades.apirest"))
     *                 .paths(regex("/api.*"))
     *                 .build()
     *                 .apiInfo(metaInfo());*/
}
