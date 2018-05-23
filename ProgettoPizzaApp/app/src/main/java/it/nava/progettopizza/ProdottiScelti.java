package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ProdottiScelti {

    // In questi vettori salvo solo gli ID prodotto così che poi vengano prelevati i dettagli dai vettori già esistenti

    private static List<Integer> pizzeScelte = new ArrayList<>(); // cat 1
    private static List<Integer> paniniScelti = new ArrayList<>(); // cat 2
    private static List<Integer> bibiteScelte = new ArrayList<>(); // cat 3
    private static List<Integer> stuzzicherieScelte = new ArrayList<>(); // cat 4

    private static boolean asporto;

    private static int costoTot;

    public ProdottiScelti(){
        asporto = false;
    }

    public static void aggiungiProdotto(int idProdotto, int categoria) {
        switch (categoria) {
            case 1:
                pizzeScelte.add(idProdotto);
                break;
            case 2:
                paniniScelti.add(idProdotto);
                break;
            case 3:
                bibiteScelte.add(idProdotto);
                break;
            case 4:
                stuzzicherieScelte.add(idProdotto);
                break;
        }
    }

    public static void rimuoviProdotto(int idProdotto, int categoria) {
        boolean trovato = false;
        int i = 0;
        switch (categoria) {
            case 1:
                do {
                    if (pizzeScelte.get(i) == idProdotto) {
                        pizzeScelte.remove(i);
                        trovato = true;
                    }
                    i++;
                } while (i < pizzeScelte.size() && !trovato);
                break;
            case 2:
                do {
                    if (paniniScelti.get(i) == idProdotto) {
                        paniniScelti.remove(i);
                        trovato = true;
                    }
                    i++;
                } while (i < paniniScelti.size() && !trovato);
                break;
            case 3:
                do {
                    if (bibiteScelte.get(i) == idProdotto) {
                        bibiteScelte.remove(i);
                        trovato = true;
                    }
                    i++;
                } while (i < bibiteScelte.size() && !trovato);
                break;
            case 4:
                do {
                    if (stuzzicherieScelte.get(i) == idProdotto) {
                        stuzzicherieScelte.remove(i);
                        trovato = true;
                    }
                    i++;
                } while (i < stuzzicherieScelte.size() && !trovato);
                break;
        }
    }

    public static void annullaOrdine() {
        pizzeScelte.removeAll(pizzeScelte);
        paniniScelti.removeAll(paniniScelti);
        bibiteScelte.removeAll(bibiteScelte);
        stuzzicherieScelte.removeAll(stuzzicherieScelte);
    }

    public static void calcolaCostoTot(){
        costoTot = 0;
        for (int i = 0; i < pizzeScelte.size(); i++){
            Double prezzo = ListeProdotti.getPrezzoPizza(pizzeScelte.get(i));
            int prezzoInt = (int)(prezzo * 100);
            costoTot += prezzoInt;
        }
        for (int i = 0; i < paniniScelti.size(); i++){
            Double prezzo = ListeProdotti.getPrezzoPanino(paniniScelti.get(i));
            int prezzoInt = (int)(prezzo * 100);
            costoTot += prezzoInt;
        }
        for (int i = 0; i < bibiteScelte.size(); i++){
            Double prezzo = ListeProdotti.getPrezzoBibita(bibiteScelte.get(i));
            int prezzoInt = (int)(prezzo * 100);
            costoTot += prezzoInt;
        }
        for (int i = 0; i < stuzzicherieScelte.size(); i++){
            Double prezzo = ListeProdotti.getPrezzoStuzzicheria(stuzzicherieScelte.get(i));
            int prezzoInt = (int)(prezzo * 100);
            costoTot += prezzoInt;
        }
    }

    // Get

    public static int getCostoTot() {
        return costoTot;
    }

    public static int getGrandezzaTotale() {
        return pizzeScelte.size() + paniniScelti.size() + bibiteScelte.size() + stuzzicherieScelte.size();
    }

    public static int getNumPizze() {
        return pizzeScelte.size();
    }

    public static int getNumPanini() {
        return paniniScelti.size();
    }

    public static int getNumBibite() {
        return bibiteScelte.size();
    }

    public static int getNumStuzzicherie() {
        return stuzzicherieScelte.size();
    }

    public static List<Integer> getPizzeScelte() {
        return pizzeScelte;
    }

    public static List<Integer> getPaniniScelti() {
        return paniniScelti;
    }

    public static List<Integer> getBibiteScelte() {
        return bibiteScelte;
    }

    public static List<Integer> getStuzzicherieScelte() {
        return stuzzicherieScelte;
    }

    public static int getPizza(int pos){
        return pizzeScelte.get(pos);
    }

    public static int getPanino(int pos){
        return paniniScelti.get(pos);
    }

    public static int getBibita(int pos){
        return bibiteScelte.get(pos);
    }

    public static int getStuzzicheria(int pos){
        return stuzzicherieScelte.get(pos);
    }

    public static void setAsporto(boolean val){
        asporto = val;
    }

    public static boolean isAsporto(){
        return asporto;
    }
}
