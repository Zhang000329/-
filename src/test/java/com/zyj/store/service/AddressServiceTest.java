package com.zyj.store.service;

import com.zyj.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class AddressServiceTest {
    @Autowired
    private IAddressService addressService;
    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setPhone("2131231231");
        address.setName("男朋友");
        addressService.addNewAddress(address,"root",7);
    }
    @Test
    public void setDefault(){
        addressService.setDefault(7,7,"root");
    }
    @Test
    public void delete(){
        addressService.delete(4,7,"root");
    }
}
