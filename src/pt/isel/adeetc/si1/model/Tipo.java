package pt.isel.adeetc.si1.model;

public class Tipo {

    private String ref;
    private int numDias, preço;

    public Tipo(String ref, int num_dias, int preço){
        setRef(ref);
        setNumDias(num_dias);
        setPreço(preço);
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public int getPreço() {
        return preço;
    }

    public void setPreço(int preço) {
        this.preço = preço;
    }
}
