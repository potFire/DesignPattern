package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Classmate implements InvocationHandler {

    private Action action;

   public Object getInstance(Action action){
       this.action = action;
       Class clazz = action.getClass();
       return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
   }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我要去买饭了，你要买什么？");
        method.invoke(this.action,args);
        System.out.println("买回来了");
        return null;
    }
}
