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
}
