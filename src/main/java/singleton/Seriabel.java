package singleton;

/**
 * 以饿汉式单例为例，解决序列化后破坏单例的问题
 */
public class Seriabel {

    private static Seriabel seriabel = new Seriabel();

    private Seriabel(){}

    public static Seriabel getInstance(){
        return seriabel;
    }

    /**
     * 重点***********
     * @return
     */
    private Object readResolve(){
        return seriabel;
    }
}
