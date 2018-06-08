package it.nava.progettopizzascanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScontrinoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scontrino);

        final TextView textData = (TextView)findViewById(R.id.textData);
        final TextView textCodice = (TextView)findViewById(R.id.textCodice);
        final TextView textAsporto = (TextView)findViewById(R.id.textAsporto);
        final TextView textProdotti = (TextView)findViewById(R.id.textProdotti);
        final TextView textCosto = (TextView)findViewById(R.id.textCosto);
        final TextView textPrezzo = (TextView)findViewById(R.id.textPrezzo);

        String stringaOrdine = getIntent().getStringExtra("stringaOrdine");

        String[] parti = stringaOrdine.split(";");
        textData.setText(parti[3]); // La data
        textCodice.setText("Codice ordine: " + parti[0]);

        String daAsporto = "";
        if(parti[1].equals("1"))
            daAsporto = "Sì";
        else
            daAsporto = "No";
        textAsporto.setText("Da asporto: " + daAsporto);

        String prodotti = "Prodotti Ordinati: \n";
        String prezzi = "Prezzo: \n";
        String[] prodottiOrdinati = parti[4].split(",");
        for (int i = 0; i < prodottiOrdinati.length; i++) {
            String prodotto = ListaProdotti.getNomeProdotto(Integer.parseInt(prodottiOrdinati[i]));
            prodotti += "- " + prodotto + "\n";
            Double prezzo = ListaProdotti.getPrezzoProdotto(Integer.parseInt(prodottiOrdinati[i]));
            prezzi += String.format("%.2f", prezzo) + "€\n";
        }
        textProdotti.setText(prodotti);
        textPrezzo.setText(prezzi);
        textCosto.setText("Totale: " + String.format("%.2f", (Double.parseDouble(parti[2]) / 100)) + "€");
    }
}
