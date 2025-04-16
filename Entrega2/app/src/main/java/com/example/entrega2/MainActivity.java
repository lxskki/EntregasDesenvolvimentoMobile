package com.example.entrega2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declaração dos componentes da interface
    EditText etSalario;          // Campo de entrada para o salário
    RadioGroup rgPercentuais;    // Grupo de radio buttons para os percentuais
    RadioButton rb40, rb45, rb50; // Radio buttons individuais
    Button btnCalcular;          // Botão para acionar o cálculo
    TextView txtResultado;      // Texto para exibir o resultado

    // Supressão de aviso sobre possível falta de inflação de ID
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define o layout da activity
        setContentView(R.layout.activity_main);

        // Vincula os componentes do XML às variáveis Java
        etSalario = findViewById(R.id.Salario);
        rgPercentuais = findViewById(R.id.rgPercentuais);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        // Configura o listener para o botão calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtém o valor digitado no campo salário
                String salarioStr = etSalario.getText().toString();

                // Valida se o campo está vazio
                if (salarioStr.isEmpty()) {
                    txtResultado.setText("Por favor, digite um salário válido.");
                    return; // Sai da função se não houver salário digitado
                }

                // Converte o salário para double
                double salario = Double.parseDouble(salarioStr);
                double percentual = 0; // Variável para armazenar o percentual selecionado

                // Verifica qual radio button está selecionado e define o percentual correspondente
                if (rb40.isChecked()) {
                    percentual = 0.40; // 40%
                } else if (rb45.isChecked()) {
                    percentual = 0.45; // 45%
                } else if (rb50.isChecked()) {
                    percentual = 0.50; // 50%
                } else {
                    // Se nenhum radio button estiver selecionado
                    txtResultado.setText("Selecione um percentual de aumento.");
                    return; // Sai da função se nenhum percentual for selecionado
                }

                // Calcula o novo salário (salário + aumento)
                double novoSalario = salario + (salario * percentual);

                // Exibe o resultado formatado com 2 casas decimais
                txtResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
            }
        });
    }
}