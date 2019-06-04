package edu.fje.daw2.m07uf2.model;

import org.springframework.data.annotation.Id;

public class Moneda {
    public String descripció;
    public int codi;
    public int cotització;

    public Moneda() {}

    public Moneda(String descripció,int codi,int cotització) {
        this.descripció = descripció;
        this.codi = codi;
        this.cotització = cotització;
    }


    public String descripció() {
        return descripció;
    }

    public void descripció(String descripció) {
        this.descripció = descripció;
    }

    public int codi() {
        return codi;
    }

    public void codi(int codi) {
        this.codi = codi;
    }

    public int cotització() {
        return cotització;
    }

    public void cotització(int cotització) {
        this.cotització = cotització;
    }
}
