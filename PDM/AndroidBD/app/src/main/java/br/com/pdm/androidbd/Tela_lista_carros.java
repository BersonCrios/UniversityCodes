package br.com.pdm.androidbd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Tela_lista_carros extends AppCompatActivity {

    private Context contexto;
    Dao vrBancoDeDados = null;
    RecyclerView lista = null;
    ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_lista_carros);

        vrBancoDeDados = new Dao(this, "BDCarros", 2);
        lista = findViewById(R.id.lista_carros);

        carros = vrBancoDeDados.listaCarros();

        RecyclerView listaRecycleView = null;
        listaRecycleView = (RecyclerView) findViewById(R.id.lista_carros);
        listaRecycleView.setLayoutManager(new LinearLayoutManager(contexto));
        listaRecycleView.setItemAnimator(new DefaultItemAnimator());
        listaRecycleView.setHasFixedSize(true);


        CarroAdapter adapt = new CarroAdapter(this, carros);
        listaRecycleView.setAdapter(adapt);
    }


}
