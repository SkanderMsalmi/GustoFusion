package com.gustofusion.gestionemploye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionEmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEmployeApplication.class, args);
	}

}
