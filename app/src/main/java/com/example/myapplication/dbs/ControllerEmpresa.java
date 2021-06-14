package com.example.myapplication.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.dbs.dao.BancoHelper;
import com.example.myapplication.modelos.EmpresaBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerEmpresa {
    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerEmpresa(Context context) {
        if (dbHelper == null) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(EmpresaBean emp) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("CNPJ", emp.getCnpj());
        valores.put("TIPO", emp.getTipo());
        valores.put("NOME", emp.getNome());
        valores.put("DATA", emp.getData());
        valores.put("STATUS", emp.getStatus());
        valores.put("ID_D", emp.getId_d());
        resultado = db.insert(BancoHelper.TABELAEMP, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(EmpresaBean emp) {
        String retorno = "Resgistro Excluir com Sucesso";
        String where = "ID_E = " + emp.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELAEMP, where, null);
        db.close();
        return retorno;
    }

    public String alterar(EmpresaBean emp) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID_E = " + emp.getId();
        valores = new ContentValues();
        valores.put("CNPJ", emp.getCnpj());
        valores.put("TIPO", emp.getTipo());
        valores.put("NOME", emp.getNome());
        valores.put("DATA", emp.getData());
        valores.put("STATUS", emp.getStatus());
        valores.put("ID_D", emp.getId_d());
        db.update(BancoHelper.TABELAEMP, valores, where, null);
        db.close();
        return retorno;
    }

    public List<EmpresaBean> listarEmpresas() {
        List<EmpresaBean> empresas = new ArrayList<EmpresaBean>();
        String selectQuery = "SELECT * FROM EMPRESAS";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                EmpresaBean emp = new EmpresaBean();
                emp.setId("" + cursor.getInt(0));
                emp.setCnpj(cursor.getString(1));
                emp.setTipo(cursor.getString(2));
                emp.setNome(cursor.getString(3));
                emp.setData(cursor.getString(4));
                emp.setStatus(cursor.getString(5));
                emp.setId_d(cursor.getInt(6));
                empresas.add(emp);
            } while (cursor.moveToNext());
        }
        return empresas;
    }

    public List<EmpresaBean> listarEmpresas(EmpresaBean empEnt) {
        List<EmpresaBean> empresas = new ArrayList<EmpresaBean>();
        String parametro = empEnt.getCnpj();
        String selectQuery = "SELECT ID_E, CNPJ, TIPO, NOME, DATA, STATUS, ID_D FROM EMPRESAS WHERE CNPJ LIKE ?";
        String[] whereArgs = new String[]{"%" + parametro + "%"};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                EmpresaBean emp = new EmpresaBean();
                emp.setId("" + cursor.getInt(0));
                emp.setCnpj(cursor.getString(1));
                emp.setTipo(cursor.getString(2));
                emp.setNome(cursor.getString(3));
                emp.setData(cursor.getString(4));
                emp.setStatus(cursor.getString(5));
                emp.setId_d(cursor.getInt(6));
                empresas.add(emp);
            } while (cursor.moveToNext());
        }
        return empresas;
    }

    public EmpresaBean validarEmpresas(EmpresaBean empEnt) {
        EmpresaBean emp = new EmpresaBean();
        String cnpjPar = '"' + empEnt.getCnpj().trim() + '"';
        String tipoPar = '"' + empEnt.getTipo().trim() + '"';
        String selectQuery = "SELECT ID_E, CNPJ, TIPO, NOME, DATA, STATUS, ID_D FROM EMPRESAS WHERE CNPJ = ? AND TIPO = ? ";
        String[] whereArgs = new String[]{cnpjPar, tipoPar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        emp.setCnpj("0 = " + cnpjPar + "1 = " + tipoPar);
        if (cursor.moveToFirst()) {
            do {
                emp.setId("" + cursor.getInt(0));
                emp.setCnpj(cursor.getString(1));
                emp.setTipo(cursor.getString(2));
                emp.setNome(cursor.getString(3));
                emp.setData(cursor.getString(4));
                emp.setStatus(cursor.getString(5));
                emp.setId_d(cursor.getInt(6));
            } while (cursor.moveToNext());
        }
        return emp;
    }

    public List<EmpresaBean> listarEmpresasTeste() {
        List<EmpresaBean> empresas = new ArrayList<EmpresaBean>();
        for (int i = 0; i < 10; i++) {
            EmpresaBean emp = new EmpresaBean();
            emp.setId(" Id " + i);
            emp.setCnpj(" CNPJ " + i);
            emp.setTipo(" Tipo " + i);
            emp.setNome(" Nome " + i);
            emp.setData(" Data " + i);
            emp.setStatus(" Status " + i);
            empresas.add(emp);
        }
        return empresas;
    }
}
