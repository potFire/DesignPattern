package factory.abstractFactory;

/**
 * 抽象电脑工厂
 */
public abstract class AbstractFactory {

    /**
     * 获取微星电脑
     * @return
     */
    public abstract Computer getMsi();

    /**
     * 获取宏碁电脑
     * @return
     */
    public abstract Computer getAcer();
}
