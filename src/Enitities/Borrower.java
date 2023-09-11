package Enitities;

public class Borrower {
    private String CIN;
    private  String first_name;
    private String last_name;

    public Borrower(String CIN, String first_name,String last_name) {
        this.CIN = CIN;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Borrower() {

    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
