package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ProdottiScelti {

    // In questi vettori salvo solo gli ID prodotto così che poi vengano prelevati i dettagli dai vettori già esistenti

    private List<Integer> pizzeScelte = new ArrayList<Integer>(); // cat 1
    private List<Integer> paniniScelti = new ArrayList<Integer>(); // cat 2
    private List<Integer> bibiteScelte = new ArrayList<Integer>(); // cat 3
    private List<Integer> stuzzicherieScelte = new ArrayList<Integer>(); // cat 4

    public void aggiungiProdotto(int idProdotto, int categoria) {
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

    public void rimuoviProdotto(int idProdotto, int categoria) {
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
                } while (i < pizzeScelte.size() && trovato == false);
                break;
            case 2:
                do {
                    if (paniniScelti.get(i) == idProdotto) {
                        paniniScelti.remove(i);
                        trovato = true;
                    }
                    i++;
                } while (i < paniniScelti.size() && trovato == false);
                break;
            case 3:
                do {
                    if (bibiteScelte.get(i) == idProdotto) {
                        bibiteScelte.remove(i);
                        trovato = true;
                    }
                    i++;
                } while (i < bibiteScelte.size() && trovato == false);
                break;
            case 4:
                do {
                    if (stuzzicherieScelte.get(i) == idProdotto) {
                        stuzzicherieScelte.remove(i);
                        trovato = true;
                    }
                    i++;
                } while (i < stuzzicherieScelte.size() && trovato == false);
                break;
        }
    }

    public void annullaOrdine() {
        pizzeScelte.removeAll(pizzeScelte);
        paniniScelti.removeAll(paniniScelti);
        bibiteScelte.removeAll(bibiteScelte);
        stuzzicherieScelte.removeAll(stuzzicherieScelte);
    }

    // Get

    public int getGrandezzaTotale() {
        return pizzeScelte.size() + paniniScelti.size() + bibiteScelte.size() + stuzzicherieScelte.size();
    }

    public int getNumPizze() {
        return pizzeScelte.size();
    }

    public int getNumPanini() {
        return paniniScelti.size();
    }

    public int getNumBibite() {
        return bibiteScelte.size();
    }

    public int getNumStuzzicherie() {
        return stuzzicherieScelte.size();
    }

    public List<Integer> getPizzeScelte() {
        return pizzeScelte;
    }

    public List<Integer> getPaniniScelti() {
        return paniniScelti;
    }

    public List<Integer> getBibiteScelte() {
        return bibiteScelte;
    }

    public List<Integer> getStuzzicherieScelte() {
        return stuzzicherieScelte;
    }
}
