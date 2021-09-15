package JavaJDBC;

import java.sql.*;

/**
 * @author badpoone
 */
public class Todb {
    static final String name="root";
    static final String password="root";
    static final String url="jdbc:mysql://localhost:3306/test";
    static final String Driver="com.mysql.jdbc.Driver";
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(url, name, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}

