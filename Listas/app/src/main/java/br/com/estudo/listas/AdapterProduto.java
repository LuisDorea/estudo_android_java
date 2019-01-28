package br.com.estudo.listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterProduto extends ArrayAdapter<Produto> {

    private final Context contexto;
    private final ArrayList<Produto> elementos;

    public AdapterProduto(Context context, ArrayList<Produto> elementos){
        super(context, R.layout.linha, elementos);
        this.contexto = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView tituloProduto = rowView.findViewById(R.id.titulo_prod_id);
        TextView descProd = rowView.findViewById(R.id.descri_prod_id);
        ImageView imgProd = rowView.findViewById(R.id.img_id);

        tituloProduto.setText(elementos.get(position).getTitulo());
        descProd.setText(elementos.get(position).getDescricao());
        imgProd.setImageResource(elementos.get(position).getImg());
        return rowView;
    }
}
