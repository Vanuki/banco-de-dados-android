package com.example.myapplication.telas.empresa;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.myapplication.modelos.DepartamentoBean;
import com.example.myapplication.modelos.EmpresaBean;

import java.util.List;

public class AddEmpresaActivity extends AppCompatActivity {

    List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_empresa);
        final ControllerEmpresa ge = new ControllerEmpresa(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btInserirEmp);

        ControllerDepartamento cd = new ControllerDepartamento(getBaseContext());


        lista = cd.listarDepartamentosString();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        Spinner spinner = (Spinner) findViewById(R.id.s_emp);
        spinner.setAdapter(adapter);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "****", Toast.LENGTH_LONG).show();
                EditText cnpj = (EditText) findViewById(R.id.cnpjAdd);
                EditText tipo  = (EditText) findViewById(R.id.tipo);
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText data = (EditText) findViewById(R.id.data);
                EditText status = (EditText) findViewById(R.id.statusAdd);

                int id_d_String = spinner.getSelectedItemPosition();
                String cnpjString = cnpj.getText().toString();
                String tipoString = tipo.getText().toString();
                String nomeString = nome.getText().toString();
                String dataString = data.getText().toString();
                String statusString = status.getText().toString();

                EmpresaBean emp = new EmpresaBean();
                emp.setId("");
                emp.setCnpj(cnpjString);
                emp.setTipo(tipoString);
                emp.setNome(nomeString);
                emp.setData(dataString);
                emp.setStatus(statusString);
                emp.setId_d(id_d_String+1);
                String msg = ge.inserir(emp);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}