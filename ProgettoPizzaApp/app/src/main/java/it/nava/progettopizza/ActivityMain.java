package it.nava.progettopizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.concurrent.ExecutionException;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizzeria Ismail El Abiad");

        OperazioniDB pizze = new OperazioniDB(0);
        OperazioniDB panini = new OperazioniDB(0);
        OperazioniDB bibite = new OperazioniDB(0);
        OperazioniDB stuzzicherie = new OperazioniDB(0);
        try {
            String pizzeLette = pizze.execute("Pizza").get();
            String paniniLetti = panini.execute("Panino").get();
            String bibiteLette = bibite.execute("Bibite").get();
            String stuzzicherieLette = stuzzicherie.execute("Stuzzicheria").get();
            inizializzaMenu("Pizza", pizzeLette);
            inizializzaMenu("Panino", paniniLetti);
            inizializzaMenu("Bibite", bibiteLette);
            inizializzaMenu("Stuzzicheria", stuzzicherieLette);

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("MainActivity: errore nell'esecuzione dei thread per la comunicazione col db.");
        }

        Button btnRiepilogo = (Button)findViewById(R.id.btnMainRiepilogo);
        btnRiepilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityRiepilogo.class));
            }
        });

        // Passaggio Activity Pizze
        ImageButton btnPizze = (ImageButton)findViewById(R.id.imgBtnPizze);
        btnPizze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizze = new Intent(ActivityMain.this, ActivityProdotto.class);
                intentPizze.putExtra("categoria", 1);
                startActivity(intentPizze);
            }
        });

        // Passaggio Activity Panini
        ImageButton btnPanini = (ImageButton)findViewById(R.id.imgBtnPanini);
        btnPanini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPanini = new Intent(ActivityMain.this, ActivityProdotto.class);
                intentPanini.putExtra("categoria", 2);
                startActivity(intentPanini);
            }
        });

        // Passaggio Activity Bibite
        ImageButton btnBibite = (ImageButton)findViewById(R.id.imgBtnBibite);
        btnBibite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBibite = new Intent(ActivityMain.this, ActivityProdotto.class);
                intentBibite.putExtra("categoria", 3);
                startActivity(intentBibite);
            }
        });

        // Passaggio Activity Stuzzicherie
        ImageButton btnStuzzicherie = (ImageButton)findViewById(R.id.imgBtnStuzzicherie);
        btnStuzzicherie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStuzzicherie = new Intent(ActivityMain.this, ActivityProdotto.class);
                intentStuzzicherie.putExtra("categoria", 4);
                startActivity(intentStuzzicherie);
            }
        });
    }

    protected void onResume()
    {
        super.onResume();
        Button btnRiepilogo = (Button)findViewById(R.id.btnMainRiepilogo);
        MetodiPubblici.controlloBtnInvisibile(ActivityMain.this, btnRiepilogo);
    }

    private void inizializzaMenu(String categoria, String stringa){
        String[] righeLette = stringa.split(":");
        for (int i = 0; i < righeLette.length; i++){
            System.out.println(righeLette[i]);
            String[] rigaSplit = righeLette[i].split(";");
            int id = Integer.parseInt(rigaSplit[0]);
            String nome = rigaSplit[1];
            double costo = Double.parseDouble(rigaSplit[2]);
            String descrizione = rigaSplit[3];
            if (categoria.equals("Pizza")){
                Prodotto daInserire = new Prodotto(id, nome, 1, descrizione, costo);
                ListeProdotti.aggiungiPizza(daInserire);
            }
            else if (categoria.equals("Panino")){
                Prodotto daInserire = new Prodotto(id, nome, 2, descrizione, costo);
                ListeProdotti.aggiungiPanino(daInserire);
            }
            else if (categoria.equals("Bibite")){
                Prodotto daInserire = new Prodotto(id, nome, 3, descrizione, costo);
                ListeProdotti.aggiungiBibita(daInserire);
            }
            else if (categoria.equals("Stuzzicheria")){
                Prodotto daInserire = new Prodotto(id, nome, 4, descrizione, costo);
                ListeProdotti.aggiungiStuzzicheria(daInserire);
            }
        }
    }
}
