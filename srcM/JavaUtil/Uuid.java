package JavaUtil;

import java.util.UUID;

public class Uuid {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString().replace("-"," ");
        System.out.println(s);
    }
}
