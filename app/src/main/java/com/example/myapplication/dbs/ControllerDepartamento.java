package com.example.myapplication.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.dbs.dao.BancoHelper;
import com.example.myapplication.modelos.DepartamentoBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerDepartamento {
    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerDepartamento(Context context) {
        if (dbHelper == null) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(DepartamentoBean dep) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", dep.getNome());
        valores.put("DATA", dep.getData());
        valores.put("STATUS", dep.getStatus());
        resultado = db.insert(BancoHelper.TABELADEP, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(DepartamentoBean dep) {
        String retorno = "Resgistro Excluir com Sucesso";
        String where = "ID_D = " + dep.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELADEP, where, null);
        db.close();
        return retorno;
    }

    public String alterar(DepartamentoBean dep) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID_D = " + dep.getId();
        valores = new ContentValues();
        valores.put("NOME", dep.getNome());
        valores.put("DATA", dep.getData());
        valores.put("STATUS", dep.getStatus());
        db.update(BancoHelper.TABELADEP, valores, where, null);
        db.close();
        return retorno;
    }

    public List<DepartamentoBean> listarDepartamentos() {
        List<DepartamentoBean> departamentos = new ArrayList<DepartamentoBean>();
        String selectQuery = "SELECT * FROM DEPARTAMENTOS";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DepartamentoBean dep = new DepartamentoBean();
                dep.setId("" + cursor.getInt(0));
                dep.setNome(cursor.getString(1));
                dep.setData(cursor.getString(2));
                dep.setStatus(cursor.getString(3));
                departamentos.add(dep);
            } while (cursor.moveToNext());
        }
        return departamentos;
    }

    public List<String> listarDepartamentosString() {
        List<String> departamentos = new ArrayList<String>();
        String selectQuery = "SELECT * FROM DEPARTAMENTOS";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                departamentos.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return departamentos;
    }

    public List<DepartamentoBean> listarDepartamentos(DepartamentoBean depEnt) {
        List<DepartamentoBean> departamentos = new ArrayList<DepartamentoBean>();
        String parametro = depEnt.getId();
        String selectQuery = "SELECT ID_D, NOME, DATA, STATUS FROM DEPARTAMENTOS WHERE ID_D LIKE ?";
        String[] whereArgs = new String[]{"%" + parametro + "%"};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                DepartamentoBean dep = new DepartamentoBean();
                dep.setId("" + cursor.getInt(0));
                dep.setNome(cursor.getString(1));
                dep.setData(cursor.getString(2));
                dep.setStatus(cursor.getString(3));
                departamentos.add(dep);
            } while (cursor.moveToNext());
        }
        return departamentos;
    }

    public DepartamentoBean validarDepartamentos(DepartamentoBean depEnt) {
        DepartamentoBean dep = new DepartamentoBean();
        String nomePar = '"' + depEnt.getNome().trim() + '"';
        String dataPar = '"' + depEnt.getData().trim() + '"';
        String selectQuery = "SELECT ID_D, NOME, DATA, STATUS FROM DEPARTAMENTOS WHERE NOME = ? AND DATA = ? ";
        String[] whereArgs = new String[]{nomePar, dataPar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        dep.setNome("0 = " + nomePar + "1 = " + dataPar);
        if (cursor.moveToFirst()) {
            do {
                dep.setId("" + cursor.getInt(0));
                dep.setNome(cursor.getString(1));
                dep.setData(cursor.getString(2));
                dep.setStatus(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return dep;
    }

    public List<DepartamentoBean> listarDepartamentosTeste() {
        List<DepartamentoBean> departamentos = new ArrayList<DepartamentoBean>();
        for (int i = 0; i < 10; i++) {
            DepartamentoBean dep = new DepartamentoBean();
            dep.setId(" Id " + i);
            dep.setNome(" Nome " + i);
            dep.setData(" Data " + i);
            dep.setStatus(" Status " + i);
            departamentos.add(dep);
        }
        return departamentos;
    }
}
