package com.my.controller;

import com.my.Service.UsersService;
import com.my.pojo.Users;
import com.my.util.EmailSender;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dongqihang
 * @Date: Created in 11:15 2019/2/25
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean usersLogin(HttpServletRequest request, @RequestParam("email") String email, @RequestParam("password") String password) {
        Users users = new Users();
        users.setEmail(email);
        users.setPassword(password);
        System.out.println(email);
        System.out.println(password);
        System.out.println(usersService.login(users));
        return usersService.login(users);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean usersRegister(HttpServletRequest request,
                                 @Param("email") String email, @Param("password") String password) {
        Users users=new Users();
        System.out.println("Outside try");
        try{
            System.out.println("Inside try");
            users.setEmail(email);
            users.setPassword(password);
//            users.setGender(gender);
//            users.setName(name);
//            users.setPhone(phone);
            users.setYob(1996);
//            EmailSender emailSender=new EmailSender();
//            emailSender.send("title","content",new String[]{email});
        }catch (Exception e){
            return false;
        }

        return usersService.signUp(users);
    }

    @RequestMapping(value = "/registerValidation", method = RequestMethod.POST)
    public String usersSendValidationCode(HttpServletRequest request,
                                 @RequestParam("address") String email) {
        int a = (int)((Math.random()*9+1)*100000);
        String validationcode = String.valueOf(a);

        String address = request.getParameter("address");
        System.out.println("Outside try");
        try{
            System.out.println("Inside try");
            System.out.println("Email is : "+address);
            EmailSender emailSender=new EmailSender();
            emailSender.send("title","您的验证码是："+validationcode,new String[]{email});
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return validationcode;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateUsersInfo(HttpServletRequest request,
                                   @Param("email") String email, @Param("password") String password,
                                   @Param("name") String name, @Param("phone")String phone,
                                   @Param("gender") String gender,@Param("yob") int yob){
        Users users=new Users();
        users.setEmail(email);
        users.setPassword(password);
        users.setGender(gender);
        users.setName(name);
        users.setPhone(phone);
        users.setYob(yob);
        return usersService.updateUsersInfo(users);
    }
    @RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
    public boolean checkEmailAvailable(HttpServletRequest request,
                                       @Param("email") String email){
        return usersService.checkEmailAvailable(email);
    }
}
