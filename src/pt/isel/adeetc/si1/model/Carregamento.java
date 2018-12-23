package pt.isel.adeetc.si1.model;

import java.sql.Date;

public class Carregamento {

    private int idPasse, valor;
    private Date dt_carr;

    public Carregamento(int id_Passe, Date dt_carr, int valor) {
        setIdPasse(id_Passe);
        setDt_carr(dt_carr);
        setValor(valor);
    }

    public int getIdPasse() {
        return idPasse;
    }

    public void setIdPasse(int idPasse) {
        this.idPasse = idPasse;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getDt_carr() {
        return dt_carr;
    }

    public void setDt_carr(Date dt_carr) {
        this.dt_carr = dt_carr;
    }
}
