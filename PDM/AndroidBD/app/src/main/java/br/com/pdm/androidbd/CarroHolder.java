package br.com.pdm.androidbd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CarroHolder extends RecyclerView.ViewHolder{
    TextView item_nome = null;
    TextView item_placa = null;
    TextView item_ano = null;

    public CarroHolder(View view) {
        super(view);
        item_nome = (TextView) view.findViewById(R.id.item_carro_nome);
        item_placa = (TextView)view.findViewById(R.id.item_carro_placa);
        item_ano = (TextView) view.findViewById(R.id.item_carro_ano);
    }

    public TextView getItem_nome() {
        return item_nome;
    }

    public void setItem_nome(TextView item_nome) {
        this.item_nome = item_nome;
    }

    public TextView getItem_placa() {
        return item_placa;
    }

    public void setItem_placa(TextView item_placa) {
        this.item_placa = item_placa;
    }

    public TextView getItem_ano() {
        return item_ano;
    }

    public void setItem_ano(TextView item_ano) {
        this.item_ano = item_ano;
    }
}
