package com.zyj.store.mapper;

import com.zyj.store.entity.User;
import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 标注当前的类时测试类
 */
@SpringBootTest
//表示启动这个测试类（单元测试类是不能运行的），需要传递一个参数，必须时SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {
    //idea有检测的功能，接口是不能够直接创造bean的（动态代理技术解决）
    @Autowired
    private UserMapper userMapper;
    /**
     * 1. 必须被@Test修饰
     * 2. 返回值必须时void
     * 3 方法的参数列表不指定任何类型
     * 4 方法的访问修饰符必须时public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("tim");
        System.out.println(user);
    }
    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(1,
                "321","root",new Date());
    }
    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(1));
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(7);
        user.setPhone("12321311");
        user.setEmail("test01@qq.com");
        user.setGender(1);
        userMapper.updateInfoUid(user);
    }
    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(
                7,
                "/upload/avatar.png",
                "root",
                new Date());
    }

}
