package com.my.Service;

import com.my.pojo.Users;

/**
 * @Author: dongqihang
 * @Date: Created in 14:23 2019/2/20
 */
public interface UsersService {
    boolean signUp(Users users);
    boolean login(Users users);
    boolean updateUsersInfo(Users users);
    boolean checkEmailAvailable(String email);
}
