package singleton;

/**
 * 饿汉式单例
 */
public class Hungry {

    /**
     * 类的加载顺序：
     * 先静态，后动态。
     * 先属性，后方法。
     * 先上后下
     */

    private Hungry(){}

    private static final Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
