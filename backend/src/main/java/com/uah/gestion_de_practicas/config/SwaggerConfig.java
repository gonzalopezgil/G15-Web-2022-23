package com.uah.gestion_de_practicas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuración Swagger para la generación de documentación de la API REST
 *
 * HTML: http://localhost:8081/swagger-ui/
 * JSON: http://localhost:8081/v2/api-docs
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Gestión de Practicas API REST",
                "Documentación de la API REST que gestiona las prácticas de los alumnos de la UAH",
                "1.0",
                "http://www.google.com",
                new Contact("Backend Team", "https://github.com/gonzalopezgil/G15-Web-2022-23", "gonzalo.lopezg@edu.uah.es"),
                "UAH License",
                "http://www.google.com",
                Collections.emptyList());
    }
}