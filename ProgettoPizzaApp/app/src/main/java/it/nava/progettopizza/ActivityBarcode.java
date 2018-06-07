package it.nava.progettopizza;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class ActivityBarcode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        // Genera un codice random
        final String codice = generaCodice();

        // Creazione stringa ordini
        String ordine = creaStringaOrdine();

        int costoTot = ProdottiScelti.getCostoTot();

        String asporto = "0";
        if (ProdottiScelti.isAsporto())
            asporto = "1";

        OperazioniDB inviaOrdine = new OperazioniDB(1);
        String dataOra = getDataOra();
        try {
            inviaOrdine.execute(codice, asporto, Double.toString(costoTot), dataOra, ordine).get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("ActivityBarcode: errore nell'invio dell'ordine al db.");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imgBarcode);
        Bitmap bitmap = codificaBitmap(codice);
        imageView.setImageBitmap(bitmap);

        // Bottone per l'annullamento dell'ordine
        Button btnAnnullaOrdine = (Button) findViewById(R.id.btnAnnullaOrdine);
        btnAnnullaOrdine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProdottiScelti.annullaOrdine(); // Leva tutto dal vettore dell'app
                OperazioniDB annullaOrdine = new OperazioniDB(2);
                try {
                    annullaOrdine.execute(codice).get();
                } catch (InterruptedException | ExecutionException e) {
                    System.err.println("Errore nell'annullamento dell'ordine.");
                }
                startActivity(new Intent(ActivityBarcode.this, ActivityMain.class));
            }
        });
    }

    // Alla pressione del tasto indietro l'utente non deve poter tornare indietro per impedire che si duplichi l'ordine
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Annulla l'ordine per tornare indietro.", Toast.LENGTH_SHORT).show();
    }

    Bitmap codificaBitmap(String str) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            int largh = MetodiPubblici.getLarghezzaSchermo() / 2;
            BitMatrix bitMatrix = multiFormatWriter.encode(str, BarcodeFormat.QR_CODE, largh, largh);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        } catch (Exception e) {
            System.out.println("ActivityBarcode: Errore nella generazione del codice a barre.");
            return null;
        }
    }

    private String generaCodice() {
        Random rand = new Random();
        String codice = "";
        for (int i = 0; i < 8; i++) {
            int gen = rand.nextInt(10);
            while (i == 0 && gen == 0) {
                gen = rand.nextInt(10);
            }
            codice += gen;
        }
        return codice;
    }

    private String creaStringaOrdine() {
        String ordine = "";
        for (int i = 0; i < ProdottiScelti.getNumPizze(); i++) {
            ordine += ProdottiScelti.getPizza(i) + ",";
        }
        for (int i = 0; i < ProdottiScelti.getNumPanini(); i++) {
            ordine += ProdottiScelti.getPanino(i) + ",";
        }
        for (int i = 0; i < ProdottiScelti.getNumBibite(); i++) {
            ordine += ProdottiScelti.getBibita(i) + ",";
        }
        for (int i = 0; i < ProdottiScelti.getNumStuzzicherie(); i++) {
            ordine += ProdottiScelti.getStuzzicheria(i) + ",";
        }
        return ordine;
    }

    private String getDataOra() {
        @SuppressLint("SimpleDateFormat") DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
        Date data = new Date();
        return formatoData.format(data);
    }
}
