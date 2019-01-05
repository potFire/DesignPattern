## 抽象工厂模式
### 方法调用
AbstractFactory 是一个抽象类，ComputerFactory 继承了 AbstractFactory 并对其中的
抽象方法重写，返回对应的实现类。

![abstractFactory.png](https://i.loli.net/2019/01/05/5c30162459719.png)

Computer 是一个接口，Msi 和 Acer 都实现了这个接口。

![computer.png](https://i.loli.net/2019/01/05/5c3016d938d9f.png)

方法调用的总览如下：

![abstractFactoryTotal.png](https://i.loli.net/2019/01/05/5c30170b43dd9.png)

### 总结

抽象工厂方法相对于工厂方法而言，工厂方法在添加新的工厂，且用户端需要用到时，用户端需要先 new 这个工厂出来，
```java
        Factory factory = new MengNiuFactory();
        System.out.println(factory.getMilk());
```
抽象工厂只需要通过 getXXX() 方法就可以获取到，
```java
        AbstractFactory factory = new ComputerFactory();
        System.out.println(factory.getMsi());
```
工厂内部的改动对于用户端来说，是屏蔽的，用户端不需要变动什么地方，
做到了开闭原则。