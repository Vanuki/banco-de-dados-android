package com.example.myapplication.telas.departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerDepartamento;
import com.example.myapplication.modelos.DepartamentoBean;

public class UptDepartamentoActivity extends AppCompatActivity {

    Button uptDep, delDep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_departamento);
        final ControllerDepartamento ge = new ControllerDepartamento(getBaseContext());
        final EditText nome = (EditText) findViewById(R.id.nomeDep);
        final EditText data = (EditText) findViewById(R.id.data);
        final EditText status = (EditText) findViewById(R.id.statusDep);
        Intent it = getIntent();
        final DepartamentoBean recuperado = (DepartamentoBean) it.getSerializableExtra("Departamento");
        nome.setText(recuperado.getNome());
        data.setText(recuperado.getData());
        status.setText(recuperado.getStatus());

        uptDep = (Button) findViewById(R.id.btalterar);
        uptDep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String dataString = data.getText().toString();
                String statusString = status.getText().toString();
                recuperado.setNome(nomeString);
                recuperado.setData(dataString);
                recuperado.setStatus(statusString);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delDep = (Button) findViewById(R.id.btexcluir);
        delDep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
