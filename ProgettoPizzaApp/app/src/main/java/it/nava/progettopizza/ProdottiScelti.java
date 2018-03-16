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
        controlloBtnInvisibile(activity);
    }

    // Decrementa il numero dei prodotti e rende invisibile il bottone Riepilogo se i prodotti sono 0
    public void decrementaNumProd(AppCompatActivity activity){
        numProdotti--;
        controlloBtnInvisibile(activity);
    }

    public void controlloBtnInvisibile(AppCompatActivity activity){
        Button btnMR = (Button) activity.findViewById(R.id.btnMainRiepilogo);
        if (numProdotti == 0)
            btnMR.setVisibility(View.GONE);
        else
            btnMR.setVisibility(View.VISIBLE);
    }

    // GET E SET

    public int getNumProdotti(){
        return numProdotti;
    }
}
