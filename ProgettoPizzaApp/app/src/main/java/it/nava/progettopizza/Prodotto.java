package it.nava.progettopizza;

public class Prodotto {

    int id, categoria;
    String nome, descrizione;
    double costo;

    public Prodotto(int id, String nome, int categoria, String descrizione, double costo){
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

    public int getCategoria() {
        return categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getCosto() {
        return costo;
    }
}
