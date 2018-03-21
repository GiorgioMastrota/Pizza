package it.nava.progettopizza;

public class Prodotto {

    int id;
    String nome, categoria, descrizione;
    double costo;

    public Prodotto(int id, String nome, String categoria, String descrizione, double costo){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    // get e set


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getCosto() {
        return costo;
    }
}
