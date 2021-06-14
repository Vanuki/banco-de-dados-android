package com.example.myapplication.telas.empresaDepartamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerEmpresaDepartamento;
import com.example.myapplication.modelos.EmpresaDepartamentoBean;

public class UptEmpresaDepartamentoActivity extends AppCompatActivity {

    Button uptEmpDep, delEmpDep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_empresa_departamento);
        final ControllerEmpresaDepartamento ge = new ControllerEmpresaDepartamento(getBaseContext());
        final EditText id_e = (EditText) findViewById(R.id.idEmp);
        final EditText id_d = (EditText) findViewById(R.id.idDep);
        final EditText obs = (EditText) findViewById(R.id.obs);
        Intent it = getIntent();
        final EmpresaDepartamentoBean recuperado = (EmpresaDepartamentoBean) it.getSerializableExtra("Empresa Departamento");
        id_e.setText(recuperado.getId_e());
        id_d.setText(recuperado.getId_d());
        obs.setText(recuperado.getObs());

        uptEmpDep = (Button) findViewById(R.id.btalterar);
        uptEmpDep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String id_e_string = id_e.getText().toString();
                String id_d_string = id_d.getText().toString();
                String obs_string = obs.getText().toString();
                recuperado.setId_e(id_e_string);
                recuperado.setId_d(id_d_string);
                recuperado.setObs(obs_string);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delEmpDep = (Button) findViewById(R.id.btexcluir);
        delEmpDep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}