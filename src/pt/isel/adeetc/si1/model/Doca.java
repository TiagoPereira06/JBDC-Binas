package pt.isel.adeetc.si1.model;

public class Doca {

    private int idEst, num;
    private String estado;

    public Doca(int idEstação, int numDoca, String estado){
        setIdEst(idEstação);
        setNum(numDoca);
        setEstado(estado);
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
