package edu.fje.daw2.prova.model;


import org.springframework.data.annotation.Id;

public class Client {
    @Id
    public String id;

    public String nom;
    public String cognom;

    public Client() {}

    public Client(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id=%s, nom='%s', cognom='%s']",
                id, nom, cognom);
    }

}