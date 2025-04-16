package com.example.entrega5;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Resumo extends AppCompatActivity {

    TextView txtResumo, txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumo = findViewById(R.id.txtResumoPedido);
        txtTotal = findViewById(R.id.txtTotalPagar);

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");

        StringBuilder resumo = new StringBuilder();
        double total = 0;

        resumo.append("Sabores: ");
        for (String sabor : sabores) {
            resumo.append(sabor).append(" ");

            switch (sabor) {
                case "Calabresa":
                    total += 30.0;
                    break;
                case "Queijo":
                    total += 25.0;
                    break;
                case "Portuguesa":
                    total += 35.0;
                    break;
            }
        }

        resumo.append("\nTamanho: ").append(tamanho);
        resumo.append("\nPagamento: ").append(pagamento);

        // Acrescentar valor de acordo com o tamanho
        switch (tamanho) {
            case "Grande":
                total += 10;
                break;
            case "Media":
                total += 5;
                break;
            case "Pequena":
                total += 0;
                break;
        }

        txtResumo.setText(resumo.toString());
        txtTotal.setText("Total a pagar: R$ " + String.format("%.2f", total));
    }
}
