//package demo.lombok;
//
//import jdk.nashorn.internal.objects.annotations.Getter;
//import jdk.nashorn.internal.objects.annotations.Setter;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.*;
//
//public class Example {
//
//    // @Getter / @Setter
//  //  @Setter(AccessLevel.PUBLIC)
//   // @Getter(AccessLevel.PROTECTED)
//    private int id;
//    private String shap;
//
//    public Example(int id, String shap) {
//        this.id = id;
//        this.shap = shap;
//    }
//
//    public static void main(String[] args) {
//        //val 示例
//        val sets = new HashSet<String>();
//        val lists = new ArrayList<String>();
//        val maps = new HashMap<String, String>();
//        // =>相当于如下
//        final Set<String >sets2 = new HashSet<>();
//        final List<String> list2 = new ArrayList<>();
//        final Map<String ,String> maps2 = new HashMap<>();
//
//
//        //@Cleanup示范
//        try {
//            @Cleanup InputStream inputStream = new FileInputStream (args[0]);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        //=>相当于
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(args[0]);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            if(inputStream != null){
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//
//
//    }
//    //@NonNull示例
////    //public void notNullExample(@NonNull String String){
////        String.length();
////    }
////    // =>相当于
////    public  void notNULLExample(String string){
////        if(string != null){
////            string.length();
////        }else{
////            throw new NullPointerException("null");
////        }
////    }
////
////
////}
