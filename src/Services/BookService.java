package Services;

import Enitities.Book;
import Reporitory.BookDao;
import Connection.DbConnection;

import java.sql.Connection;
import java.util.Scanner;

public class BookService {
    public static void AddBook(){

        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();

        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter book isbn: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter book titre: ");
        String titre = scanner.nextLine();
        System.out.print("Enter book auteurid: ");
        int authorid = scanner.nextInt();
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitre(titre);
        book.setAuteurid(authorid);
        BookDao bookDAO = new BookDao(connection);
        bookDAO.AddBook(book);
    }
    public static void UpdateBook(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book isbn to update: ");
        String ISBN = scanner.nextLine();
        System.out.println("Enter the new book titre: ");
        String NewTitle = scanner.nextLine();
        System.out.println("Entre the new status");
        String NewStatus = scanner.nextLine();
        System.out.println("Entre the new auteurId");
        int NewAuteurId = scanner.nextInt();
        Book book = new Book();
        book.setIsbn(ISBN);
        book.setTitre(NewTitle);
        book.setStatu(NewStatus);
        book.setAuteurid(NewAuteurId);

        BookDao bookDAO = new BookDao(connection);
        bookDAO.UpdateBook(book);
    }
    public static void DeleteBook(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book isbn to DELETE: ");
        String isbn = scanner.nextLine();
        Book book = new Book();
        book.setIsbn(isbn);
        BookDao bookDAO = new BookDao(connection);
        bookDAO.DeleteBook(book);
    }
    public static void FindBook(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.conn();
        Book book = new Book();
        BookDao bookDao = new BookDao(connection);
        bookDao.FindDisponibleBook(book);
    }
}
