package designmode.lsp;

public class ClassB extends ClassA{
    @Override
    public int fun1(int a, int b) {
        return super.fun1(a,b);
    }
    public int fun2(int a,int b){
        return (a+b)+100;
    }
}
