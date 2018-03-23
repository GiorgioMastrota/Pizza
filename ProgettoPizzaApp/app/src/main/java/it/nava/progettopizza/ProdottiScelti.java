package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ProdottiScelti {

    private List<Integer> prodottiScelti = new ArrayList<Integer>();

    public void aggiungiProdotto(int idProdotto){
        prodottiScelti.add(idProdotto);
    }

    public void controlloBtnInvisibile(AppCompatActivity activity, Button bottone){
        if (prodottiScelti.size() == 0 && bottone.getVisibility() == View.VISIBLE)
            bottone.setVisibility(View.GONE);
        else if (prodottiScelti.size() != 0 && bottone.getVisibility() == View.GONE)
            bottone.setVisibility(View.VISIBLE);
    }
}
