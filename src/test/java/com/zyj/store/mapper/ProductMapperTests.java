package com.zyj.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 标注当前的类时测试类
 */
@SpringBootTest
//表示启动这个测试类（单元测试类是不能运行的），需要传递一个参数，必须时SpringRunner的实例类型
@RunWith(SpringRunner.class)

public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;
   @Test
    public void findHotList(){
       System.out.println(productMapper.findHotList());
   }
   @Test
    public void findById(){
       System.out.println(productMapper.findById(10000017));
   }
}
