package edu.fje.daw2.m07uf2.controller;

import edu.fje.daw2.m07uf2.ClientRepositori;
import edu.fje.daw2.m07uf2.SensorRepositori;
import edu.fje.daw2.m07uf2.model.Client;
import edu.fje.daw2.m07uf2.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Controlador de clients
 * Verifica el funcionament de curl
 * @author sergi.grau@fje.edu
 * @version 1.0 21.3.19
 */
@Controller
@SessionAttributes("sensors")
public class SensorController {

    @Autowired
    private SensorRepositori repositori;

    @ModelAttribute("sensors")
    public List<Sensor> inicialitzar() {

        List<Sensor> sensors = new ArrayList<>();
        for (Sensor s : repositori.findAll()) {
           sensors.add(s);
        }
        return sensors;
    }



    @RequestMapping(value={"/sensor"})
    String mostrarSensor() {
        return("sensor");
    }

    @RequestMapping(value={"/llistaSensors"})
    String mostrarSensor2() {
        return("llistaSensors");
    }

    @RequestMapping("/grafica/{identitykey}")
    public ModelAndView getApplication(@PathVariable String identitykey) {
        ModelAndView mv = new ModelAndView();

        Sensor s = repositori.findByidentitykey(identitykey);
        mv.setViewName("/grafica");
        mv.addObject("sensor",s);
        return mv;
    }

    @RequestMapping(value={"/grafica"})
    String mostrarGrafica() {
        return("grafica");
    }

    @RequestMapping(value="/desarSensor", method = RequestMethod.POST)
    String desarSensor(@SessionAttribute("sensors") List<Sensor> sensors,
                            @RequestParam (defaultValue = "") String identitykey,

                            ModelMap model) throws IOException {



        Sensor s = new Sensor(identitykey);


        repositori.save(s);



        if(!model.containsAttribute("sensors")) {
            model.addAttribute("sensors", sensors);
        }
        sensors.add(s);


        return("llistaSensors");
    }

    @RequestMapping(value="/esborrarSensor", method = RequestMethod.GET)
    String esborrarSensor(@SessionAttribute("sensors") List<Sensor> sensors,
                       @RequestParam (defaultValue = "") String id){

        System.out.println(id);

        repositori.deleteById(id);
        Sensor t = new Sensor();
        t.setId(id);
        sensors.remove(t);

        return("llistaSensors");
    }

}
