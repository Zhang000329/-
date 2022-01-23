package com.zyj.store.service;

import com.zyj.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private IUserService userService;
    @Test
    public void  reg(){
        try {
            User user = new User();
            user.setUsername("awq");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User u = userService.login("test01", "123");
        System.out.println(u);
    }
    @Test
    public void changePassword(){
        userService.changePassword(7,"root","123","321");
    }

    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(7));
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("123123");
        user.setEmail("341241@qq.com");
        user.setGender(0);
        userService.changeInfo(user,7,"root");
    }
    @Test
    public void changeAvatar(){
        userService.changeAvatar(7,"/upload/333.png","小张");
    }
}
