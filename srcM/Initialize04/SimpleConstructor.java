package Initialize04;

class Rock{
    Rock(int i){
        System.out.println("Creating Rock: "+i);
    }
}

public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i<10; i++) {
            new Rock(i);  //创建对象，分配存储空间 构建起名字与类名完全相同
        }

    }
}
