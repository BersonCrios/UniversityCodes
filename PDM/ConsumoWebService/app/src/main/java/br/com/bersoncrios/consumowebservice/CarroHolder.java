package br.com.bersoncrios.consumowebservice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CarroHolder extends RecyclerView.ViewHolder{
    ImageView item_imagem = null;
    TextView item_nome = null;
    TextView item_tipo = null;

    public CarroHolder(View view) {
        super(view);
        item_imagem = (ImageView) view.findViewById(R.id.item_imagem);
        item_nome = (TextView)view.findViewById(R.id.item_nome);
        item_tipo = (TextView) view.findViewById(R.id.item_tipo);
    }

    public ImageView getItem_imagem() {
        return item_imagem;
    }

    public void setItem_imagem(ImageView item_imagem) {
        this.item_imagem = item_imagem;
    }

    public TextView getItem_nome() {
        return item_nome;
    }

    public void setItem_nome(TextView item_nome) {
        this.item_nome = item_nome;
    }

    public TextView getItem_tipo() {
        return item_tipo;
    }

    public void setItem_tipo(TextView item_tipo) {
        this.item_tipo = item_tipo;
    }
}
