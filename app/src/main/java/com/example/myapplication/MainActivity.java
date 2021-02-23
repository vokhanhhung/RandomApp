package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    TextView tvNumberRandom;
    Button btnRandom;
    EditText edtNumberMin, edtNumberMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumberRandom = findViewById(R.id.tvNumberRandom);
        btnRandom = findViewById(R.id.btnRandom);
        edtNumberMin = findViewById(R.id.edtNumberMin);
        edtNumberMax = findViewById(R.id.edtNumberMax);

       btnRandom.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {
               int numberMin = Integer.parseInt(String.valueOf(edtNumberMin.getText()));
               int numberMax = Integer.parseInt(String.valueOf(edtNumberMax.getText()));

               if (numberMax <= numberMin){
                   Toast.makeText(getApplicationContext(), "Number max must larger number min", Toast.LENGTH_LONG).show();
                   numberMax = numberMin + 1;
                   edtNumberMax.setText(String.valueOf(numberMax));
               }
               int numberRandom = (int) Math.round(numberMin + (numberMax - numberMin) * Math.random());
               tvNumberRandom.setText("Result: "+ String.valueOf(numberRandom));

           }
       });
    }
}