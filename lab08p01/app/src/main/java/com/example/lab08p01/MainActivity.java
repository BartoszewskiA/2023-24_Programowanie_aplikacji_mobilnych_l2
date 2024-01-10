package com.example.lab08p01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
ImageView ramka;
TextView opis;
    int[] grafiki = new int[]
        {
                R.drawable.rys_01,
                R.drawable.rys_02,
                R.drawable.rys_03
        };
String[] opisy;
Random random = new Random();
int poz = 0;
GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ramka = findViewById(R.id.iv_obrazek);
        opis = findViewById(R.id.tv_podpis);
        opisy = getResources().getStringArray(R.array.opisy);
        poz = random.nextInt(grafiki.length);
        ramka.setImageResource(grafiki[poz]);
        opis.setText(opisy[poz]);
        detector = new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}