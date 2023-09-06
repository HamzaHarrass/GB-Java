package Enitities;

public class Borrower {
    private int nombreId;
    private String name;

    public Borrower(int nombreId, String name) {
        this.nombreId = nombreId;
        this.name = name;
    }

    public int getNombreId() {
        return nombreId;
    }

    public void setNombreId(int nombreId) {
        this.nombreId = nombreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
