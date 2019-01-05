package factory.factoryFactory;

/**
 * 生产牛奶的工厂标准
 */
public interface Factory {

    /**
     * 获取生产牛奶的工厂
     * @return
     */
    public Milk getMilk();
}
