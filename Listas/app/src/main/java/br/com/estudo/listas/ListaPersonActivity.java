package br.com.estudo.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_person);

        ListView lista = findViewById(R.id.lv_produtos_id);
        ArrayAdapter adapterProd = new AdapterProduto(this, adicionarEscolas());
        lista.setAdapter(adapterProd);
    }

    private ArrayList<Produto> adicionarEscolas() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto prod = new Produto("Sashumi", "Muito gostoso", R.drawable.sashimi);
        produtos.add(prod);

        prod = new Produto("Sashimi 2",
                "Muito gostoso 2", R.drawable.sashimi);
        produtos.add(prod);

        prod = new Produto("Sashimi 3",
                "Novamente gostoso", R.drawable.sashimi);
        produtos.add(prod);

        prod = new Produto("Sashimi 4",
                "Repetitivo né!", R.drawable.sashimi);
        produtos.add(prod);

        return produtos;
    }
}
