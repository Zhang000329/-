package com.zyj.store.service;

import com.zyj.store.entity.Product;

import java.util.List;

public interface IProductService {
    /**
     * 查询热销商品的前四名
     * @return
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    Product findById(Integer id);
}
