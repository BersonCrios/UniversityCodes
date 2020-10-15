package br.com.bersoncrios.consumowebservice;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

public class BuscaDadosWebService extends AsyncTask<String, Void, ArrayList<Carro>> {
    public Activity mContexto;
    private Context contexto;
    private View v;

    public BuscaDadosWebService(Context contexto){
        this.contexto = contexto;

    }

    public BuscaDadosWebService(){

    }

    /*
        Na main thread nāo pode-se abrir conexao
        na thread secundaria nāo pode atualizar a GUI
     */

    protected void onPreExecute() {
        /*
            representa o código a ser execultado antes da thread inicializar
            EXECULTADO NA MAIN THREAD
        */

        Log.i("INFO", "Antes da thread");
    }

    @Override
    protected ArrayList<Carro> doInBackground(String... strings) {
        /*
            Método chamado durante a execuçao da thread
            realiza o processamento paralelo
            retorna um objeto qualquer que seja recebido
            pelo post execult
        */

        ArrayList<Carro> vetorCarros = null;
        Log.i("INFO", "Durante a thread");
        String jSon = "";
        Gson gson = new Gson();
        RecyclerView lista = null;

        try {
            OkHttpClient cliente = new OkHttpClient();
            Request requisicao = new Request.Builder().url(strings[0]).build();
            Response resposta = cliente.newCall(requisicao).execute();
            jSon = resposta.body().string();

            vetorCarros = gson.fromJson(jSon, new TypeToken<ArrayList<Carro>>() {
            }.getType());
        } catch (IOException e) {
            int error = 0;
        }
        return vetorCarros;
    }

    protected void onPostExecute(ArrayList<Carro> Carro) {
        /*
            Metodo chamado após a execucao da thread
            execulta na main thread
        */
        Log.i("INFO", "Depois da thread");


//        RecyclerView listaRecycleView = null;
//        listaRecycleView = (RecyclerView)v.findViewById(R.id.lista_Carros);
//        listaRecycleView.setItemAnimator(new DefaultItemAnimator());
//        listaRecycleView.setHasFixedSize(true);
//
//        CarroAdapter adapt = new CarroAdapter(contexto, Carro,);
//        listaRecycleView.setAdapter(adapt);
    }

}