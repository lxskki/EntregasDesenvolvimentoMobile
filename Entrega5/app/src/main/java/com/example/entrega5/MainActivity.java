package com.example.entrega5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox cbCalabresa, cbQueijo, cbPortuguesa;
    Button btnProxima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbQueijo = findViewById(R.id.cbQueijo);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        btnProxima = findViewById(R.id.btnMain);

        btnProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> saboresSelecionados = new ArrayList<>();

                if (cbCalabresa.isChecked()) saboresSelecionados.add("Calabresa");
                if (cbQueijo.isChecked()) saboresSelecionados.add("Queijo");
                if (cbPortuguesa.isChecked()) saboresSelecionados.add("Portuguesa");

                Intent intent = new Intent(MainActivity.this, Selecao.class);
                intent.putStringArrayListExtra("sabores", saboresSelecionados);
                startActivity(intent);
            }
        });
    }
}