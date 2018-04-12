package it.nava.progettopizza;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MetodiPubblici {

    // Dimensioni schermo
    public static int getLarghezzaSchermo() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getAltezzaSchermo() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static void InviaServer(String daInviare){
        ReteClient.Invia(daInviare);
    }

    public static String RiceviServer(){
        return ReteClient.Ricevi();
    }

    public static void richiestaMenu(){
        /* Il metodo funziona così: il server legge i dati dal database tramite php, conteggia quanti dati ha letto;
        *  Successivamente manda al client il numero di dati letti in modo che egli possa fare un ciclo di ricezione per le stringhe del menù;
        *  il client le suddivide nei vettori (pizze, panini, bibite, stuzzicherie) in modo che nelle activity specifiche vengano mostrati
        *  i menù relativi alla categoria.
        */
        InviaServer("richiestaMenu");
        int numStringheMenu = Integer.parseInt(ReteClient.Ricevi());
        // Le cose ricevute dal menù devono poi essere settate nei vettori
    }

    public static String richiestaBarcode(){
        InviaServer("richiestaBarcode");
        return RiceviServer();
    }

    public static void controlloBtnInvisibile(AppCompatActivity activity, Button bottone){
        int nTotProd = ProdottiScelti.getGrandezzaTotale();
        if (nTotProd == 0 && bottone.getVisibility() == View.VISIBLE)
            bottone.setVisibility(View.GONE);
        else if (nTotProd != 0 && bottone.getVisibility() == View.GONE)
            bottone.setVisibility(View.VISIBLE);
    }
}
