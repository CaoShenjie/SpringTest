package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 extends Thread{
    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");// 格式化时间
        //sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        //Date date = new Date();// 获取当前时间
        System.out.println(this.getName()+"开始时间：" + sdf.format(System.currentTimeMillis())); // 输出已经格式化的现在时间（24小时制）
        System.out.println(this.getName()+"开始执行");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i==6){
                System.out.println(this.getName()+"开始让步");
                Thread.yield();
            }
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        Date da = new Date();// 获取当前时间
        System.out.println(this.getName()+"结束时间：" + sdf.format(da)); // 输出已经格式化的现在时间（24小时制）
    }
}
