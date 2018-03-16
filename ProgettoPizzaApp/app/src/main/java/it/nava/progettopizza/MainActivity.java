package it.nava.progettopizza;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MetodiPubblici.riepilogoInvisibile(MainActivity.this);

        // Passaggio PizzeActivity
        ImageButton btn = (ImageButton)findViewById(R.id.imgBtnPizze);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PizzeActivity.class));
            }
        });
    }
}
