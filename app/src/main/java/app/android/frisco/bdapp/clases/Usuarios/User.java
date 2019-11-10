package app.android.frisco.bdapp.clases.Usuarios;

import com.orm.dsl.Table;

@Table
public class User {
    private long id;
    private String Usuario;
    private String Fullname;
    private String Email;
    private String password;

    public User() {
    }

    public User(String usuario, String fullname, String email, String password) {
        Usuario = usuario;
        Fullname = fullname;
        Email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
