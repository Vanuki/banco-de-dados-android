package com.example.myapplication.telas.departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerDepartamento;
import com.example.myapplication.modelos.DepartamentoBean;

import java.util.List;

public class ListDepartamentoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeDepartamentos;
    List<DepartamentoBean> departamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_departamento);
        final ControllerDepartamento ge = new ControllerDepartamento(getBaseContext());
        ListaDeDepartamentos = (ListView) findViewById(R.id.listaDep);
        departamentos = ge.listarDepartamentos();
        ArrayAdapter<DepartamentoBean> adapter = new ArrayAdapter<DepartamentoBean>(this,android.R.layout.simple_list_item_1, departamentos);
        ListaDeDepartamentos.setAdapter(adapter);
        ListaDeDepartamentos.setOnItemClickListener(this); // Clique no item
        ListaDeDepartamentos.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        DepartamentoBean dep = (DepartamentoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.departamento.ListDepartamentoActivity.this, UptDepartamentoActivity.class);
        it.putExtra("Departamento", dep);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + dep.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        DepartamentoBean dep = (DepartamentoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.departamento.ListDepartamentoActivity.this, UptDepartamentoActivity.class);
        it.putExtra("Departamento", dep);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + dep.getId(),Toast.LENGTH_LONG).show();
    }
}