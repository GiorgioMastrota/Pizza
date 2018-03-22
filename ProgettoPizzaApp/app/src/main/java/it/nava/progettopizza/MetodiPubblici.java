package it.nava.progettopizza;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
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

        Prodotto prova = new Prodotto(1, "Margherita", "Pizza", "mozzarella, pomodoro, prosciutto cotto, funghi, carciofi, salame piccante, pancetta, olive", 8.40);
        listeProdotti.listaPizze.add(prova);

        for (int i = 0; i < lista.size(); i++) {

            LinearLayout ll = new LinearLayout(contesto);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams lpLL = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, MetodiPubblici.getAltezzaSchermo() / 10);
            ll.setLayoutParams(lpLL);

            // Nome Prodotto
            TextView nomeProdotto = new TextView(contesto);
            nomeProdotto.setText(lista.get(i).getNome());
            nomeProdotto.setTypeface(null, Typeface.BOLD);
            nomeProdotto.setBackgroundColor(Color.LTGRAY);
            nomeProdotto.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpNome = new LinearLayout.LayoutParams(
                    MetodiPubblici.getLarghezzaSchermo() / 4, LinearLayout.LayoutParams.MATCH_PARENT);
            lpNome.setMargins(12, 0,0,3);
            nomeProdotto.setLayoutParams(lpNome);
            ll.addView(nomeProdotto);

            // Descrizione Prodotto, se è una bibita non serve
            if (lista != listeProdotti.listaBibite) {
                TextView descrizione = new TextView(contesto);
                descrizione.setText(lista.get(i).getDescrizione());
                descrizione.setBackgroundColor(Color.LTGRAY);
                descrizione.setGravity(Gravity.CENTER);
                descrizione.setTextSize(10);
                LinearLayout.LayoutParams lpDesc = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                lpDesc.setMargins(0, 0,0,3);
                descrizione.setLayoutParams(lpDesc);
                ll.addView(descrizione);
            }

            // Prezzo prodotto
            TextView prezzoProdotto = new TextView(contesto);
            String prezzoStringa = String.format("%.2f", lista.get(i).getCosto());
            prezzoProdotto.setText(prezzoStringa + " €");
            prezzoProdotto.setBackgroundColor(Color.LTGRAY);
            prezzoProdotto.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lpPrezzo = new LinearLayout.LayoutParams(
                    MetodiPubblici.getLarghezzaSchermo() / 6, LinearLayout.LayoutParams.MATCH_PARENT);
            lpPrezzo.setMargins(0,0,0,3);
            prezzoProdotto.setLayoutParams(lpPrezzo);
            ll.addView(prezzoProdotto);

            // Bottone
            final Button btn = new Button(contesto);
            btn.setId(i);
            btn.setMaxLines(5);
            btn.setText("Ordina");
            LinearLayout.LayoutParams lpBtn = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lpBtn.setMargins(0,0,3,3);
            btn.setLayoutParams(lpBtn);
            ll.addView(btn);

            // Alla pressione del bottone
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //
                }
            });

            layoutPrincipale.addView(ll);
        }
    }
}
