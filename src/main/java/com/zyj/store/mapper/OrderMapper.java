package com.zyj.store.mapper;

import com.zyj.store.entity.Order;
import com.zyj.store.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    Integer insertOrder(Order order);

    Integer insertOrderItem(OrderItem orderItem);
}
