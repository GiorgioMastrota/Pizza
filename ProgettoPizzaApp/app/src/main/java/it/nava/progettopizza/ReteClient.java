package it.nava.progettopizza;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReteClient {
    private static int portaServer; // Per la porta del server    
    private static InetAddress IPServer; // Per l'ip del server
    static DatagramSocket clientSocket; // Socket Client
    
    private static byte[] bufferOUT = new byte[1024];
    private static byte[] bufferIN = new byte[1024];
    
    public ReteClient(){
        try {
            portaServer = 3333;
            IPServer = InetAddress.getByName("172.16.102.116");
            clientSocket = new DatagramSocket();
        } catch (SocketException | UnknownHostException ex) {
            System.out.println("Errore nell'inizializzazione dei valori del client.");                               
            Logger.getLogger(ReteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean Invia(String messaggio) {
        if (clientSocket == null) {
            try {
                clientSocket = new DatagramSocket();
            } catch (SocketException ex) {
                Logger.getLogger(ReteClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            bufferOUT = messaggio.getBytes(); // Inserisco il messaggio nel buffer
            DatagramPacket pacchettoInvio // Creo il pacchetto per la trasmissione
                    = new DatagramPacket(bufferOUT, bufferOUT.length, IPServer, portaServer); // Inserisco nel pacchetto i dati
            clientSocket.send(pacchettoInvio); // Invio il pacchetto
        } catch (IOException ex) {
            System.out.println("Errore nell'invio del pacchetto al server.");
        }
        return true;
    }

    public static String Ricevi() {
        String ricevuto = "";
        try {
            DatagramPacket pacchettoRicezione // Creo il pacchetto per la ricezione
                    = new DatagramPacket(bufferIN, bufferIN.length);
            clientSocket.receive(pacchettoRicezione); // Ricevo il pacchetto
            ricevuto = new String(pacchettoRicezione.getData()); // Inserisco in una stringa il messaggio ricevuto
            int numCaratteri = pacchettoRicezione.getLength(); // Conto i caratteri del messaggio
            ricevuto = ricevuto.substring(0, numCaratteri); // Elimino i caratteri in eccesso

        } catch (IOException ex) {
            System.out.println("Errore nella ricezione del pacchetto.");
        }
        return ricevuto;
    }
    
    //===========================GET E SET====================================//
    
    public static int getPortaServer() {
        return portaServer;
    }

}
