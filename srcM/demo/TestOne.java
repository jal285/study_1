package demo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class TestOne {
    public static void main(String[] args) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        //获取java程序运行时所有线程数
        ThreadInfo[] allThreads = mxBean.dumpAllThreads(false, false);
//        for(ThreadInfo threadInfo:allThreads){
//            System.out.println(threadInfo.getThreadId()+"==="+threadInfo.getThreadId()+" "+threadInfo.getThreadName());
//

//        }

    }
}
