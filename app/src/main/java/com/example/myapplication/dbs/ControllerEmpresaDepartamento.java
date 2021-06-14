package com.example.myapplication.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.dbs.dao.BancoHelper;
import com.example.myapplication.modelos.EmpresaDepartamentoBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerEmpresaDepartamento {
    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerEmpresaDepartamento(Context context) {
        if (dbHelper == null) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(EmpresaDepartamentoBean empDep) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("ID_E", empDep.getId_e());
        valores.put("ID_D", empDep.getId_d());
        valores.put("OBS", empDep.getObs());
        resultado = db.insert(BancoHelper.TABELAEMPDEP, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(EmpresaDepartamentoBean empDep) {
        String retorno = "Resgistro Excluir com Sucesso";
        String where = "ID = " + empDep.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELAEMPDEP, where, null);
        db.close();
        return retorno;
    }

    public String alterar(EmpresaDepartamentoBean empDep) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + empDep.getId();
        valores = new ContentValues();
        valores.put("ID_E", empDep.getId_e());
        valores.put("ID_D", empDep.getId_d());
        valores.put("OBS", empDep.getObs());
        db.update(BancoHelper.TABELAEMPDEP, valores, where, null);
        db.close();
        return retorno;
    }

    public List<EmpresaDepartamentoBean> listarEmpresasDepartamentos() {
        List<EmpresaDepartamentoBean> empresasDepartamentos = new ArrayList<EmpresaDepartamentoBean>();
        String selectQuery = "SELECT * FROM EMP_DEP";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                EmpresaDepartamentoBean empDep = new EmpresaDepartamentoBean();
                empDep.setId("" + cursor.getInt(0));
                empDep.setId_e(cursor.getString(1));
                empDep.setId_d(cursor.getString(2));
                empDep.setObs(cursor.getString(3));
                empresasDepartamentos.add(empDep);
            } while (cursor.moveToNext());
        }
        return empresasDepartamentos;
    }

    public List<EmpresaDepartamentoBean> listarEmpresasDepartamentos(EmpresaDepartamentoBean empDepEnt) {
        List<EmpresaDepartamentoBean> empresasDepartamentos = new ArrayList<EmpresaDepartamentoBean>();
        String parametro = empDepEnt.getId_e();
        String selectQuery = "SELECT ID, ID_E, ID_D, OBS FROM EMP_DEP WHERE ID_E LIKE ?";
        String[] whereArgs = new String[]{"%" + parametro + "%"};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                EmpresaDepartamentoBean empDep = new EmpresaDepartamentoBean();
                empDep.setId("" + cursor.getInt(0));
                empDep.setId_e(cursor.getString(1));
                empDep.setId_d(cursor.getString(2));
                empDep.setObs(cursor.getString(3));
                empresasDepartamentos.add(empDep);
            } while (cursor.moveToNext());
        }
        return empresasDepartamentos;
    }

    public EmpresaDepartamentoBean validarEmpresasDepartamentos(EmpresaDepartamentoBean empDepEnt) {
        EmpresaDepartamentoBean empDep = new EmpresaDepartamentoBean();
        String id_e_par = '"' + empDepEnt.getId_e().trim() + '"';
        String id_d_par = '"' + empDepEnt.getId_d().trim() + '"';
        String selectQuery = "SELECT ID, ID_E, ID_D, OBS FROM EMP_DEP WHERE ID_E = ? AND ID_D = ? ";
        String[] whereArgs = new String[]{id_e_par, id_d_par};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        empDep.setId_e("0 = " + id_e_par + "1 = " + id_d_par);
        if (cursor.moveToFirst()) {
            do {
                empDep.setId("" + cursor.getInt(0));
                empDep.setId_e(cursor.getString(1));
                empDep.setId_d(cursor.getString(2));
                empDep.setObs(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return empDep;
    }

    public List<EmpresaDepartamentoBean> listarEmpresasTeste() {
        List<EmpresaDepartamentoBean> empresasDepartamentos = new ArrayList<EmpresaDepartamentoBean>();
        for (int i = 0; i < 10; i++) {
            EmpresaDepartamentoBean empDep = new EmpresaDepartamentoBean();
            empDep.setId(" Id " + i);
            empDep.setId_e(" ID_E " + i);
            empDep.setId_d(" ID_D " + i);
            empDep.setObs(" OBS " + i);
            empresasDepartamentos.add(empDep);
        }
        return empresasDepartamentos;
    }
}