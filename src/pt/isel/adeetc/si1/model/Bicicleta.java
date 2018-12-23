package pt.isel.adeetc.si1.model;

public class Bicicleta {

    private int id, peso, valorV, design;
    private float raio;

    public Bicicleta(int id, int peso, float raioRodas, int valorViagem, int design) {
        setId(id);
        setPeso(peso);
        setRaio(raioRodas);
        setValorV(valorViagem);
        setDesign(design);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValorV() {
        return valorV;
    }

    public void setValorV(int valorV) {
        this.valorV = valorV;
    }

    public int getDesign() {
        return design;
    }

    public void setDesign(int design) {
        this.design = design;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }
}
