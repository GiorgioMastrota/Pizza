package it.nava.progettopizzascanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScontrinoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scontrino);

        String stringaOrdine = getIntent().getStringExtra("stringaOrdine");
    }
}
