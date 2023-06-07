import java8.preview.Apple;
import java8.preview.AppleFormatter;
import java8.preview.ComplexApplePrint;
import java8.preview.SimpleApplePrint;

import java.util.*;
import java.util.concurrent.*;

//你要做一个不动声色的大人了。
public class Demo {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("----------------");
        Apple apple = null;
        List<Apple> appleList = Arrays.asList(new Apple("yellow",151),new Apple("green",154),new Apple("green",124));
        /*for (int i = 150; i < 155; i++) {
            apple = new Apple("green", i);
            appleList.add(apple);
        }*/
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        appleList.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight())); //lambda表达式语法
        appleList.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight())); //lambda表达式语法

        System.out.println(appleList);
        prettyPrintApple(appleList, new ComplexApplePrint());
        prettyPrintApple(appleList, new SimpleApplePrint());
        prettyPrintApple(appleList, new AppleFormatter() {
            @Override
            public String accept(Apple apple) {
                return apple.getColor() + "----" + apple.getWeight() ;
            }
        });

        /*
        //迭代器
        ArrayList<String> arraySize = new ArrayList<>();
        arraySize.add("dfsdfsfsd");
        System.out.println(arraySize.size());


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ewrwe");
        arrayList.add("werw");
        Iterator iterat = arrayList.iterator();
        while (iterat.hasNext()) {
            System.out.println(iterat.next());
        }


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "22");
        map.put(2, "dsd");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + entry.getValue());
        }


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("werwer");
        linkedList.add("gdsfs");
        linkedList.add(0,"3324");

        Iterator iterator1 = linkedList.iterator();
        for (String i: linkedList){
            System.out.println(i);
        }*/


        /*new Thread(() -> {
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println(lazySingleton);
        }).start();

        new Thread(() -> {
            LazySingleton lazySingleton1 = LazySingleton.getInstance();
            System.out.println(lazySingleton1);
        }).start();*/


        /*String a = "sdfsd";
        boolean s = a.matches("sdfsd");
        String b= a.concat(a);
        String c= a.substring(1,4);
        StringBuffer sdsf = new StringBuffer("efwe");
        StringBuilder ERWT = new StringBuilder("EWRWER");
        String d=a.toUpperCase(Locale.forLanguageTag(a));
        int f= a.hashCode();
        Object r =a.getClass();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(f);
        System.out.println(r);*/
        //ReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);//读写锁

        /*BlockingQueue  deque = new ArrayBlockingQueue(20);
        for (int i = 0; i < 30; i++) {
            if (i>19){
                deque.clear();
            }
            deque.put(i);
            System.out.println("阻塞队列增加了元素"+i);
        }
        System.out.println("阻塞队列已满！");*/

        /*ExecutorService pool = Executors.newFixedThreadPool(2);//边界线程池
        MyCallable c1= new MyCallable("A");
        MyCallable c2= new MyCallable("B");
        Future f1 = pool.submit(c1);
        Future f2 = pool.submit(c2);
        System.out.println(pool.submit(c1).get().toString());
        System.out.println(pool.submit(c2).get().toString());
        pool.shutdown();*/

        /*
        //共享变量  终止线程！
        Thread t1 = new Thread(()->{
            while (!flag){
                //处理业务
            }
            System.out.println("线程结束!");
        });
        t1.start();
        Thread.sleep(500);
        flag =true;
        */

        /*
        //interrupt 终止线程！
        System.out.println(Thread.currentThread().isInterrupted());
        //interreupt变量将默认值由false 改为 true
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        //将interrupt变量 归位 false
        Thread.interrupted();
        Thread t1 = new Thread(()->{
                while (!Thread.currentThread().isInterrupted()){
                    //处理业务
                }
            System.out.println("线程结束!");
        });
        t1.start();
        Thread.sleep(500);
        //终止线程
        t1.interrupt();
        */

        /*ThreadTest t = new ThreadTest();
        t.start();
        synchronized (t) {
            try {
                t.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread t2 = new Thread(new ThreadTest2());
        //t2.setDaemon(true);//守护线程
        t2.start();
        System.out.println("----------------");*/
        /*t.setName("主线程");
        t.setPriority(5);
        System.out.println(t.getName()+"==="+t.getId()+"===="+t.getPriority());


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠结束！执行第二个线程");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println(i);
                }
            }
        }.start();*/
    }

    public static void prettyPrintApple(List<Apple> appleList, AppleFormatter appleFormatter) {
        for (Apple apple : appleList) {
            String a = appleFormatter.accept(apple);
            System.out.println(a);
        }
    }
}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }
}
