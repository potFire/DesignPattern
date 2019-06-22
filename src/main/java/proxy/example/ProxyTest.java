package proxy.example;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author luand
 * @Date 2019/6/22
 * @Description
 **/
public class ProxyTest {

    public static void main(String[] args) {
        /*try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2018/02/01");
            order.setCreateTime(date.getTime());
            IOrdderService ordderService = (IOrdderService)new OrderServiceJdkDynamicProxy().getInstance(new OrderServiceImpl());
            ordderService.createOrder(order);
        }catch (Exception e){

        }*/

        Pay pay = (Pay)new CglibDynamicProxy().getInstance(Pay.class);
        pay.payOrder();
    }
}
