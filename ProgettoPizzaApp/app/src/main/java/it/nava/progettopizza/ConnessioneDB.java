package it.nava.progettopizza;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB extends AsyncTask<String, String, String>{

    int operazione;
    private static Connection connessione;

    public ConnessioneDB(int operazione){
        this.operazione = operazione;
    }

    // 0 leggi menu

    @Override
    protected String doInBackground(String... strings) {
        connessione = connettiDB();

        try {
            connessione.close();
        } catch (SQLException e) {
            System.err.println("Errore nella chiusura della connessione al db.");
        }
        return null;
    }

    public static Connection connettiDB() {
        try {
            connessione = DriverManager.getConnection("jdbc:mysql://den1.mysql1.gear.host:3306/pizzeria1", "pizzeria1", "Qh10D-SGkm~9");
            System.out.println("Connessione al db effettuata con successo.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connessione al db fallita.");
        }
        return connessione;
    }
}
