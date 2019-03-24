package com.my.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by williamwu on 2019/3/21.
 */
@RestController
@RequestMapping(value = "/openfire")
public class OpenfireOperation {

//    @RequestMapping(value = "/changepassword",method = RequestMethod.POST)
//    public boolean updateStatus(@RequestParam("email")String email, @RequestParam("password")String password){
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://129.207.204.18:3306/cloudchat";
//        String user = "dqhuser";
//        String pass = "dqhql123";
//        Connection conn = null;
//        try {
//            Class.forName(driver); //classLoader,加载对应驱动
//            conn = (Connection) DriverManager.getConnection(url, user, pass);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        String sql = "update students set Age='" + student.getAge() + "' where Name='" + student.getName() + "'";
//        PreparedStatement pstmt;
//
//        return true;
//    }
}
