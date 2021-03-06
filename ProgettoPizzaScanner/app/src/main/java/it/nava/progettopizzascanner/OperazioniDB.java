package it.nava.progettopizzascanner;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class OperazioniDB extends AsyncTask<String, String, String> {
    private String risultato;
    private int op;

    public OperazioniDB(int op) {
        risultato = "";
        this.op = op;
    }

    @Override
    protected String doInBackground(String... arg0) {
        String link;
        switch (op) {
            case 0: // Lettura dei prodotti
                link = "http://progettopizza.altervista.org/leggiMenu.php?categoria=tutto";
                risultato = richiestaHttp(link);
                break;
            case 1: // Conferma dell'ordine
                String codice = arg0[0];
                link = "http://progettopizza.altervista.org/confermaOrdine.php?codice=" + codice;
                risultato = richiestaHttp(link);
                break;
        }
        return risultato;
    }

    @Override
    protected void onPostExecute(String result) {
        System.out.println("OperazioniDB: Comanda confermata con successo.");
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
