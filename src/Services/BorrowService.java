package Services;

import Connection.DbConnection;
import Enitities.Borrow;
import Reporitory.BorrowDao;

import java.sql.Connection;
import java.util.Calendar;
import java.sql.Date;
import java.util.Scanner;

public class BorrowService {



    public static void AddBrrower() {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();
        BorrowDao borrowDao = new BorrowDao(connection);
        Scanner scanner = new Scanner(System.in);
        boolean validIsbn = false;
        String isbn = null;
        while (!validIsbn) {
            System.out.println("Enter Book ISBN: ");
            isbn = scanner.nextLine();
            if (!borrowDao.CheckIsbn(isbn)) {
                System.out.println("THE BOOK DOES NOT EXIST");
            } else {
                validIsbn = true;
            }
        }
        boolean valaideNombreId = false;
        int NombreId = 0;
        while (!valaideNombreId) {
            System.out.println("Enter Nombre Id Borrower: ");
            NombreId = scanner.nextInt();
            if (!borrowDao.CheckBorrower(NombreId)) {
                System.out.println("THE NOMBRE NOT EXECUTE");
            }else if (borrowDao.checkBorrow(NombreId)) {
                System.out.println("This borrower already has a book reserved.");
                return;
            }else {
                valaideNombreId = true;
            }
        }

        Calendar calendar = Calendar.getInstance();
        Date deliveryDate = new Date(calendar.getTime().getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date returnDate = new Date(calendar.getTime().getTime());//casting util whit sql
        Borrow borrow = new Borrow();
        borrow.setIdBook(isbn);
        borrow.setIdBorrower(NombreId);
        borrow.setDateLivraison(deliveryDate);
        borrow.setDateReturn(returnDate);
        borrowDao.AddBorrow(borrow);
    }

    public static void FindBorrow(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();
        BorrowDao borrowDao = new BorrowDao(connection);
        Borrow borrow = new Borrow();
        borrowDao.FindBorrow(borrow);
    }
}
