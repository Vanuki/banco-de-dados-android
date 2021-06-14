package com.example.myapplication.telas.departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerDepartamento;
import com.example.myapplication.modelos.DepartamentoBean;

public class AddDepartamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_departamento);
        final ControllerDepartamento ge = new ControllerDepartamento(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btInserirDep);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "****", Toast.LENGTH_LONG).show();
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText data = (EditText) findViewById(R.id.data);
                EditText status = (EditText) findViewById(R.id.statusAdd);

                String nomeString = nome.getText().toString();
                String dataString = data.getText().toString();
                String statusString = status.getText().toString();

                DepartamentoBean dep = new DepartamentoBean();
                dep.setId("");
                dep.setNome(nomeString);
                dep.setData(dataString);
                dep.setStatus(statusString);
                String msg = ge.inserir(dep);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}