package com.example.entrega4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resumo extends AppCompatActivity {

    TextView txtNomeELanche;
    Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtNomeELanche = findViewById(R.id.txtNomeELanche);
        buttonVoltar = findViewById(R.id.button);

        // Recuperar os dados enviados pela segunda activity
        Intent intent = getIntent();
        String nomeCliente = intent.getStringExtra("nomeCliente");
        String pedido = intent.getStringExtra("pedido");

        // Montar a mensagem final
        String mensagemFinal = "Cliente: " + nomeCliente + "\nPedido:\n" + pedido;
        txtNomeELanche.setText(mensagemFinal);

        // Botão que volta para a tela inicial
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarInicio = new Intent(Resumo.this, MainActivity.class);
                // Limpa o histórico de activities para evitar voltar com o botão do sistema
                voltarInicio.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(voltarInicio);
                finish();
            }
        });
    }
}