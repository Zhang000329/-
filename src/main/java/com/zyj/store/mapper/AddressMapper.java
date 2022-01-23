package com.zyj.store.mapper;

import com.zyj.store.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 收货地址持久层的接口
 */
@Repository
public interface AddressMapper {
    /**
     * 插入用户的收货地址数据
     * @param address
     * @return
     */
    Integer insert(Address address);

    /**
     * 根据用户id统计收货地址数量
     *
     * @param uid
     * @return 当前用户的地址总数
     */
    Integer countByUid(Integer uid);

    /**
     * 根据id查询用户收获地址的数据
     * @param uid
     * @return
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询收获地址数据
     * @param aid
     * @return
     */
    Address findByAid(Integer aid);

    /**
     * 根据用户的uid值来修改用户的收获地址设置为非默认
     * @param uid
     * @return
     */
    Integer updateNonDefault(Integer uid);

    /**
     *
     * @param aid
     * @return
     */
    Integer updateDefaultByAid(Integer aid,
                               String modifiedUser,
                               Date modifiedTime);

    /**
     * 根据收获地址id删除收货地址数据
     * @param aid
     * @return
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户uid查询当前用户最后一次被修改的收货地址数据
     * @param uid
     * @return
     */
    Address findLastModified(Integer uid);
}
