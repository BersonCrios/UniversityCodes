package  br.com.pdm.androidbd;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

public class CarroAdapter extends RecyclerView.Adapter<CarroHolder> {

    Context contexto = null;
    ArrayList<Carro> lista = null;
    public CarroAdapter(Context contexto, ArrayList<Carro> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public CarroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.item_carro, parent, false);
        CarroHolder item  = new CarroHolder(celula);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull CarroHolder holder, int position) {
        Carro item = lista.get(position);

        holder.getItem_nome().setText(item.getNome());
        holder.getItem_placa().setText(item.getPlaca());
        holder.getItem_ano().setText(item.getAno());
    }

    @Override
    public int getItemCount() {
        return (lista != null) ? lista.size() : 0;
    }
}