package it.nava.progettopizza;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.List;

public class ConnessioneDB {

    public List<Prodotto> getMenu(){
        String url = "http://progettopizza.altervista.org/listino.php";
        HttpClient client = new DefaultHttpClient();

        try {
            client.execute(new HttpGet(url));
        } catch(IOException e) {
            System.err.println("Errore nella richiesta del menù al database.");
        }
    }
}
