package it.nava.progettopizza;

public class Prodotto {

    int id;
    String nome, categoria, descrizione;
    float costo;

    public Prodotto(int id, String nome, String categoria, String descrizione, float costo){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descrizione = descrizione;
        this.costo = costo;
    }


}
