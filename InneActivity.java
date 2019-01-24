package com.example.adrian.alkomat;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class InneActivity extends AppCompatActivity {

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inne);

        final EditText Ilosc = (EditText)findViewById(R.id.ilosc);
        final EditText Voltage = (EditText)findViewById(R.id.voltage);

        Ilosc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Ilosc.setText("");
                }
            }
        });

        Voltage.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Voltage.setText("");
                }
            }
        });

    }

    public void dodaj(View view) {


            Intent returnIntent = new Intent();

            EditText Ilosc = (EditText) findViewById(R.id.ilosc);
            EditText Voltage = (EditText) findViewById(R.id.voltage);

            //Ilosc.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
            //Voltage.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

            String il = Ilosc.getText().toString();
            String vol = Voltage.getText().toString();



            //Toast.makeText(InneActivity.this,"ilosc:"+il , Toast.LENGTH_SHORT).show();
            if (il.equals("")||vol.equals("")||il.equals("Ilosc [ml]")||vol.equals("Zawartosc alk. [%]")) {
                Toast.makeText(InneActivity.this, "Brak ilosci lub zawartosci alk.!!!", Toast.LENGTH_SHORT).show();
            } else {
                double ilosc = Double.parseDouble(il);
                double voltage = Double.parseDouble(vol);
                returnIntent.putExtra("extra_ilosc", ilosc);
                returnIntent.putExtra("extra_voltage", voltage);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
    }
}
