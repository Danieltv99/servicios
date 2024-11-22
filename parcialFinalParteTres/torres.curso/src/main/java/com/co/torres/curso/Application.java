package com.co.torres.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.co.torres.common.usuario.models.entity.*", "com.co.torres.curso.models,entity.*"})
@EnableJpaRepositories({"com.co.torres.common.usuario.models.entity.*", "com.co.torres.curso.models,entity.*"})
@EntityScan({"com.co.torres.common.usuario.models.entity.*", "com.co.torres.curso.models,entity.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
