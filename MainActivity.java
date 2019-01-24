package com.example.adrian.alkomat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double gramyAlk = 0;
    String waga1 = "0";
    Boolean stan;
    double graf;
    double czas;
    double promile = 0;

    double voltage;
    double ilosc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Piwo(View view) {
        gramyAlk += 17.55;
        WyswietlGramy();
    }
    public void Wodka(View view) {
        gramyAlk += 15.60;
        WyswietlGramy();
    }
    public void Wino(View view) {
        gramyAlk += 16.38;
        WyswietlGramy();
    }
    public void Wyczysc(View view){
        gramyAlk = 0;
        promile = 0;
        TextView trzezwy = (TextView)findViewById(R.id.trzezwy);
        trzezwy.setText("");
        TextView Obliczone = (TextView)findViewById(R.id.textViewOblicz);
        Obliczone.setText("");
        WyswietlGramy();
    }
    public void Inne(View view){
        Intent intent = new Intent(this, InneActivity.class);
        startActivityForResult(intent,2);
    }

    private void WyswietlGramy() {
        TextView IleGram = (TextView)findViewById(R.id.textViewIleGram);
        String IleGramStr = String.format("%.2f", gramyAlk);
        IleGram.setText(IleGramStr);
    }

    public void edytujProfil(View view) {
        otworz_proflActivity();
    }

    private void otworz_proflActivity() {
        Intent intent = new Intent(this, profilActivity.class);
        waga1 = waga1;
        intent.putExtra("extra_waga",waga1);
        startActivityForResult(intent,1);

    }

    public void Oblicz(View view){
        TextView Obliczone = (TextView)findViewById(R.id.textViewOblicz);
        int wagai = Integer.parseInt(waga1);
        if(wagai == 0) {
            Toast.makeText(MainActivity.this, "BRAK WAGI!", Toast.LENGTH_SHORT ).show();
        } else {
            if (stan == Boolean.TRUE)
                promile = gramyAlk/(0.6*wagai);
            else
                promile = gramyAlk/(0.7*wagai);
            Obliczone.setText(String.format("Promili po 1h: %.2f", promile));

            graf = Math.round(promile*100.0)/100.0;
            double petla = promile;
            int godz = 0;
            while (petla >0.2) {
                petla = petla - 0.12;
                godz = godz + 1;
            }
            godz = godz + 1;
            czas = godz;
            TextView trzezwy = (TextView)findViewById(R.id.trzezwy);
            if (stan == Boolean.TRUE)
                trzezwy.setText(String.format("Bedziesz trzeźwa za ok. %dh",godz));
            else
                trzezwy.setText(String.format("Bedziesz trzeźwy za ok. %dh",godz));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Bundle extras = data.getExtras();
                waga1 = extras.getString("extra_waga");
                stan = extras.getBoolean("extra_stan");
                //Toast.makeText(MainActivity.this, "Stan: " + stan, Toast.LENGTH_SHORT ).show();
                //Toast.makeText(MainActivity.this, "Waga: " + waga1, Toast.LENGTH_SHORT ).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
        if (requestCode == 2){
            if(resultCode == Activity.RESULT_OK){
                Bundle extras = data.getExtras();
                ilosc = extras.getDouble("extra_ilosc");
                voltage = extras.getDouble("extra_voltage");

                double wynik = ilosc*voltage/100.0*0.78;
                //Toast.makeText(MainActivity.this, "Stan: " + wynik, Toast.LENGTH_SHORT ).show();
                gramyAlk += Math.round(wynik*100.0)/100.0;
                WyswietlGramy();


                //Toast.makeText(MainActivity.this, "Stan: " + stan, Toast.LENGTH_SHORT ).show();
                //Toast.makeText(MainActivity.this, "Waga: " + waga1, Toast.LENGTH_SHORT ).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }

    public void graph(View view) {
        if(graf==0 || czas == 0) {
            Toast.makeText(MainActivity.this, "Brak obliczonych promili lub wagi!!!" , Toast.LENGTH_SHORT ).show();
        }
        else {
            Intent intent = new Intent(this, GraphActivity.class);
            intent.putExtra("extra_promile", graf);
            intent.putExtra("extra_czas", czas);
            startActivity(intent);
        }
    }
}
