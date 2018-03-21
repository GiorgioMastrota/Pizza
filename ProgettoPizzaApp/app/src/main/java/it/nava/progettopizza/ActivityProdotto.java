package it.nava.progettopizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class ActivityProdotto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodotto);

        int categoria = getIntent().getIntExtra("categoria", 0);

        // Gestione completa del bottone di riepilogo
        Button btnRiepilogo = (Button) findViewById(R.id.btnProdottoRiepilogo);
        MetodiPubblici.prodottiScelti.controlloBtnInvisibile(ActivityProdotto.this, btnRiepilogo);
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
                daPassare = MetodiPubblici.listeProdotti.getListaPizze();
                break;
            case 2: // Panini
                daPassare = MetodiPubblici.listeProdotti.getListaPanini();
                break;
            case 3: // Bibite
                daPassare = MetodiPubblici.listeProdotti.getListaBibite();
                break;
            case 4: // Stuzzicherie
                daPassare = MetodiPubblici.listeProdotti.getListaStuzzicherie();
                break;
        }
        MetodiPubblici.creaListaBottoni(this, linearInterno, 5, daPassare);
    }
}
