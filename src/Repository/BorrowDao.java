package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import Enitities.Borrow;

public class BorrowDao {
    private static Connection connection;

    public BorrowDao(Connection connection){

        this.connection = connection;
    }

    public boolean CheckIsbn( String isbn){
        try {
            String sql = "SELECT * FROM books WHERE isbn=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean CheckBorrower(int NombreId){
        try{
            String sql ="SELECT * FROM borrowers WHERE nombreid=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,NombreId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public  boolean checkBorrow(int NombreId){
        try {
            String sql = "SELECT * FROM borrows WHERE borrowerid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,NombreId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void AddBorrow(Borrow borrow){
        try{
            String sql ="INSERT INTO borrows(bookid,borrowerid,datelivraison,datereturn) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,borrow.getIdBook());
            preparedStatement.setInt(2,borrow.getIdBorrower());
            preparedStatement.setDate(3, borrow.getDateLivraison());
            preparedStatement.setDate(4, borrow.getDateReturn());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\u001B[0mreservation request success!\u001B[1;32m");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void FindBorrow(Borrow borrow){
        try{
            String sql ="SELECT books.isbn, books.titre, borrowers.first_name, borrowers.last_name, borrowers.CIN,borrows.datelivraison,borrows.datereturn FROM books " +
                    "INNER JOIN borrows ON books.isbn = borrows.bookid " +
                    "INNER JOIN borrowers ON borrows.borrowerid = borrowers.nombreid";
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("\033[1;32m+------------+----------------------+------------------+------------------+---------------+---------------------+---------------------+");
            System.out.println("| ISBN       | Title                | First Name       | Last Name        | CIN           | Date Livraison      | Date Return         |");
            System.out.println("+------------+----------------------+------------------+------------------+---------------+---------------------+---------------------+\033[0m");

            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String bookTitle = resultSet.getString("titre");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String CIN = resultSet.getString("CIN");
                Date datelivraison = resultSet.getDate("datelivraison");
                Date datereturn = resultSet.getDate("datereturn");

                System.out.printf("| %-10s | %-20s | %-16s | %-16s | %-13s | %-19s | %-19s |\n",
                        isbn, bookTitle, firstName, lastName, CIN, datelivraison, datereturn);
            }

            System.out.println("\033[1;32m+------------+----------------------+------------------+------------------+---------------+---------------------+---------------------+\033[0m");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

