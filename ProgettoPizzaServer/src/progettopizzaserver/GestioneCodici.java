package progettopizzaserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestioneCodici {

    Random rand = new Random();
    List<String> codiciBarre = new ArrayList<String>();

    // Richiede al metodo che sia generato un codice, lo inserisce nel vettore e lo restituisce al main
    public String getNuovoCodice() {
        String codice = generaCodice();
        codiciBarre.add(codice);
        System.out.println(codice);
        return codice;
    }

    // Genera il codice a 8 cifre che verrà usato per generare il codice a barre
    private String generaCodice() {
        String codice = "";
        boolean giaEsistente = false;
        do {
            // Genero le 8 cifre del codice
            for (int i = 0; i < 8; i++) {
                codice += rand.nextInt(10);
            }
            // Controllo se il codice generato è già esistente (non dovrebbe succedere)
            for (int i = 0; i < codiciBarre.size(); i++){
                if (codice.equals(codiciBarre.get(i)))
                    giaEsistente = true;
            }
        } while (giaEsistente == true);
        return codice;
    }
}
