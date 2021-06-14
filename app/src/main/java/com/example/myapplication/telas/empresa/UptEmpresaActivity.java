package com.example.myapplication.telas.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerDepartamento;
import com.example.myapplication.dbs.ControllerEmpresa;
import com.example.myapplication.modelos.EmpresaBean;

import java.util.List;

public class UptEmpresaActivity extends AppCompatActivity {

    Button uptEmp, delEmp;
    List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_empresa);
        final ControllerEmpresa ge = new ControllerEmpresa(getBaseContext());
        final EditText cnpj = (EditText)findViewById(R.id.cnpjUpt);
        final EditText tipo = (EditText)findViewById((R.id.tipoEmp));
        final EditText nome = (EditText)findViewById(R.id.nome);
        final EditText data = (EditText)findViewById(R.id.data);
        final EditText status = (EditText)findViewById(R.id.statusEmp);

        ControllerDepartamento cd = new ControllerDepartamento(getBaseContext());

        lista = cd.listarDepartamentosString();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        Spinner spinner = (Spinner) findViewById(R.id.s_id_d_upt);
        spinner.setAdapter(adapter);

        Intent it = getIntent();
        final EmpresaBean recuperado = (EmpresaBean) it.getSerializableExtra("Empresa");
        cnpj.setText(recuperado.getCnpj());
        tipo.setText(recuperado.getTipo());
        nome.setText(recuperado.getNome());
        data.setText(recuperado.getData());
        status.setText(recuperado.getStatus());
        spinner.setSelection(recuperado.getId_d()-1);



        uptEmp = (Button) findViewById(R.id.btalterar);
        uptEmp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String cnpjString = cnpj.getText().toString();
                String tipoString = tipo.getText().toString();
                String nomeString = nome.getText().toString();
                String dataString = data.getText().toString();
                String statusString = status.getText().toString();
                recuperado.setCnpj(cnpjString);
                recuperado.setTipo(tipoString);
                recuperado.setNome(nomeString);
                recuperado.setData(dataString);
                recuperado.setStatus(statusString);
                recuperado.setId_d(spinner.getSelectedItemPosition()+1);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delEmp = (Button) findViewById(R.id.btexcluir);
        delEmp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}