package it.nava.progettopizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gestione completa del bottone di riepilogo
        MetodiPubblici.prodottiScelti.controlloBtnInvisibile(ActivityMain.this);
        Button btnRiepilogo = (Button)findViewById(R.id.btnMainRiepilogo);
        btnRiepilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityRiepilogo.class));
            }
        });

        // Passaggio ActivityPizze
        ImageButton btnPizze = (ImageButton)findViewById(R.id.imgBtnPizze);
        btnPizze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityPizze.class));
            }
        });

        // Passaggio ActivityPanini
        ImageButton btnPanini = (ImageButton)findViewById(R.id.imgBtnPanini);
        btnPanini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityPanini.class));
            }
        });

        // Passaggio ActivityStuzzicherie
        ImageButton btnStuzzicherie = (ImageButton)findViewById(R.id.imgBtnStuzzicherie);
        btnStuzzicherie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityStuzzicherie.class));
            }
        });

        // Passaggio ActivityBibite
        ImageButton btnBibite = (ImageButton)findViewById(R.id.imgBtnBibite);
        btnBibite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityBibite.class));
            }
        });
    }
}
