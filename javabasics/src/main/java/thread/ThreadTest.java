package thread;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest extends Thread{
    @Override
    public void run() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");// 格式化时间
        //sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        //Date date = new Date();// 获取当前时间
        //System.out.println(this.getName()+"开始时间：" + sdf.format(System.currentTimeMillis())); // 输出已经格式化的现在时间（24小时制）
        /*try {
            Thread.sleep(50);//线程睡眠
            System.out.println(this.getName()+"睡眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i==4){
                    System.out.println(this.getName()+"开始通知");
                    notify();//唤醒线程
                    //Thread.yield();//线程让步
                }
            }
        }
        //Date da = new Date();// 获取当前时间
        //System.out.println(this.getName()+"结束时间：" + sdf.format(da)); // 输出已经格式化的现在时间（24小时制）
    }
}
