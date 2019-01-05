package singleton;

import java.util.HashMap;

/**
 * 注册式单例-map方式
 */
public class Register {

    private Register(){}

    private static HashMap<String,Object> registerMap = new HashMap<String, Object>();

    public static Register getInstance(String className){
        if (className == null){
            className = Register.class.getName();
        }

        //如果 map 中没有该对象，则新建一个放进去
        if (registerMap.get(className) == null){
            try {
                registerMap.put(className,Class.forName(className).getInterfaces());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return (Register) registerMap.get(className);
    }
}
