package proxy.example;

/**
 * @Author luand
 * @Date 2019/6/22
 * @Description
 **/
public class OrderServiceImpl implements IOrdderService{
    public int createOrder(Order order) {
        System.out.println("创建订单");
        return 1;
    }
}
