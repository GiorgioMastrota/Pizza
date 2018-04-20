package it.nava.progettopizza;

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

public class ActivityBarcode extends AppCompatActivity {

    boolean barcodeGenerato = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        // Richiede codice numerico al server che glielo invia
        String codice = richiestaBarcode();
        //String codice = "12345678";
        // Lo fa il server per avere maggior controllo su quelli già esistente

        ImageView imageView = (ImageView) findViewById(R.id.imgBarcode);
        try {
            Bitmap bitmap = codificaBitmap(codice);
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        // Bottone per l'annullamento dell'ordine
        Button btnAnnullaOrdine = (Button)findViewById(R.id.btnAnnullaOrdine);
        btnAnnullaOrdine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProdottiScelti.annullaOrdine();
                // MANCA mandare al server che l'ordine è stato annullato
                startActivity(new Intent(ActivityBarcode.this, ActivityMain.class));
            }
        });
    }

    // Alla pressione del tasto indietro l'utente non deve poter tornare indietro per impedire che si duplichi l'ordine
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Annulla l'ordine per tornare indietro.", Toast.LENGTH_SHORT).show();
    }

    Bitmap codificaBitmap(String str) throws WriterException {
        BitMatrix risultato;
        try {
            risultato = new MultiFormatWriter().encode(str,
                    BarcodeFormat.EAN_8, MetodiPubblici.getLarghezzaSchermo() / 2, 200, null);
        } catch (IllegalArgumentException iae) {
            // Formato non supportato
            return null;
        }
        int w = risultato.getWidth();
        int h = risultato.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = risultato.get(x, y) ? Color.BLACK : Color.WHITE;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, MetodiPubblici.getLarghezzaSchermo() / 2, 0, 0, w, h);
        return bitmap;
    }

    private String richiestaBarcode(){
        // da richiedere barcode
        String codice = MetodiPubblici.ricevuto;
        return codice;
    }
}
