package com.example.quizcidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



/* ALUNOS: Janaina Keroline Ercole GRR:20204451
            Nicolle Costa  GRR:20205286
            Rafael Tombolato GRR: 20200204
*/

    String[] cidades = {"Barcelona", "Brasilia", "Curitiba", "Las Vegas", "Montreal", "Paris", "Rio De Janeiro", "Salvador", "Sao Paulo", "Toquio"};
    String[] imagens = {"http://31.220.51.31/ufpr/cidades/01_barcelona.jpg", "http://31.220.51.31/ufpr/cidades/02_brasilia.jpg", "http://31.220.51.31/ufpr/cidades/03_curitiba.jpg", "http://31.220.51.31/ufpr/cidades/04_lasvegas.jpg", "http://31.220.51.31/ufpr/cidades/05_montreal.jpg", "http://31.220.51.31/ufpr/cidades/06_paris.jpg", "http://31.220.51.31/ufpr/cidades/07_riodejaneiro.jpg", "http://31.220.51.31/ufpr/cidades/08_salvador.jpg", "http://31.220.51.31/ufpr/cidades/09_saopaulo.jpg", "http://31.220.51.31/ufpr/cidades/10_toquio.jpg"};

    private Random random;
    int resultado = 0;
    int rodada = 0;
    String linkImagem;
    String cidade;


    ImageView imageView;
    EditText editTextInput;
    TextView textViewOutput;
    Button buttonEnviar;
    Button buttonContinuar;
    TextView respostaCorreta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imagem);
        editTextInput = findViewById(R.id.editTextCidade);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonContinuar = findViewById(R.id.buttonContinuar);
        respostaCorreta = findViewById(R.id.respostaCorreta);

        IniciaRodada();


    }


    public void IniciaRodada() {

        random = new Random();
        int random2 = random.nextInt(10);
        linkImagem = imagens[random2];
        cidade = cidades[random2];
        Glide.with(imageView)
                .load(linkImagem)
                .into(imageView);

        Button btEnviar = findViewById(R.id.buttonEnviar);
        btEnviar.setEnabled(true);
        Button btContinuar = findViewById(R.id.buttonContinuar);
        btContinuar.setEnabled(false);
        rodada++;


    }


    public void validaResposta(View view) {


        String inputCapital = editTextInput.getText().toString().toLowerCase();
        cidade = cidade.toLowerCase();
        if (cidade.equals(inputCapital)) {
            System.out.println("entrou");
            resultado = resultado + 25;
            TextView totalPontos = findViewById(R.id.textViewPontos);
            totalPontos.setText(resultado + " pontos");


        } else {
            TextView totalPontos = findViewById(R.id.textViewPontos);
            totalPontos.setText(resultado + " pontos");
            respostaCorreta.setText(cidade);


        }
        Button btEnviar = findViewById(R.id.buttonEnviar);
        btEnviar.setEnabled(false);
        Button btContinuar = findViewById(R.id.buttonContinuar);
        btContinuar.setEnabled(true);

    }


    public void proximaPagina(View view) {


        if (rodada < 4) {
            respostaCorreta.setText("");
            editTextInput.setText("");
            IniciaRodada();
        } else {
            Intent it = new Intent(this, pontuacao.class);
            it.putExtra("resultado", resultado);
            startActivity(it);
        }


    }
}