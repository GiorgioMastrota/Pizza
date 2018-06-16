package it.nava.progettopizzacomande;

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
    private int operazione;
    private String risultato;

    public OperazioniDB(int op) {
        this.operazione = op;
        risultato = "";
    }

    // Operazione 0 = leggere lista comande
    // Operazione 1 = concludere comanda

    @Override
    protected String doInBackground(String... arg0) {
        String link;
        switch(operazione){
            case 0:
                link = "http://progettopizza.altervista.org/leggiComande.php";
                risultato = richiestaHttp(link);
                break;
            case 1:
                String idComanda = arg0[0];
                link = "http://progettopizza.altervista.org/soddisfaComanda.php?codice=" + idComanda;
                risultato = richiestaHttp(link);
                break;
            case 2:
                link = "http://progettopizza.altervista.org/leggiMenu.php?categoria=tutto";
                risultato = richiestaHttp(link);
                break;
        }
        return risultato;
    }

    @Override
    protected void onPostExecute(String result) {
        switch (operazione) {
            case 0: // lettura comande
                System.out.println("OperazioniDB: Comande lette con successo.");
                break;
            case 1: // soddisfa comanda
                System.out.println("OperazioniDB: Comanda soddisfatta con successo.");
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
