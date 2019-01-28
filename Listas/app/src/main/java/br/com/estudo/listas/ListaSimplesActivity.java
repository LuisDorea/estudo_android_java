package br.com.estudo.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaSimplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_simples);

        ListView lista = findViewById(R.id.lv_marcas_id);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.listaS_marcas,android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);
    }
}
