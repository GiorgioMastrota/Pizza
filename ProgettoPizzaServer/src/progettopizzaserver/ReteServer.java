package progettopizzaserver;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nava_Stefano
 */
public class ReteServer {
    private static int portaClient; // Per la porta del client    
    private static InetAddress IPClient; // Per l'ip del client
    static DatagramSocket serverSocket; // Socket Server
    
    private static byte[] bufferOUT = new byte[1024];
    private static byte[] bufferIN = new byte[1024];

    public ReteServer(){
        try {
            serverSocket = new DatagramSocket(3333);
        } catch (SocketException ex) {
            System.out.println("Errore nell'inizializzazione dei valori del server.");
            Logger.getLogger(ReteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean Invia(String messaggio) {
        if (serverSocket == null) {
            try {
                serverSocket = new DatagramSocket(3333);
            } catch (SocketException ex) {
                Logger.getLogger(ReteServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            bufferOUT = messaggio.getBytes(); // Inserisco il messaggio nel buffer
            DatagramPacket pacchettoInvio // Creo il pacchetto per la trasmissione
                    = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient); // Inserisco nel pacchetto i dati
            serverSocket.send(pacchettoInvio); // Invio il pacchetto
        } catch (IOException ex) {
            System.out.println("Errore nell'invio del pacchetto al client.");
        }
        return true;
    }
    
    public String Ricevi() {
        String ricevuto = "";
        try {
            DatagramPacket pacchettoRicezione // Creo il pacchetto per la ricezione
                    = new DatagramPacket(bufferIN, bufferIN.length);
            serverSocket.receive(pacchettoRicezione); // Ricevo il pacchetto
            ricevuto = new String(pacchettoRicezione.getData()); // Inserisco in una stringa il messaggio ricevuto
            int numCaratteri = pacchettoRicezione.getLength(); // Conto i caratteri del messaggio
            ricevuto = ricevuto.substring(0, numCaratteri); // Elimino i caratteri in eccesso

            // recupero dei parametri del socket associato al client
            IPClient = pacchettoRicezione.getAddress();
            portaClient = pacchettoRicezione.getPort();
        } catch (IOException ex) {
            System.out.println("Errore nella ricezione del pacchetto.");
        }
        return ricevuto;
    }
    
    //=========================GET E SET======================================//
    
    public static int getPortaClient() {
        return portaClient;
    }

    public static InetAddress getIPClient() {
        return IPClient;
    }
}
