package com.example.lab07p01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Array;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText et_login, et_pass;
    Button bt_zaloguj, bt_zarejestruj;

    public ArrayList<Osoba> zu = new ArrayList<Osoba>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_login = findViewById(R.id.et_login);
        et_pass = findViewById(R.id.et_pass);
        bt_zaloguj = findViewById(R.id.bt_zaloguj);
        bt_zarejestruj = findViewById(R.id.bt_zarejestruj);
        zu.add(new Osoba("Aaaa","a1"));
        zu.add(new Osoba("Bbbb","b1"));
        zu.add(new Osoba("Cccc","c1"));
        sluchacz();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==1)
        {
            String login = data.getStringExtra("l");
            String pass = data.getStringExtra("p");
            zu.add(new Osoba(login, pass));
        }
;
    }

    private void sluchacz() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id==R.id.bt_zaloguj)
                    zaloguj();
                else
                    zarejestruj()
;            }
        };
        bt_zaloguj.setOnClickListener(sluchacz);
        bt_zarejestruj.setOnClickListener(sluchacz);
    }

    private void zarejestruj() {
        Intent intencja = new Intent(this, MainActivity3.class);
        startActivityForResult(intencja, 1);

    }

    private void zaloguj() {
        String u = et_login.getText().toString();
        String p = et_pass.getText().toString();
        if(sprawdz(u,p))
        {
            Intent intencja = new Intent(getApplicationContext(), MainActivity2.class);
            intencja.putExtra("uzytkownik",u);
            startActivity(intencja);
        }
        else
            Toast.makeText(this, "Nieprawidłowy użytkownik lub hasło", Toast.LENGTH_SHORT).show();
    }

    private boolean sprawdz(String u, String p) {
        for(int i=0; i<zu.size(); i++)
        {
            if(zu.get(i).sprawdzHaslo(u,p))
               return true;
        }
        return false;
    }
}