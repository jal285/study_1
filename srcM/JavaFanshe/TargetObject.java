package JavaFanshe;

public class TargetObject {
    private String value;

    public TargetObject(){
        value = "JavaGuide";
    }
    public void publicMethod(String s){
        System.out.println("I love " + s);
    }
    private void privateMehod(){
        System.out.println("value is :"+value);
    }

}
