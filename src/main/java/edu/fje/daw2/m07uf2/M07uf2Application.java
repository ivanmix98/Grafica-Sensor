package edu.fje.daw2.m07uf2;

import edu.fje.daw2.m07uf2.model.Client;
import edu.fje.daw2.m07uf2.model.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * Classe principal d'Spring
 * utilitza un microservei per accedir a MongoDB.
 * A més realitza una càrrega inicial de dades
 * @author sergi.grau@fje.edu
 * @version  1.0 4.4.2019
 */
@SpringBootApplication
public class M07uf2Application {

    public static void main(String[] args) {
        SpringApplication.run(M07uf2Application.class, args);
    }

}
