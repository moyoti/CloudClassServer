package com.my.Service;

import com.my.dao.UsersMapper;
import com.my.pojo.Users;
import com.my.pojo.UsersExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
    public int signUp(Users users) {
        try {
            if(checkEmailAvailable(users.getEmail())){
                usersMapper.insert(users);
                return users.getUid();
            }
            return -1;
        }catch (Exception e){
            return -1;
        }
    }

    //todo 用户的唯一标识是什么,用户名呢？可重复？昵称？
    @Override
    public boolean login(Users users) {
        try{
//            System.out.println(users.getEmail());
//            System.out.println(users.getPassword());
            UsersExample usersExample=new UsersExample();
            usersExample.or().andEmailEqualTo(users.getEmail());
            List<Users> user=usersMapper.selectByExample(usersExample);
//            if(EncodeMD5.encode(users.getPassword()).equals(user.get(0).getPassword())){
//                return true;
//            }
//            System.out.println("--------------------");
//            System.out.println(users.getPassword());
//            System.out.println(user.get(0).getPassword());
//            System.out.println("-------------------");
            if(user==null){
                return false;
            }else if(users.getPassword().equals(user.get(0).getPassword())){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
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
            e.printStackTrace();
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

    @Override
    public Users getUsersInfo(int uid) {
        return usersMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int getUidByEmail(String email) {
        UsersExample usersExample=new UsersExample();
        usersExample.or().andEmailEqualTo(email);
        return usersMapper.selectByExample(usersExample).get(0).getUid();
    }

    @Override
    public List<Users> getUsersByEmails(String emails) {
        UsersExample usersExample=new UsersExample();
        List<String> useremail= new ArrayList<>();
        for (String i : emails.split("@")) {
            useremail.add(i.replaceAll("#", "@"));
        }
//        Collections.addAll(useremail, emails.split("@"));
        usersExample.or().andEmailIn(useremail);
        return usersMapper.selectByExample(usersExample);
    }
}
