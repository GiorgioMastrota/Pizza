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

    static String ricevuto = "";

    // Dimensioni schermo
    public static int getLarghezzaSchermo() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getAltezzaSchermo() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static boolean controlloBtnInvisibile(AppCompatActivity activity, Button bottone){
        int nTotProd = ProdottiScelti.getGrandezzaTotale();
        if (nTotProd == 0 && bottone.getVisibility() == View.VISIBLE) {
            bottone.setVisibility(View.GONE);
            return false;
        }
        else if (nTotProd != 0 && bottone.getVisibility() == View.GONE) {
            bottone.setVisibility(View.VISIBLE);
            return true;
        }
        else return false;
    }
}
