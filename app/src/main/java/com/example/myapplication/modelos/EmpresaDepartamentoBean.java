package com.example.myapplication.modelos;

import java.io.Serializable;

public class EmpresaDepartamentoBean implements Serializable {
    String id;
    String id_e;
    String id_d;
    String obs;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getId_e() { return id_e; }

    public void setId_e(String id_e) { this.id_e = id_e; }

    public String getId_d() { return id_d; }

    public void setId_d(String id_d) { this.id_d = id_d; }

    public String getObs() { return obs; }

    public void setObs(String obs) { this.obs = obs; }


    @Override
    public String toString() {
        return "EmpresaDepartamentoBean {" + "ID=" + id + ", ID DA EMPRESA=" + id_e + ", ID DO DEPARTAMENTO=" + id_d + ", OBSERVAÇÃO=" + obs + "}";
    }
}
