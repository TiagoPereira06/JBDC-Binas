package pt.isel.adeetc.si1.model;

public class Elétrica {

    private int id;
    private float auto;

    public Elétrica(int id, float autonomia) {
        setId(id);
        setAuto(autonomia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAuto() {
        return auto;
    }

    public void setAuto(float auto) {
        this.auto = auto;
    }
}
