package pt.isel.adeetc.si1.model;

import java.sql.Date;

public class Pedido_Reposição {

    private Date dt_ped, dt_rep;
    private int idEst;

    public Pedido_Reposição(Date dataPed, int idEst, Date dataRep) {
        setDt_ped(dataPed);
        setIdEst(idEst);
        setDt_rep(dataRep);
    }

    public Date getDt_ped() {
        return dt_ped;
    }

    public void setDt_ped(Date dt_ped) {
        this.dt_ped = dt_ped;
    }

    public Date getDt_rep() {
        return dt_rep;
    }

    public void setDt_rep(Date dt_rep) {
        this.dt_rep = dt_rep;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }
}
