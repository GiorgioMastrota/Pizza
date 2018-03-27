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

    public String getNomePizza(int id){
        for (int i = 0; i < listaPizze.size(); i++) {
            Prodotto pizza = listaPizze.get(i);
            if (pizza.getId() == id)
                return pizza.getNome();
        }
        return null;
    }

    public String getPrezzoPizza(int id){
        for (int i = 0; i < listaPizze.size(); i++){
            Prodotto pizza = listaPizze.get(i);
            if (pizza.getId() == id)
                return String.format("%.2f", pizza.getCosto());
        }
        return null;
    }

    public String getNomePanino(int id){
        for (int i = 0; i < listaPanini.size(); i++) {
            Prodotto panino = listaPanini.get(i);
            if (panino.getId() == id)
                return panino.getNome();
        }
        return null;
    }

    public String getPrezzoPanino(int id){
        for (int i = 0; i < listaPanini.size(); i++){
            Prodotto panino = listaPanini.get(i);
            if (panino.getId() == id)
                return String.format("%.2f", panino.getCosto());
        }
        return null;
    }

    public String getNomeBibita(int id){
        for (int i = 0; i < listaBibite.size(); i++) {
            Prodotto bibita = listaBibite.get(i);
            if (bibita.getId() == id)
                return bibita.getNome();
        }
        return null;
    }

    public String getPrezzoBibita(int id){
        for (int i = 0; i < listaBibite.size(); i++){
            Prodotto bibita = listaBibite.get(i);
            if (bibita.getId() == id)
                return String.format("%.2f", bibita.getCosto());
        }
        return null;
    }


    public String getNomeStuzzicheria(int id){
        for (int i = 0; i < listaStuzzicherie.size(); i++) {
            Prodotto stuzzicheria = listaStuzzicherie.get(i);
            if (stuzzicheria.getId() == id)
                return stuzzicheria.getNome();
        }
        return null;
    }

    public String getPrezzoStuzzicheria(int id){
        for (int i = 0; i < listaStuzzicherie.size(); i++){
            Prodotto stuzzicheria = listaStuzzicherie.get(i);
            if (stuzzicheria.getId() == id)
                return String.format("%.2f", stuzzicheria.getCosto());
        }
        return null;
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
