package com.gustofusion.gestionlivraison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionLivraisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionLivraisonApplication.class, args);
    }

}
