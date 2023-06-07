package java8.preview;
//匿名类谜题
//下面的代码执行时会有什么样的输出
public class MeaningOfThis
{
    public final int value = 4;
    public void doIt()
    {
        int value = 6;
        Runnable r = new Runnable(){
            public final int value = 5;
            public void run(){
                int value = 10;
                System.out.println(this.value);//注意this指的是什么？（）
            }
        };
        r.run();
    }
    public static void main(String...args)
    {
        MeaningOfThis m = new MeaningOfThis();
        System.out.println(m.value);
        m.doIt();
    }
}
