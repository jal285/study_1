package JavaThinking;

public class Overflow {
    public static void main(String[] args) {
        int big = 0x7fffffff; //max int value
        System.out.println("big = "+ big);
        int bigger = big*4;
        System.out.println("bigger= "+bigger); //overflow
    }

    static void prt(String s){
        System.out.println(s);
    }

    public void method(){
        return;
    }
}

class   A{

}

