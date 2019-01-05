# 工厂方法模式

### 应用场景
通常由应用程序直接使用 new 来创建新的对象，为了将对象的创建和使用相分离，
采用工厂方法模式，就是将对象的创建及初始化交给工厂对象。
### 特点
对于调用者来说，隐藏了复杂的逻辑处理过程，调用者只关心结果。
对于工厂来说要对结果负责，保证生产出符合要求的产品。
## 方法调用
TeLunSu 和 MengNiu 这两个类都实现了 Milk 接口，并重写 milkName 这个方法。
![simpleFactoryMilk.png](https://i.loli.net/2019/01/05/5c3006f4c24e0.png)

MengNiuFactory 和 TeLunSuFactory 都实现了 Factory 这个结果。重写 getMilk 方法后，
分别返回 TeLunSu 和 MengNiu 的实现类。

![simpleFactory.png](https://i.loli.net/2019/01/05/5c300939d5093.png)

最后，总体的调用概览如下：

![simpleFactoryTotal.png](https://i.loli.net/2019/01/05/5c300a5279a04.png)
