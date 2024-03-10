package com.dannyprats.taskboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite CORS en todas las rutas
                .allowedOrigins("http://localhost") // Permite solicitudes desde este origen
                .allowedMethods("*") // Permite todos los métodos HTTP, incluido DELETE
                .allowedHeaders("*") // Permite todas las cabeceras
                .allowCredentials(true); // Permite credenciales
            }
        };
    }
}