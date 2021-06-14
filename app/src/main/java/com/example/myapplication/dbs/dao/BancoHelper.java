package com.example.myapplication.dbs.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author ProfAlexandre
 */
public class BancoHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "RESGATFATEC.db";
    public static final String TABELAUSU = "USUARIOS";
    public static final String TABELAEMP = "EMPRESAS";
    public static final String TABELADEP = "DEPARTAMENTOS";
    public static final String TABELAEMPDEP = "EMP_DEP";


    private static final int VERSAO_SCHEMA = 17;
    private final String S_CREATEUSU;
    private final String S_CREATEEMP;
    private final String S_CREATEDEP;
    private final String S_CREATEEMPDEP;
    private final String S_FOREIGN_KEY;

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATEUSU = "CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,LOGIN TEXT,SENHA TEXT,STATUS TEXT,TIPO TEXT);";
        this.S_CREATEEMP = "CREATE TABLE EMPRESAS (ID_E INTEGER PRIMARY KEY AUTOINCREMENT,CNPJ TEXT,TIPO TEXT,NOME TEXT,DATA TEXT, STATUS TEXT, ID_D INTEGER);";
        this.S_CREATEDEP = "CREATE TABLE DEPARTAMENTOS (ID_D INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,DATA TEXT,STATUS TEXT);";
        this.S_CREATEEMPDEP = "CREATE TABLE EMP_DEP (ID INTEGER PRIMARY KEY AUTOINCREMENT,ID_E TEXT,ID_D TEXT,OBS TEXT);";
        this.S_FOREIGN_KEY = "ALTER TABLE EMPRESAS ADD FOREIGN_KEY ID_D REFERENCES DEPARTAMENTOS;";
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()){
            db.execSQL("pragma foreign_keys=ON");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATEUSU);
        db.execSQL(S_CREATEEMP);
        db.execSQL(S_CREATEDEP);
        db.execSQL(S_CREATEEMPDEP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELAUSU);
        db.execSQL("DROP TABLE IF EXISTS " + TABELAEMP);
        db.execSQL("DROP TABLE IF EXISTS " + TABELADEP);
        db.execSQL("DROP TABLE IF EXISTS " + TABELAEMPDEP);
        onCreate(db);
    }
}
