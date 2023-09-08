package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public Connection conn(){
        Connection con =null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gb","root","");
            //System.out.println("");
        }catch (Exception e){
            e.printStackTrace();
            //System.out.println("Error de connection");
        }
        return con;
    }
}
