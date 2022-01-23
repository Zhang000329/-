package com.zyj.store.mapper;

import com.zyj.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 标注当前的类时测试类
 */
@SpringBootTest
//表示启动这个测试类（单元测试类是不能运行的），需要传递一个参数，必须时SpringRunner的实例类型
@RunWith(SpringRunner.class)

public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;
    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(1);
        address.setPhone("123241231231");
        address.setName("女朋友");
        addressMapper.insert(address);
    }
    @Test
    public void countByUid(){
        System.out.println(addressMapper.countByUid(1));
    }

    @Test
    public void findByUid(){
        System.out.println(addressMapper.findByUid(7));
    }

    @Test
    public void findByAid(){
        System.out.println(addressMapper.findByAid(3));
    }
    @Test
    public void updateNonDefault(){
        addressMapper.updateNonDefault(7);
    }
    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(7,"root", new Date());
    }

    @Test
    public void deleteByAid(){
        addressMapper.deleteByAid(6);
    }
    @Test
    public void findLastModified(){
        System.out.println(addressMapper.findLastModified(7));
    }
}
