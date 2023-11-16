package com.example.lab04p02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    char[] znaki = {'a','b','c','d','e','0','1','2','3','4','5','6','7','8','9','#','@'};

    final int MAX = 25;
    final int MIN = 5;

    TextView tv_dlugosc;
    SeekBar suwak;
    Button bt_generuj;
    EditText et_wynik;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_dlugosc = findViewById(R.id.textView02);
        suwak = findViewById(R.id.seekBar01);
        bt_generuj = findViewById(R.id.button01);
        et_wynik = findViewById(R.id.editText01);
        suwak.setMax(MAX);
        suwak.setMin(MIN);
        suwak.setProgress(10);
        tv_dlugosc.setText(String.valueOf(suwak.getProgress()));
        random = new Random();
        dodajSluchacze();
    }

    private void dodajSluchacze() {
        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_dlugosc.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bt_generuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = "";
                for (int i=0; i<suwak.getProgress(); i++)
                {
                    pass+= znaki[random.nextInt(znaki.length)];
                }
                et_wynik.setText(pass);
            }
        });
    }


}