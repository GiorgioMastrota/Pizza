package it.nava.progettopizzacomande;

public class Prodotto {

    int id;
    String nome, descrizione;
    double costo;

    public Prodotto(int id, String nome, String descrizione, double costo){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    // Get e set

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getCosto() {
        return costo;
    }
}
