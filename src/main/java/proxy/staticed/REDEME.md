## 静态代理

### 故事背景

Action 代表需要代理的动作。My 想让 Classmate 帮他买个饭。

### 方法UML图

My 实现了 Action 接口类

![staticedMethod.png](https://i.loli.net/2019/01/05/5c30a69dc77e5.png)

总体实现如下：

![staticedTotal.png](https://i.loli.net/2019/01/05/5c30a6ca7124b.png)

### 尾巴

静态代理适合处理已知的事情，因为当需要添加新的代理动作时，需要到
 Action 这个接口类里添加代理动作，然后再到 My 这个实现类里，实现
 相应的代码，最后还要到 Classmate 里添加相应的方法，比较麻烦。