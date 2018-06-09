package it.nava.progettopizzacomande;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListeProdotti.letturaProdotti();

        final LinearLayout linearVerticale = (LinearLayout)findViewById(R.id.layVerticale);

        for (int i = 1; i <= 4; i++)
            creaCampi(this, linearVerticale);
    }

    public void creaCampi(Context contesto, LinearLayout layout) {
        String nomePrimoCampo = "";
        int dimVettore = 0, partenza = -1;

        if (dimVettore == 0)
            partenza = 0;

        String nomeProd = "", prezzo = "";

        for (int i = partenza; i < dimVettore; i++) {

            LinearLayout layOrizz = new LinearLayout(contesto);
            layOrizz.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams lpLL = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layOrizz.setLayoutParams(lpLL);

            // Testo comanda
            TextView comanda = new TextView(contesto);
            comanda.setText(nomeProd);
            if (i == -1)
                comanda.setTypeface(null, Typeface.BOLD);
            comanda.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpNome = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            lpNome.setMargins(12, 0, 0, 0);
            comanda.setLayoutParams(lpNome);
            layOrizz.addView(comanda);
        }
    }
}
