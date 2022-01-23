package com.zyj.store.mapper;

import com.zyj.store.entity.Cart;
import com.zyj.store.vo.CartVO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CartMapper {
    /**
     *
     * @param cart
     * @return
     */
    Integer insert(Cart cart);

    /**
     * 更新购物车某件商品的数量
     * @param cid
     * @param num
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateNumByCid(Integer cid,
                           Integer num,
                           String modifiedUser,
                           Date modifiedTime);

    /**
     * 根据用户的ID和商品的id来查询购物车中的数据
     * @param uid
     * @param pid
     * @return
     */
    Cart findByUidAndPid(Integer uid, Integer pid);

    List<CartVO> findVOByUid(Integer uid);

    Cart findByCid(Integer cid);

    List<CartVO> findVOByCids(Integer[] cids);
}
