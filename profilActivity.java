package com.example.adrian.alkomat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profilActivity extends AppCompatActivity {

    public static final String EXTRA_WAGA = "com.example.adrian.alkomat.EXTRA_WAGA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    public void zapiszProfil(View view) {
        TextView Waga = (TextView)findViewById(R.id.waga);
        int waga_int = Integer.parseInt(Waga.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_WAGA, waga_int);
        startActivity(intent);
    }
}
