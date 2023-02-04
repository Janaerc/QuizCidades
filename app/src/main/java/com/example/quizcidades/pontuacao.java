package com.example.quizcidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class pontuacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        TextView resultado = findViewById(R.id.textViewResposta2);

        Intent it = getIntent();

        int resultados = it.getIntExtra("resultado",0);

        resultado.setText(Integer.valueOf(resultados).toString());







    }
}