package edu.fje.daw2.prova;

import edu.fje.daw2.prova.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ClientRepositori extends MongoRepository<Client, String> {

    public Client findByNom(String nom);
    public List<Client> findByCognom(String cognom);

}