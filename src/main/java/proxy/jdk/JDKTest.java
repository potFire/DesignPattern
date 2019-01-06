package proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class JDKTest {

    public static void main(String[] args) {
        Action action = (Action) new Classmate().getInstance(new My());
        //System.out.println(action.getClass());
        action.buy();

        try {
            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Action.class});
            FileOutputStream os = new FileOutputStream("F://$Proxy0.class");
            os.write(bytes);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
