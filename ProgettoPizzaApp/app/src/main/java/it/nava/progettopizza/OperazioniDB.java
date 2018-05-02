package it.nava.progettopizza;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

// PER LA COMUNICAZIONE: https://www.tutorialspoint.com/android/android_php_mysql.htm
// PER LA DECODIFICAZIONE JSON: https://stackoverflow.com/questions/16574482/decoding-json-string-in-java

public class OperazioniDB extends AsyncTask<String, String, String> {
    private int operazione = 0;
    private String categoria, risultato;

    public OperazioniDB(int op) {
        operazione = op;
        categoria = "";
    }

    // operazione 0 = leggere menù

    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... arg0) {
        if (operazione == 0) { // leggere menù
            try {
                categoria = (String) arg0[0];
                String link = "http://progettopizza.altervista.org/leggiMenu.php?categoria=" + categoria;

                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                in.close();
                risultato = sb.toString();
                return risultato;
            } catch (Exception e) {
                return new String("Eccezione: " + e.getMessage());
            }
        } else return null;
    }

    @Override
    protected void onPostExecute(String result){
        switch(operazione){
            case 0: // lettura menù
                System.out.println("OperazioniDB: Menù letto con successo.");
                break;
        }
    }

    // Metodo con il JSON non funzionante, alternativa con split normale
    /*
    @Override
    protected void onPostExecute(String result) {
        //String jsonString = "{\"prodotti\": { \"id\": \"\", \"prodotto\": \"\", \"costo\": \"\", \"descrizione\": \"\"}}";
        String jsonString = risultato;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
            JSONObject newJSON = jsonObject.getJSONObject("prodotti");
            System.out.println(newJSON.toString());
            jsonObject = new JSONObject(newJSON.toString());
            System.out.println(jsonObject.getString("id"));
            System.out.println(jsonObject.getString("prodotto"));
            System.out.println(jsonObject.getString("costo"));
            System.out.println(jsonObject.getString("descrizione"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (categoria.equals("Pizze")) {

        }
    } */
}
