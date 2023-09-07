package Reporitory;

import Enitities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao {
    private Connection connection;

    public BookDao(Connection connection){
        this.connection = connection;
    }
    public void AddBook(Book book){
        try {
            String sql = "INSERT INTO book(isbn,titre,auteurid) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getIsbn());
            preparedStatement.setString(2,book.getTitre());
            preparedStatement.setInt(3,book.getAuteurid());
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
    public void DeleteBook(Book book){
        try{
        String sql ="DELETE FROM book WHERE isbn=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,book.getIsbn());
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Book Delete successfully.");
        } else {
            System.out.println("Book Delete failed.");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }
    public void FindDisponibleBook(Book book){
        try {
            String sql = "SELECT * FROM book WHERE statu = 'Disponible'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Disponible Books:");
            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String titre = resultSet.getString("titre");
                String statu = resultSet.getString("statu");
                int authorId = resultSet.getInt("auteurid");
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + titre);
                System.out.println("Status: " + statu);
                System.out.println("Author ID: " + authorId);
                System.out.println("--------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void  ChercherTitleBook(Book book){
        try {
            String sql ="SELECT isbn,titre,statu FROM book WHERE titre=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getTitre());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String isbn = resultSet.getString("isbn");
                String bookTitle = resultSet.getString("titre");
                String statu = resultSet.getString("statu");

                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + bookTitle);
                System.out.println("Status: " + statu);
                System.out.println("--------------");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ChercherAuteurBook(String firstName,String lastName ){
        try {
            String sql ="SELECT book.isbn, book.titre, book.statu, book.auteurid FROM book " +
                    "INNER JOIN auteur ON book.auteurid = auteur.id" +
                    " WHERE auteur.nom =? or auteur.prenom=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String isbn = resultSet.getString("isbn");
                String bookTitle = resultSet.getString("titre");
                String statu = resultSet.getString("statu");

                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + bookTitle);
                System.out.println("Status: " + statu);
                System.out.println("--------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void BookDisponible(){
        try {
            String sql= "SELECT count(*)  DisponibleBook From book WHERE statu='Disponible'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int query = resultSet.getInt("DisponibleBook");
                System.out.println("Book Disponible: " + query);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void BookEmprute(){
        try {
            String sql= "SELECT count(*)  EmprunteBook From book WHERE statu='emprunté'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int query = resultSet.getInt("EmprunteBook");
                System.out.println("Book Disponible: " + query);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
