package br.com.estudo.exemplorecyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickRecyclerInterface{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    private List<Aluno> alunosListas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerView();

        setButtons();
        listenersButtons();
    }

    public void setRecyclerView() {

        //Aqui vamos instaciar o RecyclerView
        recyclerView = findViewById(R.id.rv_alunos_id);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(this, alunosListas,this);
        recyclerView.setAdapter(adapter);
    }

    public void setButtons(){
        floatingActionButton = findViewById(R.id.fab_adicionar_id);
    }

    /**
     * Aqui eu vou tratar o click em um item da lista
     * posso abrir uma outra tela ou apresentar uma mensagem
     */
    @Override
    public void onCustomClick(Object object) {

    }

    /**
     * Aqui eu trato o click do botão flutuante
     */
    public void listenersButtons(){

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //teste criando um aluno
                Aluno al1 = new Aluno();
                al1.setNome("Luis Dorea");

                //Aqui adiciono o aluno e aviso ao adapter que o conteudo mudou
                alunosListas.add(al1);
                adapter.notifyDataSetChanged();
            }
        });

    }

}
