package  br.com.bersoncrios.consumowebservice;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

interface AdapterListener{
    public void celulaClicada(View view, int posicao, String latitude, String longituide);
}

public class CarroAdapter extends RecyclerView.Adapter<CarroHolder> {

    Context contexto = null;
    ArrayList<Carro> lista = null;
    AdapterListener listener;

    public CarroAdapter(Context contexto, ArrayList<Carro> lista,AdapterListener listener){
        this.contexto = contexto;
        this.lista = lista;
        this.listener = listener;
    }

    @Override
    public CarroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.celula_carro, parent, false);
        CarroHolder item  = new CarroHolder(celula);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull final CarroHolder holder, final int position) {
        final Carro item = lista.get(position);

        Picasso.with(contexto).load(item.getUrlFoto()).into(holder.getItem_imagem());
        holder.getItem_nome().setText(item.getNome());
        holder.getItem_tipo().setText(item.getTipo());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.celulaClicada(holder.itemView, position, item.getLatitude(), item.getLongitude());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (lista != null) ? lista.size() : 0;
    }
}