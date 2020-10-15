package br.com.pdm.androidbd;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tela_principal extends AppCompatActivity implements View.OnClickListener{

    Dao vrBancoDeDados = null;

    EditText nome = null;
    EditText placa = null;
    EditText ano = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_principal);

        nome = (EditText)findViewById(R.id.telaCadastro_nome);
        placa = (EditText)findViewById(R.id.telaCadastro_placa);
        ano = (EditText)findViewById(R.id.telacadastro_Ano);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.telaCadastro_Gravar) {
            gravarCarros(v);
        }

        if (v.getId() == R.id.telaCadastro_Listar) {
            listarCarros(v);
        }
    }

    public void gravarCarros(View v){
        vrBancoDeDados = new Dao(this, "BDCarros", 2);
        ContentValues dados = new ContentValues();
        dados.put("nome", this.nome.getText().toString());
        dados.put("placa", this.placa.getText().toString());
        dados.put("ano", this.ano.getText().toString());
        vrBancoDeDados.insereCarro(dados);
    }

    public void listarCarros(View v){
        Intent intencaoVaiParaLista = new Intent(Tela_principal.this, Tela_lista_carros.class);
        startActivity(intencaoVaiParaLista);
    }

}
