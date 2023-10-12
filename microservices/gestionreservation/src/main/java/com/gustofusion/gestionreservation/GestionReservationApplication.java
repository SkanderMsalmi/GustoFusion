package com.gustofusion.gestionreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionReservationApplication.class, args);
	}

}
