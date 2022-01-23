package com.zyj.store.service;

import com.zyj.store.entity.Order;

public interface IOrderService {

    Order create(Integer aid, Integer[] cids, Integer uid, String username);
}
