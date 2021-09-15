package JavaUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample { // 日历
    public static void main(String[] args) {

        //Calendar为抽象类
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);

        //获取当前时间， 相当于 Date date = new Date();
        Date time = instance.getTime();
        System.out.println("time now: "+ time );

        //将日期Date转成Calendar
        instance.setTime(new Date());
        System.out.println("当前时间Calendat: "+ instance);


        System.out.println("==========分割线==========");
        //注意：设置日期是月份需要减1
        instance.set(2021,3-1,28);
        System.out.println("自定义时间年月日："+ instance.getTime());

        //通过set(int field,int value)给指定的属性赋值，我们常用的属性
        instance.set(Calendar.YEAR,2021);
        //Calendar.MONTH 实际月份比设置月份1大一
        instance.set(Calendar.MONTH,4-1);
        instance.set(Calendar.DATE,28);
        //Calendat.HOUR实际时间比设置的时间超出12小时，
        instance.set(Calendar.HOUR_OF_DAY,3);
        //  instance.set(Calendar.MINUTE,36);
        //  instance.set(Calendar.SECOND,50);
        //不定义Calendat的分钟和秒时会自动获取系统时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(instance.getTime());
        System.out.println("分别自定义年月日时分秒： "+format);

        System.out.println("===========");
        //通过field 获取对应value 值
        Calendar instance3=Calendar.getInstance();
        System.out.println(instance3.get(Calendar.YEAR));
        System.out.println(instance3.get(Calendar.MONTH-1));
        System.out.println(instance3.get(Calendar.DATE));
        System.out.println(instance3.get(Calendar.HOUR_OF_DAY));
        System.out.println(instance3.get(Calendar.MINUTE));
        System.out.println(instance3.get(Calendar.SECOND));
        System.out.println(instance3.get(Calendar.DAY_OF_WEEK));
        System.out.println(instance3.get(Calendar.WEEK_OF_MONTH));
        System.out.println(instance3.get(Calendar.WEEK_OF_YEAR));

        System.out.println("=========");
        //两个日期比较，如果小于零，则调用对象比指定对象早，反之晚，等于0则两个时间相同
        Calendar instance1 = Calendar.getInstance();
        instance1.set(2021,4-1,29);
        int i = instance.compareTo(instance1);
        if(i>0){
            System.out.println(instance.getTime()+"比 "+instance1.getTime()+"晚");
        }else if(i<0) {
            System.out.println(instance.getTime() + "比 " + instance1.getTime() + "早");

        }else {
            System.out.println(instance.getTime() + "和 " + instance1.getTime() + "相等");

        }


        System.out.println("============"   );
        //add方法是根据日历的规则，将指定的时间量添加或减去给定的日历字段
        Calendar instance2 = Calendar.getInstance();
        //当前时间的两个月后
        instance2.add(Calendar.MONTH,2);
        //两个月后另一天
        instance2.add(Calendar.DATE,1);
        System.out.println(instance2.getTime());

    }


}
