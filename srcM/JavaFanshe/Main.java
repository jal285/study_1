package JavaFanshe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取TargetObejct类的对象并创建TargetObject实例
        Class<?> targetclass = Class.forName("JavaFanshe.TargetObject");
        TargetObject targetObject = (TargetObject) targetclass.newInstance();
        //获取类中所有方法
        Method[]methods = targetclass.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());
        }
        //获取指定方法并调用
        Method publicMehod = targetclass.getDeclaredMethod("publicMethod", String.class);

        publicMehod.invoke(targetObject,"javaGuide");
        //获取指定参数并对参数进行修改
        //Field 类获取对象的属性
        Field field = targetclass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject,"JavaGuide");

        //调用private方法
        Method privateMethod = targetclass.getDeclaredMethod("privateMehod");
        //为了调用private方法取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);




    }
}
