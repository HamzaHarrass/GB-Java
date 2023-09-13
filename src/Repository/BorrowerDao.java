package Repository;

import Enitities.Borrower;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BorrowerDao {
    private Connection connection;

    public BorrowerDao(Connection connection){
        this.connection = connection;
    }
    public  void AddBorrower(Borrower borrower){
        try {
            String sql ="INSERT INTO borrowers (first_name,CIN,last_name) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, borrower.getFirst_name());
            preparedStatement.setString(2,borrower.getCIN());
            preparedStatement.setString(3, borrower.getLast_name());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\u001B[1;32mBorrower added successfully!\u001B[0m");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void DeleteBorrower(Borrower borrower){
        try{
            String sql ="DELETE FROM borrowers WHERE CIN=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,borrower.getCIN());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\u001B[1;32mBorrower Delete successfully.\033[0m");
            } else {
                System.out.println("Borrower Delete failed.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
