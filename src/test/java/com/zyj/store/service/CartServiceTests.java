package com.zyj.store.service;

import com.zyj.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class CartServiceTests {
    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(22,10000003,5,"root");
    }

    @Test
    public void addNum() {
        try {
            Integer cid = 4;
            Integer uid = 7;
            String username = "管理员";
            Integer num = cartService.addNum(cid, uid, username);
            System.out.println("OK. New num=" + num);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
