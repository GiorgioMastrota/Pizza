package it.nava.progettopizza;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityPizze extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizze);

        // Gestione completa del bottone di riepilogo
        Button btnRiepilogo = (Button) findViewById(R.id.btnPizzeRiepilogo);
        MetodiPubblici.prodottiScelti.controlloBtnInvisibile(ActivityPizze.this, btnRiepilogo);
        btnRiepilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityPizze.this, ActivityRiepilogo.class));
            }
        });

        // Creazione bottoni dinamicamente
        final LinearLayout linearInterno = (LinearLayout) findViewById(R.id.linearInterno);
        MetodiPubblici.creaListaBottoni(this, linearInterno, 5, MetodiPubblici.listeProdotti.getListaPizze());
    }
}
