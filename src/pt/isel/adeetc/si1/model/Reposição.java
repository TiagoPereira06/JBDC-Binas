package pt.isel.adeetc.si1.model;

import java.sql.Date;

public class Reposição {

    private Date dt_ped, dt_rep;
    private int numRep, numFunc;

    public Reposição(Date dtPed, int num, int numFunc, Date dtRep){
        setDt_ped(dtPed);
        setNumRep(num);
        setNumFunc(numFunc);
        setDt_rep(dtRep);
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

    public int getNumRep() {
        return numRep;
    }

    public void setNumRep(int numRep) {
        this.numRep = numRep;
    }

    public int getNumFunc() {
        return numFunc;
    }

    public void setNumFunc(int numFunc) {
        this.numFunc = numFunc;
    }
}
