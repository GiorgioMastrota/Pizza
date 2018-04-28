package it.nava.progettopizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizzeria Ismail El Abiad");

        ConnessioneDB menu = new ConnessioneDB(0);
        menu.execute();

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

    private void richiestaMenu(){
        /* Il metodo funziona così: il server legge i dati dal database tramite php, conteggia quanti dati ha letto;
        *  Successivamente manda al client il numero di dati letti in modo che egli possa fare un ciclo di ricezione per le stringhe del menù;
        *  il client le suddivide nei vettori (pizze, panini, bibite, stuzzicherie) in modo che nelle activity specifiche vengano mostrati
        *  i menù relativi alla categoria.
        */
        //rete.Invia("richiestaMenu");
        //int numStringheMenu = Integer.parseInt(rete.Ricevi());
        // Le cose ricevute dal menù devono poi essere settate nei vettori
    }
}
