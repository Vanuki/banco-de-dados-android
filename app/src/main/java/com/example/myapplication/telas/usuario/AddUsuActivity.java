package com.example.myapplication.telas.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerUsuario;
import com.example.myapplication.modelos.UsuarioBean;

public class AddUsuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_usu);
        final ControllerUsuario ge = new ControllerUsuario(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "****", Toast.LENGTH_LONG).show();
                EditText login  = (EditText) findViewById(R.id.login);
                EditText senha  = (EditText) findViewById((R.id.senha));
                EditText status = (EditText) findViewById(R.id.statusUsu);
                EditText tipo   = (EditText) findViewById(R.id.tipoUsu);

                String loginString = login.getText().toString();
                String senhaString = senha.getText().toString();
                String statusString = status.getText().toString();
                String tipoString = tipo.getText().toString();

                UsuarioBean usu = new UsuarioBean();
                usu.setId("");
                usu.setLogin(loginString);
                usu.setSenha(senhaString);
                usu.setStatus(statusString);
                usu.setTipo(tipoString);
                String msg = ge.inserir(usu);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
