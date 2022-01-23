package com.zyj.store.service;

import com.zyj.store.vo.CartVO;

import java.util.List;

public interface ICartService {
    /**
     * 将商品添加到购物车中
     * @param uid
     * @param pid
     * @param amount
     * @param username
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    List<CartVO> getVOByUid(Integer uid);

    /**
     * 更新用户的购物车数据的数量
     * @param cid
     * @param uid
     * @param username
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cid, Integer uid, String username);

    List<CartVO> getVOByCid(Integer uid, Integer[] cids);
}
