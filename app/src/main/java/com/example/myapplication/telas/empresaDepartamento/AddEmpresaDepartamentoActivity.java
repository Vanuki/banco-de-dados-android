package com.example.myapplication.telas.empresaDepartamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerEmpresaDepartamento;
import com.example.myapplication.modelos.EmpresaDepartamentoBean;

public class AddEmpresaDepartamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_empresa_departamento);
        final ControllerEmpresaDepartamento ge = new ControllerEmpresaDepartamento(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btInserirEmpDep);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "****", Toast.LENGTH_LONG).show();
                EditText nome = (EditText) findViewById(R.id.idEmp);
                EditText data = (EditText) findViewById(R.id.idDep);
                EditText status = (EditText) findViewById(R.id.obs);

                String id_e_string = nome.getText().toString();
                String id_d_string = data.getText().toString();
                String obs_string = status.getText().toString();

                EmpresaDepartamentoBean empDep = new EmpresaDepartamentoBean();
                empDep.setId("");
                empDep.setId_e(id_e_string);
                empDep.setId_d(id_d_string);
                empDep.setObs(obs_string);
                String msg = ge.inserir(empDep);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}