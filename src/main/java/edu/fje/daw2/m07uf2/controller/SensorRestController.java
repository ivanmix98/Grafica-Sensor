package edu.fje.daw2.m07uf2.controller;
import edu.fje.daw2.m07uf2.SensorRepositori;
import edu.fje.daw2.m07uf2.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

/**
 * Classe Controladora de peticions REST.
 * Retorna un missatge de prova del funcionament de Spring
 * @author sergi.grau@fje.edu
 * @version 1.0 21.3.19
 */
@RestController
public class SensorRestController {

    @Autowired
    private SensorRepositori sensorRepositori;

    @PutMapping("/data/{identitykey}/{valor}")
    public JSONObject putData(@PathVariable String identitykey,@PathVariable Double valor){
        JSONObject json = new JSONObject();

        Sensor s = sensorRepositori.findByidentitykey(identitykey);
        if(s != null){
            s.addData(valor);
            sensorRepositori.save(s);
            json.put("sesnor",s.getIdentitykey());
            json.put("valor",valor);
            json.put("status",200);

        }else{
            json.put("status",400);
            json.put("erro","Not exist sensor");
        }
        return json;
    }

    @GetMapping("/getdata/{identitykey}")
    public JSONObject getData(@PathVariable String identitykey){
        JSONObject json = new JSONObject();
        Sensor s = sensorRepositori.findByidentitykey(identitykey);
        if(s != null){
            json.put("sensor",s.getIdentitykey());
            json.put("data",s.getLluminositat());

        }else{
            json.put("status",400);
            json.put("erro","Not exist sensor");
        }
        return json;
    }
}