package it.nava.progettopizzacomande;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListaProdotti {

    private static List<Prodotto> listaProdotti = new ArrayList<>();

    public ListaProdotti() {
        letturaProdotti();
    }

    public static void letturaProdotti() {
        OperazioniDB menu = new OperazioniDB(2);
        try {
            String prodottiLetti = menu.execute().get();
            inizializzaMenu(prodottiLetti);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("ListaProdotti: errore nell'esecuzione dei thread per la comunicazione col db.");
        }
    }

    private static void inizializzaMenu(String stringa) {
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
            Prodotto daInserire = new Prodotto(id, nome, descrizione, costo);
            aggiungiProdotto(daInserire);
        }
    }

    // Aggiunte prodotti

    public static void aggiungiProdotto(Prodotto prodotto) {
        listaProdotti.add(prodotto);
    }

    // Get

    public static String getNomeProdotto(int id) {
        for (int i = 0; i < listaProdotti.size(); i++) {
            Prodotto prodotto = listaProdotti.get(i);
            if (prodotto.getId() == id)
                return prodotto.getNome();
        }
        return null;
    }

    @SuppressLint("DefaultLocale")
    public static double getPrezzoProdotto(int id) {
        for (int i = 0; i < listaProdotti.size(); i++) {
            Prodotto prodotto = listaProdotti.get(i);
            if (prodotto.getId() == id)
                return prodotto.getCosto();
        }
        return 0.0;
    }
}
