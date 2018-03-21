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
        //MetodiPubblici.richiestaMenu();
    }

    // Get e Set

    public int getNumPizze(){
        return listaPizze.size();
    }

    public int getNumPanini(){
        return listaPanini.size();
    }

    public int getNumBibite(){
        return listaBibite.size();
    }

    public int getNumStuzzicherie(){
        return listaStuzzicherie.size();
    }

    public String getNomePizza(int pos){
        Prodotto pizza = listaPizze.get(pos);
        return pizza.getNome();
    }

    public List<Prodotto> getListaPizze() {
        return listaPizze;
    }

    public List<Prodotto> getListaPanini() {
        return listaPanini;
    }

    public List<Prodotto> getListaBibite() {
        return listaBibite;
    }

    public List<Prodotto> getListaStuzzicherie() {
        return listaStuzzicherie;
    }
}
