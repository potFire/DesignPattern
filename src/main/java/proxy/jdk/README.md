## JDK动态代理

### 基本介绍
JDK 动态代理跟静态代理的最大的区别是，代理类( Classmate ) 实现了 InvocationHandler 接口，
并重写了 invoke 方法。
Java 是利用 InvocationHandle 接口实现代理的，所以每一个需要被代理的类在使用 JDK 动态代理的
时候都需要实现该接口。

### 基本原理
在拿到被代理对象的引用，并且获取到它所有的接口，也就是通过反射获取；JDK Proxy 类重新生成一个新的类
，同时新的类要实现被代理类的所有实现的接口，动态生成 Java 代码，编译后再重新加载到 JVM 中运行，这个
过程也叫字节码重组。
### 程序的UML图

![JDKProxy1.png](https://i.loli.net/2019/01/06/5c31b197ef478.png)

Action 是一个接口，My 实现 Action 接口，并重写了 buy() 方法。具体代码可点击查看相应的类。
### 具体分析
首先，从执行开始：
```java
   Action action = (Action) new Classmate().getInstance(new My());
```
这是在 JDKTest 类中，开始执行的代码。然后会调用到 Classmate 类里的 getInstance() 方法。
```java
   public Object getInstance(Action action){
       this.action = action;
       Class clazz = action.getClass();
       return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
   }
```
这里重点是最后一行代码。Proxy 类就是用来创建一个代理对象的类，这里用的是 newProxyInstance() 方法来创建对象。
```java
public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
```
+ ClassLoader loader : ClassLoader 是类加载器，作用是将 class 文件加载到JVM里面去，
在这里很明显是用 My 这个类(被代理类)的加载器对代理类进行加载。
+ Class<?>[] interfaces : 获取被代理类(My)的接口传入，然后代理类在生成代码时会实现这些接口。
+ InvocationHandler h : 表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并调用关联对象的 invoke 方法。

再来看代理类反编译后的代码。首先代理类实现了被代理类的接口。
被代理类 My 实现的接口：
```java
   public class My implements Action
```
代理类实现的接口：
```java
    public final class $Proxy0 extends Proxy implements Action
```
在 JDK 中有个规范，只要要是$开头的一般都是自动生成的，而后面的数字则是表示生成的第几个类。$Proxy0 就表示自动生成的第1个类，至于从0开始计算，
如果不知道请自行领悟。$Proxy0 类同样实现了 Action 这个接口。
$Proxy0 类中有四个成员变量：
```java
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;
    
    ....
    
    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m3 = Class.forName("proxy.jdk.Action").getMethod("buy");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
```
$Proxy0 除了 equals、toString、hashCode 这三个必备的方法外，还获取了 Action 接口的 buy 方法。
回到 JDKTest 类中，当调用完 getInstance() 方法后，执行的下面这个方法：
```java
    action.buy();
```
接下来又会调用 $Proxy0 的 buy() 方法：
```java
    public final void buy() throws  {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }
```
还记得 $Proxy0 继承了 Proxy 类吧，在Proxy 类中又这么个成员变量：
```java
    /**
     * the invocation handler for this proxy instance.
     * @serial
     */
    protected InvocationHandler h;
```
同样，还记得在 newProxyInstance 时，最后一个参数传的是一个 this 吧，所以，
最后又回到了 Classmate 类的 invoke 方法。(在实现 InvocationHandler 的类
都要重写 invoke 方法)
Classmate 类的 invoke 方法如下：
```java
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我要去买饭了，你要买什么？");
        method.invoke(this.action,args);
        System.out.println("买回来了");
        return null;
    }
```
method.invoke() 是反射的内容，执行的是 My 类里面的 buy 方法，在这里就不展开来说了，不然就没完没了了，先挖个坑。最后程序的执行结果如下：
```java
    我要去买饭了，你要买什么？
    我要刀削面
    买回来了
```