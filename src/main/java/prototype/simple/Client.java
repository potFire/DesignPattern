package prototype.simple;

/**
 * @Author luand
 * @Date 2019/6/22
 * @Description
 **/
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype prototypes){
        return prototypes.clone();
    }
}
