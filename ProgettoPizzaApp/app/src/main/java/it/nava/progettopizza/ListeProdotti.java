package it.nava.progettopizza;

import java.util.ArrayList;
import java.util.List;

public class ListeProdotti {

    String categorieProdotti[] = { "Pizza", "Panino", "Bibita", "Stuzzicheria" };

    List<Prodotto> listaPizze = new ArrayList<Prodotto>();
    List<Prodotto> listaPanini = new ArrayList<Prodotto>();
    List<Prodotto> listaBibite = new ArrayList<Prodotto>();
    List<Prodotto> listaStuzzicherie = new ArrayList<Prodotto>();

    public ListeProdotti(){
        letturaProdotti();
    }

    private void letturaProdotti(){

    }
}
