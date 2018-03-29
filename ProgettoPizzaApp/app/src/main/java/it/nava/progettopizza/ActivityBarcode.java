package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityBarcode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        // Richiede codice numerico al server che glielo invia e costruisce immagine codice a barre su quel codice

        // Lo fa il server per avere maggior controllo su quelli già esistenti

    }
}
