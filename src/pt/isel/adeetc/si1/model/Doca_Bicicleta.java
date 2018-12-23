package pt.isel.adeetc.si1.model;

public class Doca_Bicicleta {

    private int idBic, idEst, numDoca;

    public Doca_Bicicleta(int idBic, int idEst, int numDoca) {
        setIdBic(idBic);
        setIdEst(idEst);
        setNumDoca(numDoca);
    }

    public int getIdBic() {
        return idBic;
    }

    public void setIdBic(int idBic) {
        this.idBic = idBic;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public int getNumDoca() {
        return numDoca;
    }

    public void setNumDoca(int numDoca) {
        this.numDoca = numDoca;
    }
}
