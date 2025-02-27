import java.sql.*;

public class Conn {

    Connection c;
    Statement s ;

    Conn ()
    {
        try{
//            register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//            connecting database with driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "MySQL");
//            create statement
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
