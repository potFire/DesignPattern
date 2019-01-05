package factory.abstractFactory;

public class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new ComputerFactory();
        System.out.println(factory.getMsi());
    }
}
