package it.nava.progettopizza;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ActivityQuantita extends AppCompatActivity {

    static int valore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantita);

        final int idProdotto = getIntent().getIntExtra("idBottone", -1);
        final int idCategoria = getIntent().getIntExtra("idCategoria", -1);

        getWindow().setLayout((int)(MetodiPubblici.getLarghezzaSchermo() * 0.7), LinearLayout.LayoutParams.WRAP_CONTENT);

        final TextView tv = (TextView) findViewById(R.id.textQuantita);
        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);

        //Set TextView text color
        tv.setTextColor(Color.BLACK);

        np.setMinValue(1);
        np.setMaxValue(50);

        np.setWrapSelectorWheel(true);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int valVecchio, int valNuovo){
                valore = valNuovo;
                tv.setText("Quantità");
            }
        });

        LinearLayout.LayoutParams eqL = new LinearLayout.LayoutParams(
                MetodiPubblici.getLarghezzaSchermo() / 5, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button btnConferma = (Button)findViewById(R.id.btnConferma);
        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < valore; i++) {
                    ProdottiScelti.aggiungiProdotto(idProdotto, idCategoria);
                }
                    Toast toast = Toast.makeText(getApplicationContext(), "Prodotto aggiunto.", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
