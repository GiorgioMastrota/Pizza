package it.nava.progettopizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityStuzzicherie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuzzicherie);

        // Gestione completa del bottone di riepilogo
        Button btnRiepilogo = (Button)findViewById(R.id.btnStuzzicherieRiepilogo);
        MetodiPubblici.prodottiScelti.controlloBtnInvisibile(ActivityStuzzicherie.this, btnRiepilogo);
        btnRiepilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityStuzzicherie.this, ActivityRiepilogo.class));
            }
        });
    }
}
