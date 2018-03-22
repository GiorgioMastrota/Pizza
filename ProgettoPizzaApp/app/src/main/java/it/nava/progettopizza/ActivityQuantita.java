package it.nava.progettopizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class ActivityQuantita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantita);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int larghezza = dm.widthPixels;
        int altezza = dm.heightPixels;

        getWindow().setLayout((int)(larghezza * 0.7), (int)(altezza / 3));
    }
}
