package br.com.listagemalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.el_turma_id);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Turma 1");
        listDataHeader.add("Turma 2");
        listDataHeader.add("Turma 3");
        listDataHeader.add("Turma 4");

        List<String> alunosA = new ArrayList<>();
        alunosA.add("Samuel");
        alunosA.add("Luis");
        alunosA.add("Milene");

        List<String> alunosB = new ArrayList<>();
        alunosB.add("Mateus");
        alunosB.add("Larissa");

        List<String> alunosC = new ArrayList<>();
        alunosC.add("João");

        List<String> alunosD = new ArrayList<>();
        alunosD.add("Maria");

        listHashMap.put(listDataHeader.get(0),alunosA);
        listHashMap.put(listDataHeader.get(1),alunosB);
        listHashMap.put(listDataHeader.get(2),alunosC);
        listHashMap.put(listDataHeader.get(3),alunosD);
    }
}
