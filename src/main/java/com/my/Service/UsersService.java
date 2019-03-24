package com.my.Service;

import com.my.pojo.Users;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @Author: dongqihang
 * @Date: Created in 14:23 2019/2/20
 */
@MapperScan("com.my.dao")
public interface UsersService {
    int signUp(Users users);
    boolean login(Users users);
    boolean updateUsersInfo(Users users);
    boolean checkEmailAvailable(String email);
    Users getUsersInfo(int uid);
    int getUidByEmail(String email);
}
