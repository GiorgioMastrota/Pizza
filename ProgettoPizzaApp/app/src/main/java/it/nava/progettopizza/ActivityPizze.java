package it.nava.progettopizza;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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

        LinearLayout ll = (LinearLayout)findViewById(R.id.pizze);

        // Bottoni creati dinamicamente
        for (int i = 0; i < 10; i++) {
            Button button = new Button(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setId(i);
            button.setText("Pizza");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ActivityPizze.this, "Carla", Toast.LENGTH_SHORT).show();
                }
            });
            button.setGravity(Gravity.CENTER);
            ll.addView(button);
        }
    }
}
