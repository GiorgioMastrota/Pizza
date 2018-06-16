package it.nava.progettopizzacomande;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListaComande {

    private List<Comanda> listaComande;

    public ListaComande() {
        listaComande = new ArrayList<>();
        inizializzaComande();
    }

    public void inizializzaComande(){
       OperazioniDB richiesta = new OperazioniDB(0);
       String strComande = "";
        try {
            strComande = richiesta.execute().get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("ListaComande: errore nella richiesta delle comande.");
        }
        String[] comande = strComande.split(":");
        for (int i = 0; i < comande.length; i++){
            String[] valori = comande[i].split(";");
            int codiceOrdine = Integer.parseInt(valori[0]);
            boolean asporto = false;
            if (valori[1].equals(1))
                asporto = true;
            String[] prodottiOrdinati = valori[2].split(",");
            String stringaOrdine = "";
            for (int y = 0; y < prodottiOrdinati.length; y++){
                if (y != 0){
                    stringaOrdine += ", ";
                }
                stringaOrdine += ListaProdotti.getNomeProdotto(Integer.parseInt(prodottiOrdinati[y]));
            }
            Comanda daAggiungere = new Comanda(codiceOrdine, asporto, stringaOrdine);
            aggiungiComanda(daAggiungere);
        }
    }

    public void soddisfaComanda(int idComanda){
        Comanda daSoddisfare = getComanda(idComanda);
        String codice = Integer.toString(daSoddisfare.getCodice());
        OperazioniDB soddisfa = new OperazioniDB(1);
        try {
            soddisfa.execute(codice).get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("ListaComande: errore nel soddisfacimento della comanda.");
        }
        rimuoviComanda(idComanda);
    }

    // Get e Set

    public Comanda getComanda(int pos) {
        return listaComande.get(pos);
    }

    public void aggiungiComanda(Comanda comanda){
        listaComande.add(comanda);
    }

    public void rimuoviComanda(int idComanda){
        listaComande.remove(idComanda);
    }

    public int getNumComande(){
        return listaComande.size();
    }
}
