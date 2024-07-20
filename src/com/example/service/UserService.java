package com.example.service;

import com.example.pojo.User;

/**
 * Class name: UserService
 * Package: com.example.service.impl
 * Description:业务逻辑
 *
 * @Author: twl
 * @Create-time: 2024/4/19 - 20:20
 */
public interface UserService {

    void registUser(User user);

    User userLogin(User user);

    boolean existUsername(String username);

}
