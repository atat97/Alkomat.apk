package com.example.adrian.alkomat;

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
        WyswietlGramy();
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
        startActivity(intent);
    }
}
