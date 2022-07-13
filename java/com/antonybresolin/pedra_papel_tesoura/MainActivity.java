package com.antonybresolin.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.jogar("pedra");
    }

    public void selecionadoPapel(View view) {
        this.jogar("papel");
    }

    public void selecionadoTesoura(View view) {
        this.jogar("tesoura");
    }

    private String opcaoSelecionadaPeloComputador() {
        ImageView imagemResultado = findViewById(R.id.imageViewResultado);
        int numero = new Random().nextInt(3);
        String opcaoComputador = "";

        switch (numero) {
            case 0:
                imagemResultado.setImageResource(R.drawable.pedra);
                opcaoComputador = "pedra";
                break;
            case 1:
                imagemResultado.setImageResource(R.drawable.papel);
                opcaoComputador = "papel";
                break;
            case 2:
                imagemResultado.setImageResource(R.drawable.tesoura);
                opcaoComputador = "tesoura";
                break;
        }
        return opcaoComputador;
    }

    private void resultadoJogo(String computador, String usuario) {
        TextView vencedor = findViewById(R.id.textViewVencedor);
        vencedor.setTextColor(getResources().getColor(R.color.red));

        //app ganhador
        if (computador.equals("pedra") && usuario.equals("tesoura") ||
                computador.equals("papel") && usuario.equals("pedra") ||
                computador.equals("tesoura") && usuario.equals("papel")) {

            vencedor.setText("Computador Vence");
        } else if (computador.equals(usuario)) {
            vencedor.setTextColor(getResources().getColor(R.color.black));
            vencedor.setText("EMPATE");
        } else {
            vencedor.setTextColor(getResources().getColor(R.color.green));
            vencedor.setText("VITORIA");
        }
    }

    public void jogar(String opcaoSelecionadaPeloUsuario) {
        resultadoJogo(opcaoSelecionadaPeloComputador(), opcaoSelecionadaPeloUsuario);
    }

}