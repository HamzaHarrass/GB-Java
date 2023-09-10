package Enitities;


import java.util.List;



public class Book {
    private String isbn;

    private String titre;
    private String status;
    private int auteurid;
    private Auteur auteur;


    public Book(String isbn, String titre, String status, int auteurid) {
        this.isbn = isbn;
        this.titre = titre;
        this.status = status;
        this.auteurid = auteurid;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAuteurid() {
        return auteurid;
    }

    public void setAuteurid(int auteurid) {
        this.auteurid = auteurid;
    }
    
}


