package app.android.frisco.bdapp.clases.Notas;

import com.orm.SugarRecord;

import java.util.List;

public class NoteRepository {
    public static List<Note> list(){
        List<Note> notes= SugarRecord.listAll(Note.class);
        return notes;
    }

    public static void create(long iduser, String titulo, String contenido){
        Note user=new Note(iduser, titulo, contenido);
        SugarRecord.save(user);
    }
}
