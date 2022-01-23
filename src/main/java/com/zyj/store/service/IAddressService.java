package com.zyj.store.service;

import com.zyj.store.entity.Address;

import java.util.List;

/**
 * 收获地址接口
 */
public interface IAddressService {
    void addNewAddress(Address address, String username, Integer uid);
    List<Address>  getByUid(Integer id);

    void setDefault(Integer aid, Integer uid, String username);

    /**
     * 删除选中的收获地址
     * @param aid
     * @param uid
     * @param username
     */
    void delete(Integer aid, Integer uid, String username);

    Address getByAid(Integer aid, Integer uid);
}
