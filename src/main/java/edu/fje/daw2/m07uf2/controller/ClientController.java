package edu.fje.daw2.m07uf2.controller;

import edu.fje.daw2.m07uf2.ClientRepositori;
import edu.fje.daw2.m07uf2.MonedaRepositori;
import edu.fje.daw2.m07uf2.model.Client;
import edu.fje.daw2.m07uf2.model.Moneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de clients
 * Verifica el funcionament de curl
 * @author sergi.grau@fje.edu
 * @version 1.0 21.3.19
 */
@Controller
@SessionAttributes("clients")
public class ClientController {

    @Autowired
    private ClientRepositori repositori;

    @ModelAttribute("clients")
    public List<Client> inicialitzar() {

        List<Client> clients = new ArrayList<>();
        for (Client c : repositori.findAll()) {
           clients.add(c);
        }
        return clients;
    }



    @RequestMapping(value={"/client", "/usuari"})
    String mostrarFormulari() {
        return("formulari");
    }

    @RequestMapping(value="/taula")
    String mostrarTaula() {
        return("TaulaJSTL");
    }

    @RequestMapping(value="/llistaclients")
    String mostrarTaula2() {
        return("llistaClients");
    }

    @RequestMapping(value="/desarClient", method = RequestMethod.POST)
    String desarClient(@SessionAttribute("clients") List<Client> clients,
                            @RequestParam (defaultValue = "") String nom,
                            @RequestParam (defaultValue = "") String cognom,
                       @RequestParam (defaultValue = "") int volumCompres,
                            ModelMap model){
        Client c = new Client(nom, cognom, volumCompres);
        repositori.save(c);

        if(!model.containsAttribute("clients")) {
            model.addAttribute("clients", clients);
        }
        clients.add(c);


        return("llistaClients");
    }

    @RequestMapping(value="/esborrarClient", method = RequestMethod.GET)
    String esborrarClient(@SessionAttribute("clients") List<Client> clients,
                       @RequestParam (defaultValue = "") String id){

        System.out.println(id);

        repositori.deleteById(id);
        Client t = new Client();
        t.setId(id);
        clients.remove(t);

        return("llistaClients");
    }

}
