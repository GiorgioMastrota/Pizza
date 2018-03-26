package it.nava.progettopizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ActivityQuantita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantita);

        final int idProdotto = getIntent().getIntExtra("idBottone", -1);
        final int idCategoria = getIntent().getIntExtra("idCategoria", -1);

        getWindow().setLayout((int)(MetodiPubblici.getLarghezzaSchermo() * 0.7), LinearLayout.LayoutParams.WRAP_CONTENT);

        final EditText editQuant = (EditText)findViewById(R.id.editQuantita);
        LinearLayout.LayoutParams eqL = new LinearLayout.LayoutParams(
                MetodiPubblici.getLarghezzaSchermo() / 5, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button btnConferma = (Button)findViewById(R.id.btnConferma);
        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText quantita = (EditText)findViewById(R.id.editQuantita);
                int quantitaScelta = Integer.parseInt(quantita.getText().toString());
                for (int i = 0; i < quantitaScelta; i++) {
                    MetodiPubblici.prodottiScelti.aggiungiProdotto(idProdotto, idCategoria);
                }
                    Toast toast = Toast.makeText(getApplicationContext(), "Prodotto aggiunto.", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
