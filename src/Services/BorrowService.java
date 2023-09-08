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
        boolean valideNombre = false;
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();
        BorrowDao borrowDao = new BorrowDao(connection);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Book isbn: ");
        String isbn = scanner.nextLine();
        if (!borrowDao.CheckIsbn(isbn)) {
            System.out.println("THE BOOK NOT EXECUTE");
            return;
        }
        System.out.println("Enter Nombre Id Borrower: ");
        int NombreId = scanner.nextInt();
        if (!borrowDao.CheckBorrower(NombreId)){
            System.out.println("THE NOMBRE NOT EXECUTE");
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
}
