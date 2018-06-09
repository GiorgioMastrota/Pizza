package it.nava.progettopizzacomande;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListeProdotti {

    private static String categorieProdotti[] = { "Pizza", "Panino", "Bibita", "Stuzzicheria" };

    private static List<Prodotto> listaPizze = new ArrayList<>(); // Categoria 1
    private static List<Prodotto> listaPanini = new ArrayList<>(); // Categoria 2
    private static List<Prodotto> listaBibite = new ArrayList<>(); // Categoria 3
    private static List<Prodotto> listaStuzzicherie = new ArrayList<>(); // Categoria 4

    public ListeProdotti(){
        letturaProdotti();
    }

    public static void letturaProdotti(){
        OperazioniDB pizze = new OperazioniDB(0);
        OperazioniDB panini = new OperazioniDB(0);
        OperazioniDB bibite = new OperazioniDB(0);
        OperazioniDB stuzzicherie = new OperazioniDB(0);
        try {
            String pizzeLette = pizze.execute("Pizza").get();
            String paniniLetti = panini.execute("Panino").get();
            String bibiteLette = bibite.execute("Bibite").get();
            String stuzzicherieLette = stuzzicherie.execute("Stuzzicheria").get();
            inizializzaMenu("Pizza", pizzeLette);
            inizializzaMenu("Panino", paniniLetti);
            inizializzaMenu("Bibite", bibiteLette);
            inizializzaMenu("Stuzzicheria", stuzzicherieLette);

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("MainActivity: errore nell'esecuzione dei thread per la comunicazione col db.");
        }
    }

    private static void inizializzaMenu(String categoria, String stringa) {
        String[] righeLette = stringa.split(":");
        for (int i = 0; i < righeLette.length; i++) {
            int id;
            String nome, descrizione;
            double costo;
            String[] rigaSplit = righeLette[i].split(";");
            id = Integer.parseInt(rigaSplit[0]);
            nome = rigaSplit[1];
            costo = Double.parseDouble(rigaSplit[2]);
            descrizione = rigaSplit[3];
            switch (categoria) {
                case "Pizza": {
                    Prodotto daInserire = new Prodotto(id, nome, 1, descrizione, costo);
                    aggiungiPizza(daInserire);
                    break;
                }
                case "Panino": {
                    Prodotto daInserire = new Prodotto(id, nome, 2, descrizione, costo);
                    aggiungiPanino(daInserire);
                    break;
                }
                case "Bibite": {
                    Prodotto daInserire = new Prodotto(id, nome, 3, descrizione, costo);
                    aggiungiBibita(daInserire);
                    break;
                }
                case "Stuzzicheria": {
                    Prodotto daInserire = new Prodotto(id, nome, 4, descrizione, costo);
                    aggiungiStuzzicheria(daInserire);
                    break;
                }
            }
        }
    }

    // Aggiunte prodotti

    public static void aggiungiPizza(Prodotto prodotto){
        listaPizze.add(prodotto);
    }
    public static void aggiungiPanino(Prodotto prodotto){
        listaPanini.add(prodotto);
    }
    public static void aggiungiBibita(Prodotto prodotto){
        listaBibite.add(prodotto);
    }
    public static void aggiungiStuzzicheria(Prodotto prodotto){
        listaStuzzicherie.add(prodotto);
    }


    // Get

    public static String getNomePizza(int id){
        for (int i = 0; i < listaPizze.size(); i++) {
            Prodotto pizza = listaPizze.get(i);
            if (pizza.getId() == id)
                return pizza.getNome();
        }
        return null;
    }

    @SuppressLint("DefaultLocale")
    public static double getPrezzoPizza(int id){
        for (int i = 0; i < listaPizze.size(); i++){
            Prodotto pizza = listaPizze.get(i);
            if (pizza.getId() == id)
                return pizza.getCosto();
        }
        return 0.0;
    }

    public static String getNomePanino(int id){
        for (int i = 0; i < listaPanini.size(); i++) {
            Prodotto panino = listaPanini.get(i);
            if (panino.getId() == id)
                return panino.getNome();
        }
        return null;
    }

    @SuppressLint("DefaultLocale")
    public static double getPrezzoPanino(int id){
        for (int i = 0; i < listaPanini.size(); i++){
            Prodotto panino = listaPanini.get(i);
            if (panino.getId() == id)
                return panino.getCosto();
        }
        return 0.0;
    }

    public static String getNomeBibita(int id){
        for (int i = 0; i < listaBibite.size(); i++) {
            Prodotto bibita = listaBibite.get(i);
            if (bibita.getId() == id)
                return bibita.getNome();
        }
        return null;
    }

    @SuppressLint("DefaultLocale")
    public static double getPrezzoBibita(int id){
        for (int i = 0; i < listaBibite.size(); i++){
            Prodotto bibita = listaBibite.get(i);
            if (bibita.getId() == id)
                return bibita.getCosto();
        }
        return 0.0;
    }


    public static String getNomeStuzzicheria(int id){
        for (int i = 0; i < listaStuzzicherie.size(); i++) {
            Prodotto stuzzicheria = listaStuzzicherie.get(i);
            if (stuzzicheria.getId() == id)
                return stuzzicheria.getNome();
        }
        return null;
    }

    @SuppressLint("DefaultLocale")
    public static double getPrezzoStuzzicheria(int id){
        for (int i = 0; i < listaStuzzicherie.size(); i++){
            Prodotto stuzzicheria = listaStuzzicherie.get(i);
            if (stuzzicheria.getId() == id)
                return stuzzicheria.getCosto();
        }
        return 0.0;
    }

    public static List<Prodotto> getListaPizze() {
        return listaPizze;
    }

    public static List<Prodotto> getListaPanini() {
        return listaPanini;
    }

    public static List<Prodotto> getListaBibite() {
        return listaBibite;
    }

    public static List<Prodotto> getListaStuzzicherie() {
        return listaStuzzicherie;
    }
}
