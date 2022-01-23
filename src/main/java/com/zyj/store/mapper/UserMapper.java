package com.zyj.store.mapper;

import com.zyj.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的数据
     * @return 受影响的行数，可以根据返回值来判断是否执行成功
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户，则返回这个用户的数据，如果没有则返回null值
     */
    User findByUsername(String username);

    /**
     * 根据用户的uid来修改用户的密码
     * @param uid
     * @return
     */
    Integer updatePasswordByUid(Integer uid);

    /**
     * 根据用户的uid来修改用户的密码
     * @param uid
     * @param password
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);
    /**
     * 根据用户的id来查询用户的数据
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 更新用户的数据信息
     * @param user
     * @return
     */
    Integer updateInfoUid(User user);

    /**
     * @Param (SQL映射文件中#{}占位符的变量名)
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar,
                              @Param("modifiedUser")String modifiedUser,
                              @Param("modifiedTime")Date modifiedTime);
}
