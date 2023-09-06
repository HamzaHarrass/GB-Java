package Enitities;

import java.util.Date;

public class Borrow {
    private int idBorrower;
    private int idBook;
    private Date dateLivraison;
    private Date dateReturn;
    private Borrow borrow;
    private Borrower borrower;

    public Borrow(int idBorrower, int idBook, Date dateLivraison, Date dateReturn) {
        this.idBorrower = idBorrower;
        this.idBook = idBook;
        this.dateLivraison = dateLivraison;
        this.dateReturn = dateReturn;
    }

    public Borrow() {
    }

    public int getIdBorrower() {
        return idBorrower;
    }

    public void setIdBorrower(int idBorrower) {
        this.idBorrower = idBorrower;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }
}
