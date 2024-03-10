package com.dannyprats.taskboot;

import com.dannyprats.taskboot.model.Task;
import com.dannyprats.taskboot.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskbootApplication.class, args);
	}

	// Agrega una semilla para la base de datos..
	@Bean
	CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
		return args -> {
			java.util.List<Task> tasks = List.of(
				new Task(UUID.randomUUID(), "Realizar investigación de mercado", "Investigar el mercado para identificar oportunidades", "pendiente", "Equipo de Negocios"),
				new Task(UUID.randomUUID(), "Desarrollar estrategia de negocios", "Crear un plan estratégico para el negocio", "procesando", "Equipo directivo"),
				new Task(UUID.randomUUID(), "Implementar plan de marketing", "Ejecutar el plan de marketing para promocionar el negocio", "finalizado", "Equipo de marketing")
			);
			taskRepository.saveAll(tasks);

			taskRepository.findAll().stream().forEach(System.out::println);
		};
	}

}
