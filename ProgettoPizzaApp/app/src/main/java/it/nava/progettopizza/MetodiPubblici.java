package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MetodiPubblici {

    public static ProdottiScelti prodottiScelti = new ProdottiScelti();

    public static void riepilogoVisibile(AppCompatActivity activity){
        Button btnMR = (Button) activity.findViewById(R.id.btnMainRiepilogo);
        btnMR.setVisibility(View.VISIBLE);
    }

    public static void riepilogoInvisibile(AppCompatActivity activity){
        Button btnMR = (Button) activity.findViewById(R.id.btnMainRiepilogo);
        btnMR.setVisibility(View.GONE);
    }
}
