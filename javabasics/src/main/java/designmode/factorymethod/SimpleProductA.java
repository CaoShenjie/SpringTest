package designmode.factorymethod;

public class SimpleProductA implements SimpleProduct {
    public SimpleProductA createSimpleProduct() {
        System.out.println("生产了 A产品");
        return new SimpleProductA();
    }
}
