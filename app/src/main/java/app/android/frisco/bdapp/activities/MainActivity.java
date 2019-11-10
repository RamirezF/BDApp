package app.android.frisco.bdapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.android.frisco.bdapp.R;
import app.android.frisco.bdapp.clases.Usuarios.UserRepository;

public class MainActivity extends AppCompatActivity {

    Button registrar;
    Button ingresar;
    EditText usuario;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=findViewById(R.id.usuario_input);
        password=findViewById(R.id.password_input);
        registrar=findViewById(R.id.registrar_btn);
        ingresar=findViewById(R.id.ingresar_btn);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUsuario();
            }
        });


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingreso();
            }
        });

        loadLastUsername();
    }

    private void crearUsuario(){
        Intent intent=new Intent(this,RegistrarActivity.class);
        startActivity(intent);
    }

    private void ingreso(){
        String usu=usuario.getText().toString();
        String pass=password.getText().toString();

        for(int i=0; i<UserRepository.list().size();i++){
            if(usu.equals(UserRepository.read(i).getUsuario()) && pass.equals(UserRepository.read(i).getPassword())){
                String fullname=UserRepository.read(i).getFullname();
                // Guardar el estado de login en la SharedPreferences
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
                sp.edit()
                        .putBoolean("islogged", true)
                        .putString("username", fullname)
                        .commit();


                startActivity(new Intent(this, WelcomeActivity.class));
                finish();
            }else{
                Toast.makeText(this, "Usuario o contraseña incorrectas",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void loadLastUsername() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("username", null);
        if(username != null) {
            usuario.setText(username);
            password.requestFocus();
        }
    }

}
