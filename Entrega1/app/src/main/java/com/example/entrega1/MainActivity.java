package com.example.entrega1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Declaração das variáveis para os componentes da interface
    CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    Button btnCalcular;
    TextView txtResultado;

    // Supressão de aviso sobre possível falta de inflação de ID (comum ao usar ViewBinding)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ativa o modo edge-to-edge (conteúdo por baixo da status/barra de navegação)
        EdgeToEdge.enable(this);
        // Define o layout da activity
        setContentView(R.layout.activity_main);

        // Associa as variáveis aos elementos do layout XML
        cbArroz = findViewById(R.id.Arroz);
        cbLeite = findViewById(R.id.Leite);
        cbCarne = findViewById(R.id.Carne);
        cbFeijao = findViewById(R.id.Feijao);
        cbCoca = findViewById(R.id.Coca);

        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        // Configura o listener para tratar as barras do sistema (notch, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Obtém as dimensões das barras do sistema
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Aplica padding para evitar sobreposição com as barras do sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configura o listener para o botão calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0; // Variável para acumular o total

                // Verifica cada checkbox e soma o valor correspondente se estiver marcado
                if (cbArroz.isChecked()) {
                    total += 2.69; // Preço do arroz
                }
                if (cbLeite.isChecked()) {
                    total += 2.70; // Preço do leite
                }
                if (cbCarne.isChecked()) {
                    total += 16.70; // Preço da carne
                }
                if (cbFeijao.isChecked()) {
                    total += 3.38; // Preço do feijão
                }
                if (cbCoca.isChecked()) {
                    total += 3.00; // Preço da coca-cola
                }

                // Exibe o total formatado no TextView (com 2 casas decimais)
                txtResultado.setText(String.format("Total: R$ %.2f", total));
            }
        });
    }
}