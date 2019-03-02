package com.my.Service;

import com.my.dao.UsersMapper;
import com.my.pojo.Users;
import com.my.pojo.UsersExample;
import com.my.util.EncodeMD5;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 1:19 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public boolean signUp(Users users) {
        try {
            if(checkEmailAvailable(users.getEmail())){
                usersMapper.insert(users);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    //todo 用户的唯一标识是什么,用户名呢？可重复？昵称？
    @Override
    public boolean login(Users users) {
        try{
            UsersExample usersExample=new UsersExample();
            usersExample.or().andEmailEqualTo(users.getEmail());
            List<Users> user=usersMapper.selectByExample(usersExample);
//            if(EncodeMD5.encode(users.getPassword()).equals(user.get(0).getPassword())){
//                return true;
//            }
            if(users.getPassword().equals(user.get(0).getPassword())){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    @Override
    public boolean updateUsersInfo(Users users) {
        try{
            usersMapper.updateByPrimaryKey(users);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean checkEmailAvailable(String email) {
        try{
            UsersExample usersExample=new UsersExample();
            usersExample.or().andEmailEqualTo(email);
            List<Users> usersList=usersMapper.selectByExample(usersExample);
            if(usersList.isEmpty()){
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
