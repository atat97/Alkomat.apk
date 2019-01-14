package com.example.adrian.alkomat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class profilActivity extends AppCompatActivity {

    Boolean stan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    /*public void zapiszProfil(View view) {
        TextView Waga = (TextView)findViewById(R.id.waga);
        String waga = Waga.getText().toString();


        Intent intent = new Intent(profilActivity.this, MainActivity.class);
        intent.putExtra("extra_waga",waga);
        //Toast.makeText(profilActivity.this, "Waga: " + waga, Toast.LENGTH_SHORT ).show();
        startActivity(intent);
    }*/
    public void zapiszProfil(View view){
        Intent returnIntent = new Intent();


        TextView Waga = (TextView) findViewById(R.id.waga);
        String waga = Waga.getText().toString();

        returnIntent.putExtra("extra_waga",waga);

        Switch plec = (Switch) findViewById(R.id.switch1plec);
        stan = plec.isChecked();
        returnIntent.putExtra("extra_stan",stan);

        setResult(Activity.RESULT_OK,returnIntent);

        //Toast.makeText(profilActivity.this, "Waga: " + waga, Toast.LENGTH_SHORT ).show();
        finish();
    }
}

