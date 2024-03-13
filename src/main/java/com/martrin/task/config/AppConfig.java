package com.martrin.task.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.martrin.task.repository.mapper")
public class AppConfig {
    // Configuración adicional de Spring, si es necesario
}
