package com.example.myapplication.telas.empresaDepartamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerEmpresaDepartamento;
import com.example.myapplication.modelos.EmpresaDepartamentoBean;
import com.example.myapplication.telas.departamento.UptDepartamentoActivity;

import java.util.List;

public class ListEmpresaDepartamentoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeEmpresasDepartamentos;
    List<EmpresaDepartamentoBean> EmpresasDepartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_empresa_departamento);
        final ControllerEmpresaDepartamento ge = new ControllerEmpresaDepartamento(getBaseContext());
        ListaDeEmpresasDepartamentos = (ListView) findViewById(R.id.listaEmpDep);
        EmpresasDepartamentos = ge.listarEmpresasDepartamentos();
        ArrayAdapter<EmpresaDepartamentoBean> adapter = new ArrayAdapter<EmpresaDepartamentoBean>(this,android.R.layout.simple_list_item_1, EmpresasDepartamentos);
        ListaDeEmpresasDepartamentos.setAdapter(adapter);
        ListaDeEmpresasDepartamentos.setOnItemClickListener(this); // Clique no item
        ListaDeEmpresasDepartamentos.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        EmpresaDepartamentoBean empDep = (EmpresaDepartamentoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.empresaDepartamento.ListEmpresaDepartamentoActivity.this, UptEmpresaDepartamentoActivity.class);
        it.putExtra("Empresa Departamento", empDep);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + empDep.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        EmpresaDepartamentoBean empDep = (EmpresaDepartamentoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.empresaDepartamento.ListEmpresaDepartamentoActivity.this, UptEmpresaDepartamentoActivity.class);
        it.putExtra("Empresa Departamento", empDep);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + empDep.getId(),Toast.LENGTH_LONG).show();
    }
}