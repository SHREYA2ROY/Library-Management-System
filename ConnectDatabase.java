import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectDatabase{
    public static void main(String[] args){
        Connection conn = null;
        try{
            String dbUrl = "jdbc:mysql://localhost:3306/library";
            String userName = "root";
            String password = "R@NiLOVesOscAr2002";
            conn = DriverManager.getConnection(dbUrl,userName,password);
            System.out.println("Database connection established");
        }
        catch(SQLException e){
            System.err.println("Cannot connect to database:"+e.getMessage());
        }
        finally{
            try{
                if(conn!= null){
                    conn.close();
                    System.out.println("Database connection terminated");
                }
            }catch(SQLException e){
                System.err.println("Error closing databe connection:"+e.getMessage());

            }
        }
    }
}

