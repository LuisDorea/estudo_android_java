package br.com.estudo.listas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btListaS;
    private Button btListaPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btListaS = findViewById(R.id.bt_listaS_id);
        btListaPerson= findViewById(R.id.bt_listaPerson_id);

        btListaS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(getBaseContext(),ListaSimplesActivity.class);
                startActivity(intencao);
            }
        });

        btListaPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(getBaseContext(),ListaPersonActivity.class);
                startActivity(intencao);
            }
        });
    }
}
