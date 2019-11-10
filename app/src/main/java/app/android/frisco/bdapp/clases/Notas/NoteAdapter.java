package app.android.frisco.bdapp.clases.Notas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.android.frisco.bdapp.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes){
        this.notes = notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView titulo;
        public TextView contenido;


        public ViewHolder(View itemView) {
            super(itemView);
            titulo =itemView.findViewById(R.id.titulo_txt);
            contenido =itemView.findViewById(R.id.contenido_txt);

        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notas, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, final int position) {
        final Note notes = this.notes.get(position);
        viewHolder.titulo.setText(notes.getTitulo());
        viewHolder.contenido.setText(notes.getContenido());

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

}

