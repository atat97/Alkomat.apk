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
    String waga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        waga = getIntent().getStringExtra("extra_waga");
        TextView Waga = (TextView) findViewById(R.id.waga);
        //Toast.makeText(profilActivity.this, "Waga: " + waga, Toast.LENGTH_SHORT ).show();
        if(waga.equals("0")){}
        else
            Waga.setText(waga);
    }

    public void zapiszProfil(View view){
        Intent returnIntent = new Intent();


        TextView Waga = (TextView) findViewById(R.id.waga);
        waga = Waga.getText().toString();

        returnIntent.putExtra("extra_waga",waga);

        Switch plec = (Switch) findViewById(R.id.switch1plec);
        stan = plec.isChecked();
        returnIntent.putExtra("extra_stan",stan);

        setResult(Activity.RESULT_OK,returnIntent);

        //Toast.makeText(profilActivity.this, "Waga: " + waga, Toast.LENGTH_SHORT ).show();
        finish();
    }
}

