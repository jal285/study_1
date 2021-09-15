package JavaJDBC;

import java.sql.*;

public class Jdbc_2 {
    public      int b;
    public      int a;
    public      String first;
    public      String  last;

    public Jdbc_2(int a, int b, String first, String last){
        this.a=a;
        this.b=b;
        this.first=first;
        this.last=last;
    }
    public static void main(String[] args) throws Exception{

        Connection con =  conn_test();
        System.out.println(con);
        //3. 获取执行SQL语句对象 (负责将SQL语句发送给数据库)
        Statement stat = con.createStatement(); // con.prepareStatement()，可以防sql注入,也可以预编译sql语句提高效率
        System.out.println(stat);
        String sql = "SELECT id, first, last, age FROM Employees";
        //4. 执行SQL语句获取结果集

       // Insert_test(a,b,first,last);
        // Select_data(sql);
        stat.close();
        con.close();
    }
    /**
        连接数据库方法静态私有，只能在本类中用，此只用在本测试类中，作为工具类还是应定为public static
     */
    public static Connection conn_test() throws ClassNotFoundException {
        //1. 注册驱动 (使用的是mysql还是oracle)
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接对象
        // 可以指定编码集 ?useUnicode=true&characterEncoding=utf8
        String username="root";
        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8";
        String password="root";
        Connection con=null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

    public  void Insert_test() throws ClassNotFoundException {

        Connection con=Jdbc_2.conn_test();
        Statement statement = null;
        System.out.println("设定a的变量值为"+a);
        try {
            statement=con.createStatement();
            System.out.printf("这里是satement处理sql语句");
            statement.execute("INSERT INTO employees(id,age,first,last)"+"VALUES('"+ a +"', '"+b +"','"+first +"','"+last+"')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public  void Select_data(String sql) throws ClassNotFoundException {


        Connection con=Jdbc_2.conn_test();
        Statement statement = null;
        try {
            statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(rs);
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);

        }
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
