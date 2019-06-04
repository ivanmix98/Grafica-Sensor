package edu.fje.daw2.prova;

import edu.fje.daw2.prova.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 */
@SpringBootApplication
public class M07uf2Application implements CommandLineRunner {


    @Autowired
    private ClientRepositori repositori;

    public static void main(String[] args) {
        SpringApplication.run(M07uf2Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        repositori.deleteAll();

        repositori.save(new Client("Sergi", "Grau"));
        repositori.save(new Client("Joan", "Grau"));

        System.out.println("findAll():");
        System.out.println("-------------------------------");
        for (Client c : repositori.findAll()) {
            System.out.println(c);
        }
        System.out.println();
        System.out.println(repositori.findByCognom("Sergi"));

        for (Client c : repositori.findByCognom("Grau")) {
            System.out.println(c);
        }

    }


}
