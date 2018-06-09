package it.nava.progettopizzacomande;

public class Comanda {

    int codice;
    boolean asporto;
    String strOrdine;

    public Comanda(int codice, boolean asporto, String strOrdine){
        this.codice = codice;
        this.asporto = asporto;
        this.strOrdine = strOrdine;
    }

    // Get

    public int getCodice() {
        return codice;
    }

    public boolean isAsporto() {
        return asporto;
    }

    public String getStrOrdine() {
        return strOrdine;
    }
}
