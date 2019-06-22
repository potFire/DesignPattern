package prototype.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luand
 * @Date 2019/6/22
 * @Description
 **/

/**
 * 浅克隆时，克隆对象的引用对象和被克隆对象的引用对象时同一个
 */
public class PrototypeTest {

    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA();
        prototypeA.setAge(18);
        prototypeA.setName("prototypeA");
        List hobbies = new ArrayList(1);
        prototypeA.setHobbies(hobbies);
        System.out.println(prototypeA);

        Client client = new Client(prototypeA);
        ConcretePrototypeA prototypeA1 = (ConcretePrototypeA)client.startClone(prototypeA);
        System.out.println("克隆对象中的引用类型地址值："+prototypeA1.getHobbies());
        System.out.println("原对象中的引用类型地址值："+prototypeA.getHobbies());
        System.out.println("对象地址比较："+(prototypeA.getHobbies() == prototypeA1.getHobbies()));
    }
}
