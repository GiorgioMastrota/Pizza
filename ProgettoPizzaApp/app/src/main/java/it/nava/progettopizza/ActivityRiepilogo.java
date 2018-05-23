package it.nava.progettopizza;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class ActivityRiepilogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riepilogo);
        setTitle("Riepilogo");

        final LinearLayout linearVerticale = (LinearLayout) findViewById(R.id.linearVerticale);
        final double larghPB = MetodiPubblici.getLarghezzaSchermo() / 5;

        ProdottiScelti.calcolaCostoTot();
        double prezzoDec = (double) (ProdottiScelti.getCostoTot()) / 100;

        for (int i = 1; i <= 4; i++)
            creaCampi(this, i, linearVerticale, larghPB);

        // Prezzo totale
        TextView prezzoTot = new TextView(this);
        prezzoTot.setText("Totale: " + String.format("%.2f", prezzoDec) + "€");
        prezzoTot.setTypeface(null, Typeface.BOLD);
        prezzoTot.setGravity(Gravity.RIGHT);
        linearVerticale.addView(prezzoTot);

        // Checkbox asporto
        final CheckBox ch = new CheckBox(this);
        ch.setText("D'asporto");
        linearVerticale.addView(ch);

        // Spazio vuoto per evitare sovrapposizione bottone Conferma
        TextView textVuoto = new TextView(this);
        LinearLayout.LayoutParams lpVuoto = new LinearLayout.LayoutParams(
                MetodiPubblici.getAltezzaSchermo() / 11, LinearLayout.LayoutParams.MATCH_PARENT, 1);
        textVuoto.setLayoutParams(lpVuoto);
        textVuoto.setText(" ");
        textVuoto.setTextSize(34);
        linearVerticale.addView(textVuoto);

        // Bottone per la generazione del barcode
        Button btnGenera = (Button) findViewById(R.id.btnGenera);
        btnGenera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ch.isChecked())
                    ProdottiScelti.setAsporto(true);
                startActivity(new Intent(ActivityRiepilogo.this, ActivityBarcode.class));
            }
        });
    }

    public void creaCampi(Context contesto, final int categoria, LinearLayout layout, double larghPB) {
        String nomePrimoCampo = "";
        int dimVettore = 0, partenza = -1;
        switch (categoria) {
            case 1:
                nomePrimoCampo = "Pizze";
                dimVettore = ProdottiScelti.getNumPizze();
                break;
            case 2:
                nomePrimoCampo = "Panini";
                dimVettore = ProdottiScelti.getNumPanini();
                break;
            case 3:
                nomePrimoCampo = "Bibite";
                dimVettore = ProdottiScelti.getNumBibite();
                break;
            case 4:
                nomePrimoCampo = "Stuzzicherie";
                dimVettore = ProdottiScelti.getNumStuzzicherie();
                break;
        }

        if (dimVettore == 0)
            partenza = 0;

        String nomeProd = "", prezzo = "";

        for (int i = partenza; i < dimVettore; i++) {
            int idProd = 0;
            if (i == -1) {
                nomeProd = nomePrimoCampo;
                prezzo = "";
            } else {
                switch (categoria) {
                    case 1:
                        idProd = ProdottiScelti.getPizzeScelte().get(i);
                        nomeProd = ListeProdotti.getNomePizza(idProd);
                        prezzo = Double.toString(ListeProdotti.getPrezzoPizza(idProd));
                        break;
                    case 2:
                        idProd = ProdottiScelti.getPaniniScelti().get(i);
                        nomeProd = ListeProdotti.getNomePanino(idProd);
                        prezzo = Double.toString(ListeProdotti.getPrezzoPanino(idProd));
                        break;
                    case 3:
                        idProd = ProdottiScelti.getBibiteScelte().get(i);
                        nomeProd = ListeProdotti.getNomeBibita(idProd);
                        prezzo = Double.toString(ListeProdotti.getPrezzoBibita(idProd));
                        break;
                    case 4:
                        idProd = ProdottiScelti.getStuzzicherieScelte().get(i);
                        nomeProd = ListeProdotti.getNomeStuzzicheria(idProd);
                        prezzo = Double.toString(ListeProdotti.getPrezzoStuzzicheria(idProd));
                        break;
                }
            }

            final int idProdCost = idProd;

            LinearLayout ll = new LinearLayout(contesto);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams lpLL = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            ll.setLayoutParams(lpLL);

            // Nome
            TextView nomeProdotto = new TextView(contesto);
            nomeProdotto.setText(nomeProd);
            if (i == -1)
                nomeProdotto.setTypeface(null, Typeface.BOLD);
            nomeProdotto.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpNome = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            lpNome.setMargins(12, 0, 0, 0);
            nomeProdotto.setLayoutParams(lpNome);
            ll.addView(nomeProdotto);

            if (i != -1) {
                // Prezzo
                TextView prezzoProdotto = new TextView(contesto);
                prezzoProdotto.setText(String.format("%.2f", Double.parseDouble(prezzo)) + "€");
                if (i == -1)
                    prezzoProdotto.setTypeface(null, Typeface.BOLD);
                LinearLayout.LayoutParams lpPrezzo = new LinearLayout.LayoutParams(
                        (int) larghPB, LinearLayout.LayoutParams.MATCH_PARENT);
                prezzoProdotto.setGravity(Gravity.CENTER);
                lpNome.setMargins(0, 0, 0, 0);
                nomeProdotto.setLayoutParams(lpPrezzo);
                ll.addView(prezzoProdotto);

                // Bottone di rimozione
                final Button btn = new Button(contesto);
                btn.setId(idProd);
                btn.setText("X");
                LinearLayout.LayoutParams lpBtn = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lpBtn.setMargins(0, 0, 0, 0);
                btn.setLayoutParams(lpBtn);
                ll.addView(btn);

                // Alla pressione del bottone
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                        startActivity(getIntent());
                        ProdottiScelti.rimuoviProdotto(idProdCost, categoria);
                    }
                });
            }
            layout.addView(ll);
        }
    }
}
