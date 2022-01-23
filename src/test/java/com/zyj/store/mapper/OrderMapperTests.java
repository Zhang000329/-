package com.zyj.store.mapper;

import com.zyj.store.entity.Order;
import com.zyj.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//表示启动这个测试类（单元测试类是不能运行的），需要传递一个参数，必须时SpringRunner的实例类型
@RunWith(SpringRunner.class)

public class OrderMapperTests {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void insertOrder() {
        Order order = new Order();
        order.setUid(7);
        order.setRecvName("小王");
        Integer rows = orderMapper.insertOrder(order);
        System.out.println("rows=" + rows);
    }

    @Test
    public void insertOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(2);
        orderItem.setTitle("高档铅笔");
        Integer rows = orderMapper.insertOrderItem(orderItem);
        System.out.println("rows=" + rows);
    }
}
