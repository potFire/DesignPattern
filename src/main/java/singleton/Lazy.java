package singleton;

/**
 * 懒汉式单例
 * 默认使用Lazy的时候，会先初始化内部类，如果没使用的话，内部类是不加载的
 * PS：initialized 和 构造方法内的静态代码是为了防止反射侵入，也就是通过反射直接
 * 调用内部类
 */
public class Lazy {

    private static boolean initialized = false;

    private Lazy(){

        synchronized (Lazy.class){
            if (initialized == false){
                initialized = !initialized;
            }else {
                throw  new RuntimeException("单例已经初始化了");
            }
        }
    }

    public static final Lazy getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final Lazy LAZY = new Lazy();
    }
}
