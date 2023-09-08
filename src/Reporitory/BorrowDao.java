package Reporitory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                System.out.println("reservation request success!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

