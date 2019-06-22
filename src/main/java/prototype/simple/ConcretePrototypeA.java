package prototype.simple;

import java.util.List;

/**
 * @Author luand
 * @Date 2019/6/22
 * @Description 需要克隆的对象
 **/
public class ConcretePrototypeA implements Prototype{

    private int age;

    private String name;

    private List hobbies;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public Prototype clone() {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA();
        prototypeA.setAge(this.age);
        prototypeA.setName(this.name);
        prototypeA.setHobbies(this.hobbies);
        return prototypeA;
    }
}
