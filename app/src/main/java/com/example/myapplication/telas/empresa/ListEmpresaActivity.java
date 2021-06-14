package com.example.myapplication.telas.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dbs.ControllerEmpresa;
import com.example.myapplication.modelos.EmpresaBean;

import java.util.List;

public class ListEmpresaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeEmpresas;
    List<EmpresaBean> empresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_empresa);
        final ControllerEmpresa ge = new ControllerEmpresa(getBaseContext());
        ListaDeEmpresas = (ListView) findViewById(R.id.listaEmp);
        empresas = ge.listarEmpresas();
        ArrayAdapter<EmpresaBean> adapter = new ArrayAdapter<EmpresaBean>(this,android.R.layout.simple_list_item_1, empresas);
        ListaDeEmpresas.setAdapter(adapter);
        ListaDeEmpresas.setOnItemClickListener(this); // Clique no item
        ListaDeEmpresas.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        EmpresaBean emp = (EmpresaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.empresa.ListEmpresaActivity.this, UptEmpresaActivity.class);
        it.putExtra("Empresa", emp);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + emp.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        EmpresaBean emp = (EmpresaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.empresa.ListEmpresaActivity.this, UptEmpresaActivity.class);
        it.putExtra("Empresa", emp);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + emp.getId(),Toast.LENGTH_LONG).show();
    }
}