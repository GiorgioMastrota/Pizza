package it.nava.progettopizza;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ActivityProdotto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodotto);

        int categoria = getIntent().getIntExtra("categoria", 0);

        Button btnRiepilogo = (Button) findViewById(R.id.btnProdottoRiepilogo);
        btnRiepilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityProdotto.this, ActivityRiepilogo.class));
            }
        });

        // Creazione bottoni dinamicamente
        final LinearLayout linearInterno = (LinearLayout) findViewById(R.id.linearInterno);
        List<Prodotto> daPassare = null;
        switch(categoria){
            case 1: // Pizze
                daPassare = ListeProdotti.getListaPizze();
                setTitle("Pizze");
                break;
            case 2: // Panini
                daPassare = ListeProdotti.getListaPanini();
                setTitle("Panini");
                break;
            case 3: // Bibite
                daPassare = ListeProdotti.getListaBibite();
                setTitle("Bibite");
                break;
            case 4: // Stuzzicherie
                daPassare = ListeProdotti.getListaStuzzicherie();
                setTitle("Stuzzicherie");
                break;
        }
        creaListaBottoni(this, linearInterno, 5, daPassare);
    }

    protected void onResume()
    {
        super.onResume();
        Button btnRiepilogo = (Button) findViewById(R.id.btnProdottoRiepilogo);
        MetodiPubblici.controlloBtnInvisibile(ActivityProdotto.this, btnRiepilogo);
    }

    public void creaListaBottoni(Context contesto, LinearLayout layoutPrincipale, int quantita, final List<Prodotto> lista){
        for (int i = 0; i < lista.size(); i++) {

            LinearLayout ll = new LinearLayout(contesto);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams lpLL = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, MetodiPubblici.getAltezzaSchermo() / 10);
            ll.setLayoutParams(lpLL);

            // Nome Prodotto
            TextView nomeProdotto = new TextView(contesto);
            nomeProdotto.setText(lista.get(i).getNome());
            nomeProdotto.setTypeface(null, Typeface.BOLD);
            nomeProdotto.setBackgroundColor(Color.LTGRAY);
            nomeProdotto.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpNome;
            if (lista != ListeProdotti.getListaBibite()) {
                lpNome = new LinearLayout.LayoutParams(
                        MetodiPubblici.getLarghezzaSchermo() / 4, LinearLayout.LayoutParams.MATCH_PARENT);
            }
            else{
                lpNome = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            }
            lpNome.setMargins(12, 0,0,3);
            nomeProdotto.setLayoutParams(lpNome);
            ll.addView(nomeProdotto);

            // Descrizione Prodotto, se è una bibita non serve
            if (lista != ListeProdotti.getListaBibite()) {
                TextView descrizione = new TextView(contesto);
                descrizione.setText(lista.get(i).getDescrizione());
                descrizione.setBackgroundColor(Color.LTGRAY);
                descrizione.setGravity(Gravity.CENTER);
                descrizione.setTextSize(10);
                LinearLayout.LayoutParams lpDesc = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                lpDesc.setMargins(0, 0,0,3);
                descrizione.setLayoutParams(lpDesc);
                ll.addView(descrizione);
            }

            // Prezzo prodotto
            TextView prezzoProdotto = new TextView(contesto);
            String prezzoStringa = String.format("%.2f", lista.get(i).getCosto());
            prezzoProdotto.setText(prezzoStringa + " €");
            prezzoProdotto.setBackgroundColor(Color.LTGRAY);
            prezzoProdotto.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpPrezzo = new LinearLayout.LayoutParams(
                    MetodiPubblici.getLarghezzaSchermo() / 6, LinearLayout.LayoutParams.MATCH_PARENT);
            lpPrezzo.setMargins(0,0,0,3);
            prezzoProdotto.setLayoutParams(lpPrezzo);
            ll.addView(prezzoProdotto);

            // Bottone
            final Button btn = new Button(contesto);
            btn.setId(lista.get(i).getId());
            btn.setText("Ordina");
            LinearLayout.LayoutParams lpBtn = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lpBtn.setMargins(0,0,3,3);
            btn.setLayoutParams(lpBtn);
            ll.addView(btn);

            // Alla pressione del bottone
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intentProdotto = new Intent(ActivityProdotto.this, ActivityQuantita.class);
                    if (lista == ListeProdotti.getListaPizze())
                        intentProdotto.putExtra("idCategoria", 1);
                    else if (lista == ListeProdotti.getListaPanini())
                        intentProdotto.putExtra("idCategoria", 2);
                    else if (lista == ListeProdotti.getListaBibite())
                        intentProdotto.putExtra("idCategoria", 3);
                    else if (lista == ListeProdotti.getListaStuzzicherie())
                        intentProdotto.putExtra("idCategoria", 4);
                    intentProdotto.putExtra("idBottone", btn.getId());
                    startActivity(intentProdotto);
                }
            });

            layoutPrincipale.addView(ll);
        }
        // Spazio vuoto per evitare sovrapposizione bottone Riepilogo
        TextView textVuoto = new TextView(contesto);
        LinearLayout.LayoutParams lpVuoto = new LinearLayout.LayoutParams(
                MetodiPubblici.getAltezzaSchermo() / 11, LinearLayout.LayoutParams.MATCH_PARENT, 1);
        textVuoto.setLayoutParams(lpVuoto);
        textVuoto.setText(" ");
        textVuoto.setTextSize(34);
        layoutPrincipale.addView(textVuoto);
    }
}
