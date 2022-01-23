package com.zyj.store.service.impl;

import com.zyj.store.entity.User;
import com.zyj.store.mapper.UserMapper;
import com.zyj.store.service.IUserService;
import com.zyj.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        // 调用findByUsername判断用户是否被注册过
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        if(result != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }
        /*
        密码加密处理的实现：md5算法的形式
        串+密码+串-----md5加密
        盐值+密码+盐值，盐值就是一个随机的字符串
        */
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 将密码和盐值作为一个整体进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);
        user.setPassword(md5Password);
        user.setSalt(salt);
        // 补全数据：is_delete设置成0
        user.setIsDelete(0);
        // 补全数据，4个日志的字段信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        //执行注册业务逻辑
        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new InserException("在用户注册过程中产生了未知的异常");
        }

    }

    @Override
    public User login(String username, String password) {
        // 根据用户名称查询，用户的数据是否存在，不存在抛出异常
        User result = userMapper.findByUsername(username);
        if(result == null)
            throw new UserNotFoundException("用户数据不存在");
        // 检测用户的密码是否匹配
        String oldPassword = result.getPassword();
        String salt = result.getSalt();
        String newPassword = getMD5Password(password, salt);
        if(!newPassword.equals(oldPassword))
            throw new PasswordNotMatchException("用户密码错误");
        if(result.getIsDelete() == 1)
            throw new UserNotFoundException("用户数据不存在");
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");

        }
        String oldMd5Password = getMD5Password(oldPassword, result.getSalt());
        if(!result.getPassword().equals(oldMd5Password)){
            throw new PasswordNotMatchException("密码错误");
        }
        String newMd5Password = getMD5Password(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新数据产生未知的错误");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");

        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeInfo(User user, Integer uid, String username) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoUid(user);
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知的异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String modifiedUser) {
        // 查询当前用户数据是否存在
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, modifiedUser, new Date());
        if(rows != 1){
            throw new UpdateException("更新用户头像产生未知的异常");
        }
    }

    //    定义md5算法加密
    private String getMD5Password(String password, String salt){
          for(int i = 0; i < 3; i ++)
              password = DigestUtils
                      .md5DigestAsHex((salt+password+salt).getBytes())
                      .toUpperCase();
          return password;

    }
}
