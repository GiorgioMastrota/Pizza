package it.nava.progettopizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class ActivityQuantita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantita);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int larghezza = dm.widthPixels;
        int altezza = dm.heightPixels;

        getWindow().setLayout((int)(larghezza * 0.7), (int)(altezza / 5));

        EditText editQuant = (EditText)findViewById(R.id.editQuantita);
        LinearLayout.LayoutParams eqL = new LinearLayout.LayoutParams(
                MetodiPubblici.getLarghezzaSchermo() / 5, LinearLayout.LayoutParams.WRAP_CONTENT);

        float densita = ActivityQuantita.this.getResources().getDisplayMetrics().density;
        final PopupWindow pw = new PopupWindow(layout, (int)densita*240, (int)densita*285, true);
        Button btnConferma = (Button)findViewById(R.id.btnConferma);
        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            setContentView(R.layout.);
            }
        });
    }
}
