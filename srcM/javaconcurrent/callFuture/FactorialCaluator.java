package javaconcurrent.callFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCaluator implements Callable<Integer> {
    private Integer number;     //Callable参数化接口

    public FactorialCaluator(Integer number){
        this.number = number;
    }
    @Override
    public Integer call() throws Exception {  //必须指出call()方法的返回的数据类型
        int result = 1;
        if((number==0)||(number==1)){
            result = 1;
        }else {
            for (int i=2;i<=number;i++){
                result *=i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.println( "Result for number -"+number + " -> " +result);
        return  result;
    }



}
