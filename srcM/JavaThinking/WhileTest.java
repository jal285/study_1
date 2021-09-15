package JavaThinking;

public class WhileTest {
    public static void main(String[] args) {
        double r=0;
        while(r<0.99d){   //while(布尔表达式)
            r = Math.random();
            System.out.printf("r");
        }
    } // while 和 do—while唯一区别为do-while至少会执行一次

}
