package it.nava.progettopizza;

import java.util.ArrayList;
import java.util.List;

public class ListeProdotti {

    String categorieProdotti[] = { "Pizza", "Panino", "Bibita", "Stuzzicheria" };

    List<Prodotto> listaPizze = new ArrayList<Prodotto>(); // Categoria 1
    List<Prodotto> listaPanini = new ArrayList<Prodotto>(); // Categoria 2
    List<Prodotto> listaBibite = new ArrayList<Prodotto>(); // Categoria 3
    List<Prodotto> listaStuzzicherie = new ArrayList<Prodotto>(); // Categoria 4

    public ListeProdotti(){
        letturaProdotti();
    }

    private void letturaProdotti(){
        //MetodiPubblici.richiestaMenu();
    }

    // Get e Set

    public String getNomePizza(int pos){
        Prodotto pizza = listaPizze.get(pos);
        return pizza.getNome();
    }

    public String getPrezzoPizza(int pos){
        Prodotto pizza = listaPizze.get(pos);
        return String.format("%.2f", pizza.getCosto());
    }

    public String getNomePanino(int pos){
        Prodotto panino = listaPanini.get(pos);
        return panino.getNome();
    }

    public String getPrezzoPanino(int pos){
        Prodotto panino = listaPanini.get(pos);
        return String.format("%.2f", panino.getCosto());
    }

    public String getNomeBibita(int pos){
        Prodotto bibita = listaBibite.get(pos);
        return bibita.getNome();
    }

    public String getPrezzoBibita(int pos){
        Prodotto bibita = listaBibite.get(pos);
        return String.format("%.2f", bibita.getCosto());
    }

    public String getNomeStuzzicheria(int pos){
        Prodotto stuzzicheria = listaStuzzicherie.get(pos);
        return stuzzicheria.getNome();
    }

    public String getPrezzoStuzzicheria(int pos){
        Prodotto stuzzicheria = listaStuzzicherie.get(pos);
        return String.format("%.2f", stuzzicheria.getCosto());
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
