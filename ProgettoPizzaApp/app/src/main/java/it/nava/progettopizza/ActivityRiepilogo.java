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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ActivityRiepilogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riepilogo);
        setTitle("Riepilogo");

        final LinearLayout linearVerticale = (LinearLayout) findViewById(R.id.linearVerticale);
        final double larghPB = MetodiPubblici.getLarghezzaSchermo() / 5;

        for (int i = 1; i <= 4; i++)
            creaCampi(this, i, linearVerticale, larghPB);

        // Bottone per la generazione del barcode
        Button btnGenera = (Button)findViewById(R.id.btnGenera);
        btnGenera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ActivityRiepilogo.this, ActivityBarcode.class));
            }
        });
    }

    public void creaCampi(Context contesto, final int categoria, LinearLayout layout, double larghPB){
        String nomePrimoCampo = "";
        int dimVettore = 0, partenza = -1;
        switch(categoria){
            case 1:
                nomePrimoCampo = "Pizze";
                dimVettore = MetodiPubblici.prodottiScelti.getNumPizze();
                break;
            case 2:
                nomePrimoCampo = "Panini";
                dimVettore = MetodiPubblici.prodottiScelti.getNumPanini();
                break;
            case 3:
                nomePrimoCampo = "Bibite";
                dimVettore = MetodiPubblici.prodottiScelti.getNumBibite();
                break;
            case 4:
                nomePrimoCampo = "Stuzzicherie";
                dimVettore = MetodiPubblici.prodottiScelti.getNumStuzzicherie();
                break;
        }

        if (dimVettore == 0)
            partenza = 0;

        String nomeProd = "", prezzo = "";

        for (int i = partenza; i < dimVettore; i++){
            int idProd = 0;
            if (i == -1){
                nomeProd = nomePrimoCampo;
                prezzo = "";
            }
            else{
                switch(categoria) {
                    case 1:
                        idProd = MetodiPubblici.prodottiScelti.getPizzeScelte().get(i);
                        nomeProd = MetodiPubblici.listeProdotti.getNomePizza(idProd);
                        prezzo = MetodiPubblici.listeProdotti.getPrezzoPizza(idProd) + "€";
                        break;
                    case 2:
                        idProd = MetodiPubblici.prodottiScelti.getPaniniScelti().get(i);
                        nomeProd = MetodiPubblici.listeProdotti.getNomePanino(idProd);
                        prezzo = MetodiPubblici.listeProdotti.getPrezzoPanino(idProd) + "€";
                        break;
                    case 3:
                        idProd = MetodiPubblici.prodottiScelti.getBibiteScelte().get(i);
                        nomeProd = MetodiPubblici.listeProdotti.getNomeBibita(idProd);
                        prezzo = MetodiPubblici.listeProdotti.getPrezzoBibita(idProd) + "€";
                        break;
                    case 4:
                        idProd = MetodiPubblici.prodottiScelti.getStuzzicherieScelte().get(i);
                        nomeProd = MetodiPubblici.listeProdotti.getNomeStuzzicheria(idProd);
                        prezzo = MetodiPubblici.listeProdotti.getPrezzoStuzzicheria(idProd) + "€";
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

            // Prezzo
            TextView prezzoProdotto = new TextView(contesto);
            prezzoProdotto.setText(prezzo);
            if (i == -1)
                prezzoProdotto.setTypeface(null, Typeface.BOLD);
                    LinearLayout.LayoutParams lpPrezzo = new LinearLayout.LayoutParams(
                            (int)larghPB, LinearLayout.LayoutParams.MATCH_PARENT);
            prezzoProdotto.setGravity(Gravity.CENTER);
            lpNome.setMargins(0, 0, 0, 0);
            nomeProdotto.setLayoutParams(lpPrezzo);
            ll.addView(prezzoProdotto);

            if (i != -1) {
                // Bottone di rimozione
                final Button btn = new Button(contesto);
                btn.setId(idProd);
                btn.setText("X");
                LinearLayout.LayoutParams lpBtn = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lpBtn.setMargins(0, 0, 3, 0);
                btn.setLayoutParams(lpBtn);
                ll.addView(btn);

                // Alla pressione del bottone
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                        startActivity(getIntent());
                        MetodiPubblici.prodottiScelti.rimuoviProdotto(idProdCost, categoria);
                    }
                });
            }
            layout.addView(ll);
        }
    }
}
