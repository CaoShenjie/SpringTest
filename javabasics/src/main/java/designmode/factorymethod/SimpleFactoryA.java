package designmode.factorymethod;

public class SimpleFactoryA implements SimpleFactory{
    @Override
    public SimpleProduct creatProduct(String type) {
        return new  SimpleProductA();
    }
}
