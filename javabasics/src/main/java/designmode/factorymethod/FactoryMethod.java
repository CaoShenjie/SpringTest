package designmode.factorymethod;

public class FactoryMethod {
    public static void main(String[] args) {
        Application ConCreateProduct = new ConCreateProduct();
        Product productA = ConCreateProduct.getObject();
        productA.Method1();
    }

}

//productA,B....等等 可能出现多个 并且方法是唯一的 都有method 提炼出接口product
interface Product {
    public void Method1();
}

class ProductA implements Product {
    public void Method1() {
        System.out.println("ProductA.Method1 executed");
    }
}

class ProductB implements Product {
    public void Method1() {
        System.out.println("ProductB.Method1 executed");
    }
}

class ProductFactory {
    public static Product CreateProduct(String type) {
        if ("0".equals(type)) {
            return new ProductA();
        } else if ("1".equals(type)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}

abstract class Application {

    abstract Product CreateProduct();

    Product getObject() {
        return CreateProduct();
    }
}

class ConCreateProduct extends Application {

    @Override
    Product CreateProduct() {
        return new ProductA();
    }
}
