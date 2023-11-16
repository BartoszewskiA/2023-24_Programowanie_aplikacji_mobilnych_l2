package com.example.lab04p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText poleA, poleB, poleWynik;
    Button licz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wyszukanieReferencji();
        tworzenieSluchacza();
    }

    private void wyszukanieReferencji() {
        poleA = findViewById(R.id.editText01);
        poleB = findViewById(R.id.editText02);
        poleWynik = findViewById(R.id.editText03);
        licz = findViewById(R.id.button01);
    }

    private void tworzenieSluchacza() {
        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = poleA.getText().toString();
                if(s1.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Pole 1 nie może być puste", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s2 = poleB.getText().toString();
                if(s2.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Pole 2 nie może być puste", Toast.LENGTH_SHORT).show();
                    return;
                }

                int x1 = Integer.parseInt(s1);
                int x2 = Integer.parseInt(s2);
                int wynik = x1+x2;
                poleWynik.setText(String.valueOf(wynik));
            }
        });
    }
}