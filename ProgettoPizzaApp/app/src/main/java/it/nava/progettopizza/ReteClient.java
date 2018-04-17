package it.nava.progettopizza;

import android.os.AsyncTask;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Nava_Stefano
 */
public class ReteClient extends AsyncTask<String, Void> {

    InputStream inputStream;
    OutputStream outputStream;
    OutputStreamWriter outputStreamWriter;

    Socket connessione;

    byte[] buffer = new byte[1024];

    InetSocketAddress ipServer;
    int portaServer;

    public ReteClient() {
        try {
            connessione = new Socket();
            connessione.setSoTimeout(10000);
        } catch (SocketException ex) {
            System.err.println("Errore nella creazione del Socket del client.");
        }
    }

    public void Connetti(String ip, int porta) {
        try {
            ipServer = new InetSocketAddress(ip, porta);
            connessione.connect(ipServer, 10000); // Con timeout di 10 secondi
            System.out.println("Connessione stabilita con " + ip + ":" + porta + ".");
        } catch (IOException ex) {
            System.err.println("Errore nella connessione al server.");
        }
    }

    public void Invia(String messaggio) {
        Connetti("127.0.0.1", 3333);
        try {
            outputStream = connessione.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream, "ISO-8859-1");
            outputStreamWriter.write(messaggio);
            outputStreamWriter.flush();
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (IOException ex) {
            System.err.println("Errore nell'invio del messaggio dal server.");
        } catch (InterruptedException ex) {
            System.err.println("Errore nell'invio del messaggio dal server.");
        }
        chiudiConnessione();
    }

    public String Ricevi() {
        Connetti("127.0.0.1", 3333);
        String ricevuto = "";
        String frammento = "";
        int n = 0;
        try {
            do {
                inputStream = connessione.getInputStream();
                if ((n = inputStream.read(buffer)) != -1) {
                    frammento = new String(buffer, 0, n, "ISO-8859-1");
                    ricevuto += frammento;
                }
            } while (ricevuto.equals(""));
        } catch (IOException ex) {
            System.err.println("Errore nella ricezione di un messaggio dal server.");
        }
        //System.out.println("> DAL SERVER: " + ricevuto);
        chiudiConnessione();
        return ricevuto;
    }

    public void chiudiConnessione() {
        try {
            connessione.shutdownInput();
            connessione.shutdownOutput();
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            connessione.close();
            System.out.println("Connessione chiusa.");
        } catch (IOException ex) {
            System.err.println("Errore nella chiusura della connessione.");
        }
    }

    protected Void doInBackground(String... urls) {
        try {

        } catch (Exception e) {
            this.exception = e;

            return null;
        } finally {
            is.close();
        }
        return null;
    }

    protected void onPostExecute() {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}
