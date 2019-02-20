package br.com.testeorientacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtNomes;
    ArrayList<String> aLNomes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNomes = findViewById(R.id.edt_nome_id);

        if (savedInstanceState != null){
            aLNomes = savedInstanceState.getStringArrayList("nomes");
        }else{
            aLNomes = new ArrayList<String>();
        }

        ListView listaNomes = findViewById(R.id.lv_nomes_id);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,aLNomes);

        listaNomes.setAdapter(adapter);
    }

    public void meuBotaoClick(View view){
        aLNomes.add(edtNomes.getText().toString());
        edtNomes.setText("");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("nomes", aLNomes);
    }
}
