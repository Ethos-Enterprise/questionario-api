package com.ethos.questionarioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QuestionarioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionarioApiApplication.class, args);
		System.out.println("Teste watchtower");
	}

}
