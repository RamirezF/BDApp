package app.android.frisco.bdapp.clases.Notas;

import com.orm.dsl.Table;

@Table
public class Note {
    private long id;
    private String Titulo;
    private String Contenido;
    private long id_user;

    public Note() {
    }

    public Note(long id_user, String titulo, String contenido) {
        this.Titulo = titulo;
        this.Contenido = contenido;
        this.id_user = id_user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
}
