package staticclass;

public class StaticInnerClass {
    public static int num = 10;
    public static String getMethod(int numm){
        System.out.println("213131");
        return "erewr";
    };
    public static class TestClass {

        public static TestClass getStr() {
            return str;
        }

        public static void setStr(TestClass str) {
            TestClass.str = str;
        }

        private static TestClass str = new TestClass();

        public static TestClass testStr() {
            System.out.println("---"+str.hashCode());
            //静态内部类如果要访问外部的成员变量或者成员方法，那么必须是静态的。例： num
            System.out.println("---"+num);
            getMethod(num);
            return str;
        }
    }

    public static void main(String[] args) {
        //静态方法 能够直接 用 类名.方法名 进行调用
        TestClass.testStr();
    }
}
class Inner{

}
