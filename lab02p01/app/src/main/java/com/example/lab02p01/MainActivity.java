package com.example.lab02p01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView licznik;
    int ile =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        licznik = findViewById(R.id.textView01);
        licznik.setTextColor(Color.GRAY);
    }

    public void plus(View view) {
        ile++;
        licznik.setText(String.valueOf(ile));
        koloruj();
    }

    public void zeruj(View view) {
        ile=0;
        licznik.setText(String.valueOf(ile));
        koloruj();
    }

    public void minus(View view) {
        ile--;
        licznik.setText(String.valueOf(ile));
        koloruj();
    }

    private void koloruj()
    {
        if(ile>0) licznik.setTextColor(Color.GREEN);
        else if(ile==0) licznik.setTextColor(Color.BLACK);
        else licznik.setTextColor(Color.RED);
    }
}