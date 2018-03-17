package progettopizzaserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nava_Stefano
 */
public class Utilità {

    /* METODI UTILI VECTOR:
        int Vettore.size(); // Quantità di dati contenuti
        void Vettore.add(posizione, stringa) // Aggiunge dato in posizione
        void Vettore.add(stringa) // Aggiunge dato in coda
        void Vettore.remove(posizione) // Rimuove dato dalla posizione e shifta il vettore
     */
    public static String convertiDaCSV(String daConvertire, int nParametri, String[] nomiParametri) {
        String convertita = "";
        String[] parametri = new String[nParametri];
        parametri = daConvertire.split(";");
        for (int i = 0; i < nParametri; i++) {
            convertita += nomiParametri[i] + "=" + parametri[i] + ";";
        }
        return convertita;
    }

    // Metodo che non mette in ordine i parametri ma li estrapola in ordine sparso
    /* public static String[] getParametriDaStringa(String daConvertire, int nParametri) {
        String[] parametri = new String[nParametri];
        String[] splittato = new String[nParametri];
        splittato = daConvertire.split(";");
        String[] parametroDiviso = new String[2];
        for (int i = 0; i < nParametri; i++) {
            parametroDiviso = splittato[i].split("=");
            parametri[i] = parametroDiviso[1];
        }
        return parametri;
    } */

    // Mette anche in ordine i parametri come sono scritti nel vettore (es. Nome;Cognome;AnnoNascita)
    public static String[] getParametriDaStringa(String daConvertire, int nParametri, String[] nomiParametri) {
        String[] parametri = new String[nParametri];
        String[] splittato = new String[nParametri];
        splittato = daConvertire.split(";");
        String[] parametroDiviso = new String[2];
        for (int i = 0; i < nParametri; i++) {
            parametroDiviso = splittato[i].split("=");
            for (int y = 0; y < nParametri; y++) {
                if (nomiParametri[y].equals(parametroDiviso[0]))
                    parametri[y] = parametroDiviso[1];
            }
        }
        return parametri;
    }

    public static Vector<String> leggiDaFile(String nomeFile) {
        String linea;
        Vector<String> righeLette = new Vector<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeFile));
            while ((linea = br.readLine()) != null) {
                righeLette.add(linea);
            }
            br.close();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura da file.");
        }
        return righeLette;
    }

    public static void scriviSuFile(String nomeFile, String daScrivere) {
        FileWriter fileScrittura = null;
        try {
            fileScrittura = new FileWriter(nomeFile, true);
            BufferedWriter fileBuffer = new BufferedWriter(fileScrittura);
            PrintWriter stampa = new PrintWriter(fileBuffer);
            stampa.println(daScrivere);
            stampa.close();
        } catch (IOException ex) {
            System.err.println("Errore nella scrittura su file.");
        } finally {
            try {
                fileScrittura.close();
            } catch (IOException ex) {
                System.err.println("Errore nella chisura del file in scrittura.");
            }
        }
    }
}
