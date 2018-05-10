package it.nava.progettopizza;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

// PER LA COMUNICAZIONE: https://www.tutorialspoint.com/android/android_php_mysql.htm

public class OperazioniDB extends AsyncTask<String, String, String> {
    private int operazione;
    private String risultato;

    public OperazioniDB(int op) {
        this.operazione = op;
        risultato = "";
    }

    // Operazione 0 = leggere menù
    // Operazione 1 = aggiungere ordine
    // Operazione 2 = annulla ordine

    @Override
    protected String doInBackground(String... arg0) {
        if (operazione == 0) { // Leggi menù
            String categoria = arg0[0];
            String link = "http://progettopizza.altervista.org/leggiMenu.php?categoria=" + categoria;
            risultato = richiestaHttp(link);
            return risultato;
        } else if (operazione == 1) { // Aggiungi ordine
            String codice = arg0[0];
            String asporto = arg0[1];
            String costoTot = arg0[2];
            String dataOra = arg0[3];
            String ordine = arg0[4];
            String link = "http://progettopizza.altervista.org/aggiungiOrdine.php?codice=" + codice + "&asporto=" + asporto
                    + "&costoTot=" + costoTot + "&dataOra=" + dataOra + "&ordine=" + ordine;
            risultato = richiestaHttp(link);
            return risultato;
        } else if (operazione == 2) {
            String codice = arg0[0];
            String link = "http://progettopizza.altervista.org/annullaOrdine.php?codice=" + codice;
            risultato = richiestaHttp(link);
            return risultato;
        } else return null;
    }

    @Override
    protected void onPostExecute(String result) {
        switch (operazione) {
            case 0: // lettura menù
                System.out.println("OperazioniDB: Menù letto con successo.");
                break;
            case 1: // aggiunta ordine
                System.out.println("OperazioniDB: Ordine aggiunto con successo.");
                break;
        }
    }

    private String richiestaHttp(String link) {
        String ris;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet richiesta = new HttpGet();
            richiesta.setURI(new URI(link));
            HttpResponse risposta;
            risposta = client.execute(richiesta);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(risposta.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String linea;

            while ((linea = in.readLine()) != null) {
                sb.append(linea);
                break;
            }
            in.close();
            ris = sb.toString();
        } catch (IOException | URISyntaxException e) {
            return "Eccezione: " + e.getMessage();
        }
        return ris;
    }
}
