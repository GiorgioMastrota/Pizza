package progettopizzaserver;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nava_Stefano
 */
public class ReteServer extends Thread{

    InputStream inputStream;
    OutputStream outputStream;
    OutputStreamWriter outputStreamWriter;

    ServerSocket server;
    Socket connessione;

    byte[] buffer = new byte[1024];

    InetAddress clientIP;
    int clientPorta;

    public ReteServer() {
        try {
            server = new ServerSocket(3333);
            //server.setSoTimeout(10000); // 10 secondi di timeout
            connessione = null;
            inputStream = null;
            outputStream = null;
            outputStreamWriter = null;
            clientIP = null;
            clientPorta = 0;
        } catch (IOException ex) {
            System.err.println("Errore nella creazione dell'oggetto ServerSocket.");
        }
    }

    public void attesaConnessione() {
        System.out.println("Server avviato, attesa di una connessione da parte del client...");
        try {
            connessione = server.accept(); // Attende finché il client non richiede una connessione
            clientIP = connessione.getInetAddress();
            clientPorta = connessione.getPort();
            System.out.println("Connessione stabilita con " + clientIP + ":" + clientPorta + ".");
        } catch (IOException ex) {
            System.err.println("Errore nell'attesa di una richiesta di connessione dal client.");
        }
    }

    public void Invia(String messaggio) {
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
    }

    public String Ricevi() {
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
            System.err.println("Errore nella ricezione di un messaggio dal client.");
        }
        //System.out.println("> DAL CLIENT: " + ricevuto);
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
}
