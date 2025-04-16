package com.example.entrega4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;

public class Formulario extends AppCompatActivity {

    TextInputEditText textInputEditText;
    CheckBox cbXTudo, cbDoubleCarne, cbDoubleQueijo, cbXSalada, cbXBacon;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        textInputEditText = findViewById(R.id.textInputEditText);
        cbXTudo = findViewById(R.id.cbXTudo);
        cbDoubleCarne = findViewById(R.id.cbDoubleCarne);
        cbDoubleQueijo = findViewById(R.id.cbDoubleQueijo);
        cbXSalada = findViewById(R.id.cbXSalada);
        cbXBacon = findViewById(R.id.cbXBacon);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = textInputEditText.getText().toString();
                StringBuilder pedidoBuilder = new StringBuilder();

                if (nome.isEmpty()) {
                    textInputEditText.setError("Digite seu nome");
                    return;
                }

                StringBuilder ingredientes = new StringBuilder();

                if (cbXTudo.isChecked()) ingredientes.append("Xtudo\n");
                if (cbDoubleCarne.isChecked()) ingredientes.append("Double Carne\n");
                if (cbDoubleQueijo.isChecked()) ingredientes.append("Double Queijo\n");
                if (cbXSalada.isChecked()) ingredientes.append("X Salada\n");
                if (cbXBacon.isChecked()) ingredientes.append("XBacon\n");

                if (ingredientes.length() == 0) {
                    ingredientes.append("Nenhum item selecionado");
                }

                String pedido = pedidoBuilder.toString();

                Intent intent = new Intent(Formulario.this, Resumo.class);
                intent.putExtra("nomeCliente", nome);
                intent.putExtra("pedido",pedido);
                startActivity(intent);
            }
        });
    }
}
