package pt.isel.adeetc.si1.model;

public class Funcionário {

    private int num;
    private String email;

    public Funcionário(int num, String email){
        setEmail(email);
        setNum(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
