package com.example.myapplication.telas.empresa;

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
import com.example.myapplication.modelos.EmpresaBean;
import com.example.myapplication.dbs.ControllerEmpresa;

import java.util.List;

public class ListEmpresaParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeEmpresas;
    List<EmpresaBean> empresas;
    Button pesqEmp;
    ArrayAdapter<EmpresaBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_empresa_param);
        final Context con = getBaseContext();
        final ControllerEmpresa ge = new ControllerEmpresa(con);
        ListaDeEmpresas = (ListView) findViewById(R.id.listaEmpParam);
        ListaDeEmpresas.setOnItemClickListener(this); // Clique no item
        ListaDeEmpresas.setOnItemLongClickListener(this); //
        final EditText cnpj = (EditText) findViewById(R.id.cnpjList);

        pesqEmp = (Button) findViewById(R.id.btPesquisarEmp);
        pesqEmp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String cnpjString = cnpj.getText().toString();
                EmpresaBean emp = new EmpresaBean();
                emp.setCnpj(cnpjString);
                empresas = ge.listarEmpresas(emp);
                adapter = new ArrayAdapter<EmpresaBean>(con, android.R.layout.simple_list_item_1, empresas);
                ListaDeEmpresas.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        EmpresaBean emp = (EmpresaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.empresa.ListEmpresaParamActivity.this, UptEmpresaActivity.class);
        it.putExtra("Empresa", emp);
        startActivity(it);
        Toast.makeText(getApplicationContext(), "Item Pressionado :-" + position + " ID= " + emp.getId(), Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        EmpresaBean emp = (EmpresaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(com.example.myapplication.telas.empresa.ListEmpresaParamActivity.this, UptEmpresaActivity.class);
        it.putExtra("Empresa", emp);
        startActivity(it);
        Toast.makeText(getApplicationContext(), "Item Click :-" + position + " ID= " + emp.getId(), Toast.LENGTH_LONG).show();
    }
}