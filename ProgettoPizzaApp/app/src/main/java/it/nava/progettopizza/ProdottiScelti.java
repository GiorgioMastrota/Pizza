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
    public void incrementaNumProd(AppCompatActivity activity, Button bottone){
        numProdotti++;
        controlloBtnInvisibile(activity, bottone);
    }

    // Decrementa il numero dei prodotti e rende invisibile il bottone Riepilogo se i prodotti sono 0
    public void decrementaNumProd(AppCompatActivity activity, Button bottone){
        numProdotti--;
        controlloBtnInvisibile(activity, bottone);
    }

    public void controlloBtnInvisibile(AppCompatActivity activity, Button bottone){
        if (numProdotti == 0 && bottone.getVisibility() == View.VISIBLE)
            bottone.setVisibility(View.GONE);
        else if (numProdotti != 0 && bottone.getVisibility() == View.GONE)
            bottone.setVisibility(View.VISIBLE);
    }

    // GET E SET

    public int getNumProdotti(){
        return numProdotti;
    }
}
