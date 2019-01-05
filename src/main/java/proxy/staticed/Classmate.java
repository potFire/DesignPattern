package proxy.staticed;

public class Classmate {

    private My my;

    public Classmate(My my){
        this.my = my;
    }

    public void Help(){
        System.out.println("我要去吃饭了");
        my.BuyRice();
        System.out.println("好的");
    }
}
