package com.angularSpringBoot.demo;

import com.angularSpringBoot.demo.model.Course;
import com.angularSpringBoot.demo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.angularSpringBoot.demo.repository")
public class AngularSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringBootApplication.class, args);
	}
	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository){
		return args -> {
			//courseRepository.deleteAll();
			Course c = new Course();
			c.setName("Angular com Spring Boot");
			c.setCategory("front-end");

			Course novo = new Course();
			novo.setName("Spring Boot");
			novo.setCategory("back-end");
			courseRepository.save(c);
			courseRepository.save(novo);
		};
	}
}
