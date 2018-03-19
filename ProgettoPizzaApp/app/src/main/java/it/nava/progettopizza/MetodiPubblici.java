package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MetodiPubblici {

    public static ProdottiScelti prodottiScelti = new ProdottiScelti();
    public static ReteClient rete = new ReteClient();
    public static ListeProdotti listeProdotti = new ListeProdotti();

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
}
