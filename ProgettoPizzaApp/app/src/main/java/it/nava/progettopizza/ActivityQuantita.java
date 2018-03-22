package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ActivityQuantita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantita);
        setTitle("Quantità:");

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int larghezza = dm.widthPixels;
        int altezza = dm.heightPixels;

        getWindow().setLayout((int)(larghezza * 0.7), (int)(altezza / 3));

        EditText editQuant = (EditText)findViewById(R.id.editQuantita);
        LinearLayout.LayoutParams eqL = new LinearLayout.LayoutParams(
                MetodiPubblici.getLarghezzaSchermo() / 5, LinearLayout.LayoutParams.WRAP_CONTENT);
        // Da aggiustare
    }
}
