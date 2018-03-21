package it.nava.progettopizza;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MetodiPubblici {

    public static ProdottiScelti prodottiScelti = new ProdottiScelti();
    public static ReteClient rete = new ReteClient();
    public static ListeProdotti listeProdotti = new ListeProdotti();

    // Dimensioni schermo
    public static int getLarghezzaSchermo() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getAltezzaSchermo() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static void richiestaMenu(){
        /* Il metodo funziona così: il server legge i dati dal database tramite php, conteggia quanti dati ha letto;
        *  Successivamente manda al client il numero di dati letti in modo che egli possa fare un ciclo di ricezione per le stringhe del menù;
        *  il client le suddivide nei vettori (pizze, panini, bibite, stuzzicherie) in modo che nelle activity specifiche vengano mostrati
        *  i menù relativi alla categoria.
        */
        rete.Invia("richiestaMenu");
        int numStringheMenu = Integer.parseInt(rete.Ricevi());
        // Le cose ricevute dal menù devono poi essere settate nei vettori
    }

    public static void creaListaBottoni(Context contesto, LinearLayout layoutPrincipale, int quantita, List<Prodotto> lista){
        for (int i = 0; i < lista.size(); i++) {
            LinearLayout ll = new LinearLayout(contesto);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            // Nome Prodotto
            TextView nomeProdotto = new TextView(contesto);
            nomeProdotto.setText(lista.get(i).getNome());
            nomeProdotto.setLayoutParams(new LinearLayout.LayoutParams(
                    MetodiPubblici.getLarghezzaSchermo() / 5, LinearLayout.LayoutParams.WRAP_CONTENT));

            // Descrizione Prodotto
            TextView descrizione = new TextView(contesto);
            descrizione.setText(lista.get(i).getDescrizione());
            descrizione.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            // Bottone
            final Button btn = new Button(contesto);
            btn.setId(i);
            btn.setMaxLines(5);
            btn.setText("Ordina");
            btn.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //
                }
            });

            // Aggiunte ai layout
            ll.addView(nomeProdotto);
            ll.addView(descrizione);
            ll.addView(btn);
            layoutPrincipale.addView(ll);
        }
    }
}
