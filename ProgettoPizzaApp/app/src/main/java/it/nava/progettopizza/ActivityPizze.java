package it.nava.progettopizza;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPizze extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizze);

        // Gestione completa del bottone di riepilogo
        Button btnRiepilogo = (Button)findViewById(R.id.btnPizzeRiepilogo);
        MetodiPubblici.prodottiScelti.controlloBtnInvisibile(ActivityPizze.this, btnRiepilogo);
        btnRiepilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityPizze.this, ActivityRiepilogo.class));
            }
        });
    }
}
