package it.nava.progettopizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActivityPanini extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panini);

        // Gestione completa del bottone di riepilogo
        Button btnRiepilogo = (Button)findViewById(R.id.btnPaniniRiepilogo);
        MetodiPubblici.prodottiScelti.controlloBtnInvisibile(ActivityPanini.this, btnRiepilogo);
        btnRiepilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityPanini.this, ActivityRiepilogo.class));
            }
        });

        // Creazione bottoni dinamicamente
        final LinearLayout linearInterno = (LinearLayout) findViewById(R.id.linearInterno);
        MetodiPubblici.creaListaBottoni(this, linearInterno, 5, MetodiPubblici.listeProdotti.getListaPanini());
    }
}
