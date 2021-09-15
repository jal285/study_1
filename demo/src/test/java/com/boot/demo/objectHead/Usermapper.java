package com.boot.demo.objectHead;

import com.boot.demo.mapper.UserMapper;
import com.boot.demo.pojo.Login_info;
import com.boot.demo.service.LoginHandle;
import com.boot.demo.util.SnowFlakeId;
import com.boot.demo.util.UrlProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;


/**
 * @author badpoone
 */
@SpringBootTest
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
public class Usermapper {
    @Autowired
    UserMapper usermapper;
    @Autowired
    UrlProperties urlProperties;
    @Autowired
    DataSource dataSource;
    @Autowired
    SnowFlakeId snowFlakeId;

    @Value("${test.inlcues}")
    private String inlcues;

    @Test
    public void test1() throws ParseException {
//        Date date = new Date();
//        Login_info info = new Login_info();
//        info.setId(2);
//        info.setName("test");
//        info.setPassword("test");
//        info.setSalt("acd");
//        info.setStatus(1);
//        info.setDatetime(new java.sql.Date(date.getYear(),date.getMonth(),date.getMonth()));
//        info.setUserId(2);
//        usermapper.insertName(info);
        System.out.println(usermapper.selectByName("123"));
    }

    @Test
    public  void test() throws ParseException{
        System.out.println(urlProperties.getWhiteList());
        System.out.println(inlcues);
    }

    @Test
    public void testdb() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void  testId(){
        System.out.println(snowFlakeId.nextId());
        System.out.println(snowFlakeId.nextId());
    }
}
