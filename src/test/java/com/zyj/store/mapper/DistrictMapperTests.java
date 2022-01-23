package com.zyj.store.mapper;

import com.zyj.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 标注当前的类时测试类
 */
@SpringBootTest
//表示启动这个测试类（单元测试类是不能运行的），需要传递一个参数，必须时SpringRunner的实例类型
@RunWith(SpringRunner.class)

public class DistrictMapperTests {
    @Autowired
    private DistrictMapper districtMapper;
    @Test
    public void findByParent(){
        List<District> list = districtMapper.findByParent("210100");
        for (District d: list) {
            System.out.println(d);
        }

    }
    @Test
    public void findNameByCode(){
        System.out.println(districtMapper.findNameByCode("610000"));
    }

}
