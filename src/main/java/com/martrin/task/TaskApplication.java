package com.martrin.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {
	private static final Logger logger = LoggerFactory.getLogger(TaskApplication.class);

	public static void main(String[] args) {
		logger.info("<=== Iniciando {} ... ===>", TaskApplication.class.getName());
		SpringApplication.run(TaskApplication.class, args);
		logger.info("<=== {} Iniciado correctamente ===>", TaskApplication.class.getName());
	}


}
