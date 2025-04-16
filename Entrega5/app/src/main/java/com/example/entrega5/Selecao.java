package com.example.entrega5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Selecao extends AppCompatActivity {

    RadioGroup rgTamanho, rgPagamento;
    Button btnEnviar;
    ArrayList<String> saboresSelecionados;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao);

        rgTamanho = findViewById(R.id.rgTamanho);
        rgPagamento = findViewById(R.id.rgPagamento);
        btnEnviar = findViewById(R.id.btnTamanhoEPagamento);

        // Recebendo os sabores da primeira tela
        saboresSelecionados = getIntent().getStringArrayListExtra("sabores");

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idTamanho = rgTamanho.getCheckedRadioButtonId();
                int idPagamento = rgPagamento.getCheckedRadioButtonId();

                if (idTamanho != -1 && idPagamento != -1) {
                    RadioButton rbTamanho = findViewById(idTamanho);
                    RadioButton rbPagamento = findViewById(idPagamento);

                    String tamanho = rbTamanho.getText().toString();
                    String pagamento = rbPagamento.getText().toString();

                    Intent intent = new Intent(Selecao.this, Resumo.class);
                    intent.putStringArrayListExtra("sabores", saboresSelecionados);
                    intent.putExtra("tamanho", tamanho);
                    intent.putExtra("pagamento", pagamento);
                    startActivity(intent);
                }
            }
        });
    }
}

