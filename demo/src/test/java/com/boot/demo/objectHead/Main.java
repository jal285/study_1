package com.boot.demo.objectHead;

import com.boot.demo.pojo.User;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;


/**
 * @author badpoone
 */
public class Main {

    /**
     * 无锁态
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        User user  = new User();
        Object o1 = new Object();
        System.out.println(ClassLayout.parseInstance(user).toPrintable());

    }

    @Test
    public  void test02() throws Exception{
        Object lock = new Object();
        System.out.println("枷锁时");
        synchronized (lock){
            //
            String layout = ClassLayout.parseInstance(lock).toPrintable();
            System.out.println(layout);
        }

        System.out.println("*********************释放锁后*");
        String layout2 = ClassLayout.parseInstance(lock).toPrintable();
        System.out.println(layout2);
    }
    @Test
    public  void GCTest(){
        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[32000*1024];
        allocation2 = new byte[1000*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];
    }


}
