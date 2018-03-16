package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMR = (Button) findViewById(R.id.btnMainRiepilogo);

        if(DatiSessione.prodottiScelti.getNumProdotti() == 0)
            btnMR.setVisibility(View.GONE);
        else
            btnMR.setVisibility(View.VISIBLE);

    }
}
