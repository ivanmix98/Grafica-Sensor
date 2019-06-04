package edu.fje.daw2.m07uf2.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Sensor {
    @Id
    public String id;
    public String identitykey;
    public ArrayList<Double> lluminositat;



    public Sensor() {}

    public Sensor(String identitykey) {
        this.lluminositat = new ArrayList<>();
        this.identitykey = identitykey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentitykey() {return identitykey;}

    public void setIdentitykey(String identitykey) {this.identitykey = identitykey;}

    public ArrayList<Double> getLluminositat() {
        return lluminositat;
    }

    public void setLluminositat(ArrayList<Double> lluminositat) {
        this.lluminositat = lluminositat;
    }

    public void addData(Double valor){
        this.lluminositat.add(valor);
    }
}
