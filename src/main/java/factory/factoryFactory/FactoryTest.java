package factory.factoryFactory;

public class FactoryTest {

    public static void main(String[] args) {
        Factory factory = new MengNiuFactory();
        System.out.println(factory.getMilk());
    }
}
