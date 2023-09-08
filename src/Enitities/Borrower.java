package Enitities;

public class Borrower {
    private int nombreId;
    private  String first_name;
    private String last_name;

    public Borrower(int nombreId, String first_name,String last_name) {
        this.nombreId = nombreId;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getNombreId() {
        return nombreId;
    }
    public void setNombreId(int nombreId) {
        this.nombreId = nombreId;
    }

   public String getFirst_name(){
        return first_name;
   }
   public String getLast_name(){
        return last_name;
   }
    public void setFirst_name(String firstName) {
        this.first_name=firstName;
    }
    public  void setLast_name(String lastName){
        this.last_name=lastName;
    }
}
