package JavaJDBC;

import java.sql.Connection;

/**
 * @author badpoone
 */
public class test_Jdbc2 {
    public static void main(String[] args) {
        Jdbc_2 jdbc_2= new Jdbc_2(11,10,"aaa","dafa");
        String sql = "SELECT id, first, last, age FROM Employees";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            jdbc_2.Insert_test();
            jdbc_2.Select_data(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
