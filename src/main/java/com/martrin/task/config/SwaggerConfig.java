package com.martrin.task.config;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;*/


/**
 * configuracion Swagger para la generacion de documentacion de API REST
 *
 * HTML: http://localhost:8081/swagger-ui/index.html
 */

/*@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.martrin.task.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Book API REST",
                "Library Api Rest Docs",
                "1.0",
                "https://google.com.py",
                new Contact("Martin", "https://google.com.py", "martin84zarate@gmail.com"),
                "PRUEBA TECNICA",
                "https://google.com.py",
                Collections.emptyList());
    }
}
*/