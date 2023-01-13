package com.uah.gestion_de_practicas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Configuración Swagger para la generación de documentación de la API REST
 *
 * HTML: http://localhost:8081/swagger-ui/
 * JSON: http://localhost:8081/v2/api-docs
 */
@Configuration
public class SwaggerConfig {

    /** 
     * Configuration of the API Key
     */
    private ApiKey apiKey() { 
        return new ApiKey("JWT", "Authorization", "header"); 
    }

    /** 
     * Configuration of the security context
     */
    private SecurityContext securityContext() { 
        return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
    } 
    
    /** 
     * Configuration of the default authorization
     */
    private List<SecurityReference> defaultAuth() { 
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
        authorizationScopes[0] = authorizationScope; 
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
    }

    /** 
     * Configuration of the Swagger API
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /** 
     * Configuration of the API details
     */
    private ApiInfo apiDetails(){
        return new ApiInfo("Gestión de Practicas API REST",
                "Documentación de la API REST que gestiona las prácticas de los alumnos de la UAH",
                "2.0-SNAPSHOT",
                "http://www.google.com",
                new Contact("Backend Team", "https://github.com/gonzalopezgil/G15-Web-2022-23", "gonzalo.lopezg@edu.uah.es"),
                "UAH License",
                "http://www.google.com",
                Collections.emptyList());
    }
}