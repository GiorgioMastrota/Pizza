package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ProdottiScelti {

    private int numProdotti;

    public ProdottiScelti(){
        numProdotti = 0;
    }

    // Incrementa del numero dei prodotti e rende visibile il bottone Riepilogo se i prodotti erano 0
    public void incrementaNumProd(AppCompatActivity activity){
        numProdotti++;
        if (numProdotti == 1)
            MetodiPubblici.riepilogoVisibile(activity);
    }

    // Decrementa il numero dei prodotti e rende invisibile il bottone Riepilogo se i prodotti sono 0
    public void decrementaNumProd(AppCompatActivity activity){
        numProdotti--;
        if (numProdotti == 0)
            MetodiPubblici.riepilogoInvisibile(activity);
    }

    // GET E SET

    public int getNumProdotti(){
        return numProdotti;
    }
}
