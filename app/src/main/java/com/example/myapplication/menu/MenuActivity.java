package com.example.myapplication.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.modelos.UsuarioBean;
import com.example.myapplication.telas.departamento.AddDepartamentoActivity;
import com.example.myapplication.telas.departamento.ListDepartamentoActivity;
import com.example.myapplication.telas.departamento.ListDepartamentoParamActivity;
import com.example.myapplication.telas.empresa.AddEmpresaActivity;
import com.example.myapplication.telas.empresa.ListEmpresaActivity;
import com.example.myapplication.telas.empresa.ListEmpresaParamActivity;
import com.example.myapplication.telas.empresaDepartamento.AddEmpresaDepartamentoActivity;
import com.example.myapplication.telas.empresaDepartamento.ListEmpresaDepartamentoActivity;
import com.example.myapplication.telas.empresaDepartamento.ListEmpresaDepartamentoParamActivity;
import com.example.myapplication.telas.usuario.AddUsuActivity;
import com.example.myapplication.telas.usuario.ListUsuActivity;
import com.example.myapplication.telas.usuario.ListUsuParamActivity;

public class MenuActivity extends AppCompatActivity {

    Button listUsu, listUsuPar, addUsu;
    Button listEmp, listEmpPar, addEmp;
    Button listDep, listDepPar, addDep;
    Button listEmpDep, listEmpDepPar, addEmpDep;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        Intent it = getIntent();
//        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
//        textUsuLogado.setText(usuLogado.getLogin());
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado);


        listUsu = (Button) findViewById(R.id.bt_listar_todos);
        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });

        listUsuPar = (Button) findViewById(R.id.bt_listar_parametro);
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });

        addUsu = (Button) findViewById(R.id.bt_novo);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });






        listEmp = (Button) findViewById(R.id.bt_listar_todos_emp);
        listEmp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListEmpresaActivity.class);
                startActivity(it);
            }
        });

        listEmpPar = (Button) findViewById(R.id.bt_listar_parametro_emp);
        listEmpPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListEmpresaParamActivity.class);
                startActivity(it);
            }
        });

        addEmp = (Button) findViewById(R.id.bt_novo_emp);
        addEmp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddEmpresaActivity.class);
                startActivity(it);
            }
        });






        listDep = (Button) findViewById(R.id.bt_listar_todos_dep);
        listDep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListDepartamentoActivity.class);
                startActivity(it);
            }
        });

        listDepPar = (Button) findViewById(R.id.bt_listar_parametro_dep);
        listDepPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListDepartamentoParamActivity.class);
                startActivity(it);
            }
        });

        addDep = (Button) findViewById(R.id.bt_novo_dep);
        addDep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddDepartamentoActivity.class);
                startActivity(it);
            }
        });






//        listEmpDep = (Button) findViewById(R.id.bt_listar_todos_emp_dep);
//        listEmpDep.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent it = new Intent(MenuActivity.this, ListEmpresaDepartamentoActivity.class);
//                startActivity(it);
//            }
//        });
//
//        listEmpDepPar = (Button) findViewById(R.id.bt_listar_parametro_emp_dep);
//        listEmpDepPar.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent it = new Intent(MenuActivity.this, ListEmpresaDepartamentoParamActivity.class);
//                startActivity(it);
//            }
//        });

//        addEmpDep = (Button) findViewById(R.id.bt_novo_emp_dep);
//        addEmpDep.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent it = new Intent(MenuActivity.this, AddEmpresaDepartamentoActivity.class);
//                startActivity(it);
//            }
//        });
    }
}