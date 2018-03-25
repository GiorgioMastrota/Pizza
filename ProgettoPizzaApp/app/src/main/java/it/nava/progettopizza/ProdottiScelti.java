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

    public void aggiungiProdotto(int idProdotto, int categoria){
        switch(categoria){
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

    public void controlloBtnInvisibile(AppCompatActivity activity, Button bottone){
        int nTotProd = pizzeScelte.size() + paniniScelti.size() + bibiteScelte.size() + stuzzicherieScelte.size();
        if (nTotProd == 0 && bottone.getVisibility() == View.VISIBLE)
            bottone.setVisibility(View.GONE);
        else if (nTotProd != 0 && bottone.getVisibility() == View.GONE)
            bottone.setVisibility(View.VISIBLE);
    }
}
