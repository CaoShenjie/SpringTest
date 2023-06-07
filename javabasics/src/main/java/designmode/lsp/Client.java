package designmode.lsp;

import jdk.swing.interop.SwingInterOpUtils;
import staticclass.StaticInnerClass;

public class Client {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        System.out.println(a.fun1(10,20));
        System.out.println(b.fun1(10,20));
        System.out.println(b.fun1(10,20));
        System.out.println(b.fun2(10,20));
    }
}
