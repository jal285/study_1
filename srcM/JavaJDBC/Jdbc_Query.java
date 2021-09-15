package JavaJDBC;

import  java.sql.*;
import  java.util.ArrayList;
import  java.util.List;



public class Jdbc_Query {
    public static  List<Test> listTest1() throws Exception {
        List<Test> testList = new ArrayList<>();
        String URL = "jdbc:127.0.0.1:3306/test";
        String USER = "root";
        String PASS = "root";



//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error: unable to load driver class!");
//            System.exit(1);
//        }

        try {
            Class.forName("com.mysql.jdbc.Driver");;  // 将驱动程序的类文件动态加载到内存中
        } catch (ClassNotFoundException e) {
            System.out.println("Error: unable to load driver class!");
            e.printStackTrace();
            System.exit(1);
        }

//        }catch(IllegalAccessException e){
//            System.out.println("Error；access problem while loading!");  //三种异常 ，对相应 exit 1 ，2 ，3
//        }

            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            } catch (SQLException throwables) {
                System.out.printf("connection error");
                throwables.printStackTrace();
            }

            if (conn != null) {
                System.out.println("You made it, take control your database now!");
            } else {
                System.out.println("Failed to make connection!");

            }

            //获得java.sql.Statement 实例去执行SQL语句 Statement 分3中
//        1、执行静态SQL语句。通常通过Statement实例实现。
//        2、执行动态SQL语句。通常通过PreparedStatement实例实现。
//        3、执行数据库存储过程。通常通过CallableStatement实例实现。
       
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Employees");

            while (rs.next()) { //一次next()，遍历一行属性的值
                int id = rs.getInt("id"); // id
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                Test test = new Test(id, age, first, last);
                //  System.out.println(id +" "+age+ " " +first+" "+" "+last);
                // 前面的list调用是为了这一步将test对象中的数据集封装进testList中
                testList.add(test);
                //testList的创建是根据Test对象占用的空间  容器
            }

        } catch (SQLException e) {
            System.out.println("error ");
            System.out.print("Error : " +e.getMessage());
            e.printStackTrace();
        }

//        PreparedStatement pstmt = conn.prepareStatement(sql);  //动态sql语句
//
//        CallableStatement cstmt = conn.prepareCall("{CALL demoSP(?,?)}");

     //   int rows = stmt.executeUpdate("intsert itno ");
       // boolean flag = stmt.execute(String sql);
        return  testList;
    }
    public String getSql(String sql){

        return sql;
    }

    public static void main(String[] args) throws Exception {
      List<Test> testList = listTest1();
      for(Test list : testList){
          System.out.println(list);
      }
    }


    }