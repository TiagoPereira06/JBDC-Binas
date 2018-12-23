package pt.isel.adeetc.si1.model;

public class Estação {

    private int id;
    private String Loc;

    public Estação(int id, String localização) {
        setId(id);
        setLoc(localização);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }
}
