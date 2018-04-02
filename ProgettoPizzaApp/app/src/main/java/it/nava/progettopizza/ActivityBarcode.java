package it.nava.progettopizza;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ActivityBarcode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        // Richiede codice numerico al server che glielo invia
        String codice = MetodiPubblici.richiestaBarcode();
        // Lo fa il server per avere maggior controllo su quelli già esistenti

        LinearLayout ll = (LinearLayout)findViewById(R.id.lbPrincipale);

        ImageView imgBarcode = new ImageView(this);
        imgBarcode.setForegroundGravity(Gravity.CENTER);

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(codice, BarcodeFormat.EAN_8,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imgBarcode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        ll.addView(imgBarcode);
    }
}
