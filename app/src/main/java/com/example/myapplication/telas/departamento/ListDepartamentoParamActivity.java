package com.example.myapplication.telas.departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerDepartamento;
import com.example.myapplication.modelos.DepartamentoBean;

import java.util.List;

public class ListDepartamentoParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeDepartamentos;
    List<DepartamentoBean> departamentos;
    Button pesqDep;
    ArrayAdapter<DepartamentoBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_departamento_param);
        final Context con = getBaseContext();
        final ControllerDepartamento ge = new ControllerDepartamento(con);
        ListaDeDepartamentos = (ListView) findViewById(R.id.listaDepParam);
        ListaDeDepartamentos.setOnItemClickListener(this); // Clique no item
        ListaDeDepartamentos.setOnItemLongClickListener(this); //
        final EditText nome = (EditText)findViewById(R.id.nomeList);

        pesqDep = (Button) findViewById(R.id.btPesquisarDep);
        pesqDep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                DepartamentoBean dep = new DepartamentoBean();
                dep.setId(nomeString);
                departamentos = ge.listarDepartamentos(dep);
                adapter = new ArrayAdapter<DepartamentoBean>(con,android.R.layout.simple_list_item_1, departamentos);
                ListaDeDepartamentos.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        DepartamentoBean dep = (DepartamentoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.departamento.ListDepartamentoParamActivity.this, UptDepartamentoActivity.class);
        it.putExtra("Departamento", dep);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + dep.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        DepartamentoBean dep = (DepartamentoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.departamento.ListDepartamentoParamActivity.this, UptDepartamentoActivity.class);
        it.putExtra("Departamento", dep);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + dep.getId(),Toast.LENGTH_LONG).show();
    }
}