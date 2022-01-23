package com.zyj.store.service;

import com.zyj.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 用户模块业务层接口
 */

public interface IUserService {
    /**
     * 用户注册方法
     * @param user
     */
    void reg(User user);

    /**
     * 用户登陆功能
     * @param username
     * @param password
     * @return 当前匹配的用户数据
     */
    User login(String username, String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     * 根据用户的id产需用户的数据
     * @param uid
     * @return
     */
    User getByUid(Integer uid);

    /**
     * 更新用户的数据操作
     * @param user
     * @param uid
     * @param username
     */
    void changeInfo(User user, Integer uid , String username);

    /**
     * 修改用户的头像
     * @param uid
     * @param avatar 用户头像的路径
     * @param modifiedUser
     */
    void changeAvatar(@Param("uid") Integer uid,
                      @Param("avatar") String avatar,
                      @Param("modifiedUser")String modifiedUser);
}
