package designmode.factorymethod;

public class SimpleFactoryMethod {
    public static void main(String[] args) throws Exception {
        SimpleFactory simpleFactory = (SimpleFactory) Class.forName("designmode.factorymethod.SimpleFactoryA").newInstance();
        /*SimpleFactory simpleFactory = new SimpleFactory();*/
        SimpleProduct product = simpleFactory.creatProduct("1").createSimpleProduct();
    }
}

/*
interface SimpleProduct {
    public SimpleProduct createSimpleProduct();
}

class SimpleProductA implements SimpleProduct {
    public SimpleProductA createSimpleProduct() {
        System.out.println("生产了 A产品");
        return new SimpleProductA();
    }
}

class SimpleProductB implements SimpleProduct {
    public SimpleProductB createSimpleProduct() {
        System.out.println("生产了 B产品");
        return new SimpleProductB();
    }
}
class SimpleFactory {
    public SimpleProduct creatProduct(String type) {
        if ("1".equals(type)) {
            return new SimpleProductA();
        } else if ("2".equals(type)) {
            return new SimpleProductB();
        } else {
            return null;
        }
    }
}*/
