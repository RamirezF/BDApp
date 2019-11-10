package app.android.frisco.bdapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import app.android.frisco.bdapp.R;
import app.android.frisco.bdapp.clases.Notas.Note;
import app.android.frisco.bdapp.clases.Notas.NoteAdapter;
import app.android.frisco.bdapp.clases.Notas.NoteRepository;
import app.android.frisco.bdapp.clases.Usuarios.User;
import app.android.frisco.bdapp.clases.Usuarios.UserRepository;

public class WelcomeActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private TextView usuario;
    private RecyclerView notasView;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        notasView=findViewById(R.id.note_list);
        usuario=findViewById(R.id.usuario);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("username", null);
        User user = UserRepository.findByUsername(username);

        usuario.setText(user.getFullname());

        id=user.getId();

        notasView.setLayoutManager(new LinearLayoutManager(this));
        List<Note> notee=NoteRepository.list();



    }

    // Mensaje de retorno
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegNotasActivity.class),REGISTER_FORM_REQUEST);
    }

}
