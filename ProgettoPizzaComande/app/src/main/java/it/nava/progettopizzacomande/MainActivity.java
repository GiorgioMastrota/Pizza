package it.nava.progettopizzacomande;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListaComande listaComande;

    Handler handler = new Handler();
    Runnable ricarica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ricarica = new Runnable() {
            @Override
            public void run() {
                final LinearLayout linearVerticale = (LinearLayout)findViewById(R.id.layVerticale);
                linearVerticale.removeAllViews();

                ListaProdotti.letturaProdotti();
                listaComande = new ListaComande();

                creaCampi(getApplicationContext(), linearVerticale);
                handler.postDelayed(ricarica, 5000);
            }
        };
        handler.post(ricarica);
    }

    public void creaCampi(Context contesto, LinearLayout layout) {
        String nomePrimoCampo = "";
        int dimVettore = listaComande.getNumComande();

        String nomeProd = "", prezzo = "";

        if (dimVettore == 0){
            LinearLayout layOrizz = new LinearLayout(contesto);
            layOrizz.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams lpLL = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layOrizz.setLayoutParams(lpLL);

            // Testo nessuna comanda
            TextView spazio = new TextView(contesto);
            spazio.setText("Nessuna comanda da visualizzare.");
            spazio.setTextColor(Color.BLACK);
            spazio.setTypeface(null, Typeface.BOLD);
            spazio.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpNome = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            lpNome.setMargins(12, 0, 0, 0);
            spazio.setLayoutParams(lpNome);
            layOrizz.addView(spazio);

            layout.addView(layOrizz);
        }

        for (int i = 0; i < dimVettore; i++) {

            LinearLayout layOrizz = new LinearLayout(contesto);
            layOrizz.setOrientation(LinearLayout.HORIZONTAL);
            layOrizz.setGravity(Gravity.CENTER_VERTICAL);
            layOrizz.setBackgroundColor(Color.CYAN);
            LinearLayout.LayoutParams lpLL = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layOrizz.setLayoutParams(lpLL);

            Comanda daScrivere = listaComande.getComanda(i);
            String codiceComanda = Integer.toString(daScrivere.getCodice());
            String asporto;
            if (daScrivere.isAsporto())
                asporto = "Sì";
            else
                asporto = "No";
            String prodotti = daScrivere.getStrOrdine();

            String strTesto = "- CODICE: " + codiceComanda
                    + "\n- ASPORTO: " + asporto
                    + "\n- PRODOTTI: " + prodotti;

            // Testo comanda
            TextView comanda = new TextView(contesto);
            comanda.setText(strTesto);
            comanda.setTypeface(null, Typeface.BOLD);
            comanda.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams lpComanda = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            lpComanda.setMargins(12, 12, 0, 12);
            comanda.setLayoutParams(lpComanda);
            layOrizz.addView(comanda);

            // Bottone di completamento
            final Button btn = new Button(contesto);
            btn.setId(i);
            btn.setText("✓");
            btn.setTextColor(Color.BLACK);
            btn.setTypeface(null, Typeface.BOLD);
            btn.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpBtn = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lpBtn.setMargins(0, 0, 0, 0);
            btn.setLayoutParams(lpBtn);
            layOrizz.addView(btn);

            final int idComanda = i;

            // Alla pressione del bottone
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    listaComande.soddisfaComanda(idComanda);
                    finish();
                    startActivity(getIntent());
                }
            });
            layout.addView(layOrizz);

            // Testo vuoto
            TextView vuoto = new TextView(contesto);
            vuoto.setText("");
            LinearLayout.LayoutParams lpVuoto = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 12, 1);
            vuoto.setLayoutParams(lpVuoto);
            layout.addView(vuoto);
        }
    }
}
