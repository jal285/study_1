package NewKe;

import java.util.Scanner;

public class IntFloat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        float a= scan.nextFloat();    //hasNext() 检测还有没有下一个输入  next()指针移动到当前下标，并取出下一个输入

        System.out.println((int)(a+0.5));
    }
}
