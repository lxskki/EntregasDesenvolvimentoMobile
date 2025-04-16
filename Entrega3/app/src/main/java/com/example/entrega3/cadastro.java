package com.example.entrega3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class cadastro extends AppCompatActivity {
    TextView txtBoasVindas;
    Button btnVoltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtBoasVindas = findViewById(R.id.txtBoasVindas);
        btnVoltarInicio = findViewById(R.id.btnVoltarInicio);

        // Recupera o nome enviado pela activity anterior
        String nomeCliente = getIntent().getStringExtra("nomeCliente");
        txtBoasVindas.setText("Bem-vindo, " + nomeCliente + "!");

        btnVoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cadastro.this, MainActivity.class);
                // limpa o histórico de Activities anteriores
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
