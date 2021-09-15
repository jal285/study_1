package JavaUtil;

public class Smarty {
    private Smarty(){} //阻止实例的生成

    public static class SmartyLoader{
        private static final  Smarty instance = new Smarty();
    }

    public static Smarty getInstance(){
        //Inner class 的loading是在第一次被调用的时候
        return SmartyLoader.instance;
}
}
