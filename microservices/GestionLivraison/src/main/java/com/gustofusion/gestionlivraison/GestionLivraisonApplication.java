package com.gustofusion.gestionlivraison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"com.gustofusion.gestionlivraison.entities", "com.gustofusion.gestionemploye.entities","com.gustofusion.gestionmenu.entities"})
@EnableJpaRepositories(basePackages = {"com.gustofusion.gestionmenu.repositories","com.gustofusion.gestionlivraison.repositories","com.gustofusion.gestionemploye.repositories"})
public class GestionLivraisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionLivraisonApplication.class, args);
    }

}
