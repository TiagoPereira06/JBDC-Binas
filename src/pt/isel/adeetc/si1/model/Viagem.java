package pt.isel.adeetc.si1.model;

import java.sql.Timestamp;

public class Viagem {

    private String email, mens;
    private Timestamp dt_init;
    private Timestamp dt_fin;
    private int idEstInit, idEstDest, idBic;
    private short aval;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMens() {
        return mens;
    }

    public void setMens(String mens) {
        this.mens = mens;
    }

    public Timestamp getDt_init() {
        return dt_init;
    }

    public void setDt_init(Timestamp dt_init) {
        this.dt_init = dt_init;
    }

    public Timestamp getDt_fin() {
        return dt_fin;
    }

    public void setDt_fin(Timestamp dt_fin) {
        this.dt_fin = dt_fin;
    }

    public int getIdEstInit() {
        return idEstInit;
    }

    public void setIdEstInit(int idEstInit) {
        this.idEstInit = idEstInit;
    }

    public int getIdEstDest() {
        return idEstDest;
    }

    public void setIdEstDest(int idEstDest) {
        this.idEstDest = idEstDest;
    }

    public int getIdBic() {
        return idBic;
    }

    public void setIdBic(int idBic) {
        this.idBic = idBic;
    }

    public short getAval() {
        return aval;
    }

    public void setAval(short aval) {
        this.aval = aval;
    }
}
