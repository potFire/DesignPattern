package factory.factoryFunction;

/**
 * 生产蒙牛的工厂
 */
public class MengNiuFactory implements Factory{


    public Milk getMilk() {
        return new MengNiu();
    }
}
