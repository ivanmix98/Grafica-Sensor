package edu.fje.daw2.m07uf2;

import edu.fje.daw2.m07uf2.model.Moneda;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Interficie de persistència amb Spring Data i MongoDB.
 * @author sergi.grau@fje.edu
 * @version  1.0 4.4.2019
 */

public interface MonedaRepositori extends MongoRepository<Moneda, String> {

    Moneda findByDescripció(String descripció);
    List<Moneda> findByCodi(int codi);
    List<Moneda> findByCotització(int cotització);

}