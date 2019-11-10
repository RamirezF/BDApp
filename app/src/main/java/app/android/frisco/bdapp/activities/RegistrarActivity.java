package app.android.frisco.bdapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.android.frisco.bdapp.R;
import app.android.frisco.bdapp.clases.Usuarios.UserRepository;

public class RegistrarActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText fullname;
    private EditText email;
    private EditText password;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        usuario=findViewById(R.id.usuariotxt);
        fullname=findViewById(R.id.fullnametxt);
        email=findViewById(R.id.emailtxt);
        password=findViewById(R.id.passwordtxt);
        registrar=findViewById(R.id.regist_btn);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar();
            }
        });
    }

    public void agregar(){
        String usu=usuario.getText().toString();
        String full=fullname.getText().toString();
        String ema=email.getText().toString();
        String pass=password.getText().toString();

        if(usu.isEmpty()||ema.isEmpty()||full.isEmpty()||pass.isEmpty()){
            Toast.makeText(this,"Debe llenar todos los cuadros", Toast.LENGTH_SHORT).show();
        }else{
            UserRepository.create(usu,full,ema,pass);
            Toast.makeText(this,"Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }
}
