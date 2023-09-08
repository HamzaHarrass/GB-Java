package Enitities;

import java.sql.Date;

public class Borrow {
    private int borrowerid;
    private String bookid;
    private Date dateLivraison;
    private Date dateReturn;
    private Borrow borrow;
    private Borrower borrower;

    public Borrow(int borrowerid, String bookid, Date dateLivraison, Date dateReturn) {
        this.borrowerid=borrowerid;
        this.bookid=bookid;
        this.dateLivraison = dateLivraison;
        this.dateReturn = dateReturn;
    }

    public Borrow() {
    }

    public int getIdBorrower() {
        return borrowerid;
    }

    public void setIdBorrower(int idBorrower) {
        this.borrowerid = idBorrower;
    }

    public String getIdBook() {
        return bookid;
    }

    public void setIdBook(String idBook) {
        this.bookid = idBook;
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
