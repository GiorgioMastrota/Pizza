package it.nava.progettopizza;

public class ProdottiScelti {

    private int numProdotti;

    public ProdottiScelti(){
        numProdotti = 0;
    }

    public void incrementaNumProd(){
        numProdotti++;
    }

    // GET E SET

    public int getNumProdotti(){
        return numProdotti;
    }
}
