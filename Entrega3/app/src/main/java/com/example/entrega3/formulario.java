package com.example.entrega3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class formulario extends AppCompatActivity {

    TextInputEditText etNome;
    Button btnIrConclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = findViewById(R.id.etNome);
        btnIrConclusao = findViewById(R.id.btnIrConclusao);

        btnIrConclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = etNome.getText().toString();

                if (!nome.isEmpty()) {
                    Intent intent = new Intent(formulario.this, cadastro.class);
                    intent.putExtra("nomeCliente", nome);
                    startActivity(intent);
                } else {
                    etNome.setError("Digite seu nome");
                }
            }
        });
    }
}
