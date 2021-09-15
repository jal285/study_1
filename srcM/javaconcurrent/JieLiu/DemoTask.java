package javaconcurrent.JieLiu;

public class DemoTask implements Runnable{
    public  String name = null;

    public  DemoTask(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Executing : "+ name);
    }
}
