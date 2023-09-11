package Services;

import Connection.DbConnection;
import Enitities.Book;
import Enitities.Borrower;
import Reporitory.BookDao;
import Reporitory.BorrowerDao;

import java.sql.Connection;
import java.util.Scanner;

public class BoorrowerService {
    public static void AddBorrower(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name : ");
        String firstName = scanner.nextLine();
        System.out.println("Entre Last Name : ");
        String lastName = scanner.nextLine();
        System.out.println("Entre CIN : ");
        String cin = scanner.nextLine();
        Borrower borrower = new Borrower();
        borrower.setFirst_name(firstName);
        borrower.setLast_name(lastName);
        borrower.setCIN(cin);
        BorrowerDao borrowerDao = new BorrowerDao(connection);
        borrowerDao.AddBorrower(borrower);
    }
    public static void DeleteBorrower(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CIN Borrower to DELETE: ");
        String CIN = scanner.nextLine();
        Borrower borrower = new Borrower();
        borrower.setCIN(CIN);
        BorrowerDao borrowerDao = new BorrowerDao(connection);
        borrowerDao.DeleteBorrower(borrower);
    }
}
