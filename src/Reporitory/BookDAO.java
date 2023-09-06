package Reporitory;

import Enitities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {
    private Connection connection;

    public BookDAO(Connection connection){
        this.connection = connection;
    }
    public void AddBook(Book book){
        try {
            String sql = "INSERT INTO book(isbn,titre,statu,auteurid) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getIsbn());
            preparedStatement.setString(2,book.getTitre());
            preparedStatement.setString(3,book.getStatu());
            preparedStatement.setInt(4,book.getAuteurid());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book added successfully!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void UpdateBook(Book book){
        try {
            String sql = "UPDATE book SET titre=? , statu=? , auteurid=? WHERE isbn=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getTitre());
            preparedStatement.setString(2,book.getStatu());
            preparedStatement.setInt(3,book.getAuteurid());
            preparedStatement.setString(4,book.getIsbn());

            int rowsAffected = preparedStatement.executeUpdate();

//            System.out.println(rowsAffected);

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Data update failed.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
