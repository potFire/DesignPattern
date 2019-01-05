package factory.factoryFactory;

/**
 * 生产特仑苏的工厂
 */
public class TeLunSuFactory implements Factory{

    public Milk getMilk() {
        return new TeLunSu();
    }
}
