package factory.abstractFactory;

/**
 * 具体生产电脑
 */
public class ComputerFactory extends AbstractFactory{

    @Override
    public Computer getMsi() {
        return new Msi();
    }

    @Override
    public Computer getAcer() {
        return new Acer();
    }
}
