package br.com.estudo.exemplorecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    public static ClickRecyclerInterface clickRecyclerInterface;
    Context ctx;
    private List<Aluno> listAlunos;

    public RecyclerAdapter(Context ctx, List<Aluno> listAlunos, ClickRecyclerInterface clickInterface) {
        this.ctx = ctx;
        this.listAlunos = listAlunos;
        this.clickRecyclerInterface = clickInterface;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_lista, viewGroup,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (RecyclerViewHolder viewHolder, int i) {
        Aluno aluno = listAlunos.get(i);

        viewHolder.viewNome.setText(aluno.getNome());
    }

    @Override
    public int getItemCount () {
        return listAlunos.size();
    }

    protected class RecyclerViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;

        public RecyclerViewHolder(final View itemView) {
            super(itemView);

            this.viewNome = (TextView) itemView.findViewById(R.id.tv_nome_id);

            //Configuração do ouvinte do click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerInterface.onCustomClick(listAlunos.get(getLayoutPosition()));
                }
            });
        }
    }
}
