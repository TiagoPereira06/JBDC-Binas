package pt.isel.adeetc.si1.model;

import java.sql.Date;

public class Passe_Utilizador {

    private int id, saldo;
    private String email, ref;
    private Date dt_reg, dt_aqui;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDt_reg() {
        return dt_reg;
    }

    public void setDt_reg(Date dt_reg) {
        this.dt_reg = dt_reg;
    }

    public Date getDt_aqui() {
        return dt_aqui;
    }

    public void setDt_aqui(Date dt_aqui) {
        this.dt_aqui = dt_aqui;
    }
}
