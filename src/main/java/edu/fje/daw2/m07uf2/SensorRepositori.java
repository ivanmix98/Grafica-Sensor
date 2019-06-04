package edu.fje.daw2.m07uf2;

import edu.fje.daw2.m07uf2.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Interficie de persistència amb Spring Data i MongoDB.
 * @author sergi.grau@fje.edu
 * @version  1.0 4.4.2019
 */

public interface SensorRepositori extends MongoRepository<Sensor, String> {

    Sensor findByidentitykey(String identitykey);
}