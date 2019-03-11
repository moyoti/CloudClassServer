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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public String[] usersLogin(HttpServletRequest request, @RequestParam("email") String email, @RequestParam("password") String password) {
        Users users = new Users();
        users.setEmail(email);
        users.setPassword(password);
        System.out.println(email);
        System.out.println(password);
        int id = -1;
        boolean correct = usersService.login(users);
        if(correct) {
             id = usersService.getUidByEmail(email);
        }
        String[] result = {id+"",correct+""};
        return result;
    }

    @RequestMapping(value = "/loginpc", method = RequestMethod.POST)
    public boolean usersLoginpc(HttpServletRequest request, @RequestParam("email") String email, @RequestParam("password") String password) {

        Users users = new Users();
        users.setEmail(email);
        users.setPassword(password);
        System.out.println(email);
        System.out.println(password);
        System.out.println(usersService.login(users));
        if(usersService.login(users)){
            HttpSession session = request.getSession();
            session.setAttribute("username",email);
        }

        return usersService.login(users);
    }

    @RequestMapping(value = "/logoutpc", method = RequestMethod.POST)
    public boolean usersLogoutpc(HttpServletRequest request, @RequestParam("email") String email, @RequestParam("password") String password) {

        HttpSession session = request.getSession();
        session.setAttribute("username","");

        return true;
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
                emailSender.send("[云课堂]","您的验证码是："+validationcode,new String[]{email});
            }catch (Exception e){
                e.printStackTrace();
                return "error";
            }

            return validationcode;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateUsersInfo(HttpServletRequest request,
                                   @RequestParam("uid") String uid,@RequestParam("email") String email,@RequestParam("password") String password,
                                   @RequestParam("name") String name, @RequestParam("phone")String phone,
                                   @RequestParam("gender") String gender){
        Users users=new Users();
        users.setEmail(email);
        users.setPassword(password);
        users.setUid(Integer.parseInt(uid));
        users.setGender(gender);
        users.setName(name);
        users.setPhone(phone);
        return usersService.updateUsersInfo(users);
    }

    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
    public boolean updatePassword(HttpServletRequest request,
                                   @RequestParam("password") String password,@RequestParam("uid") String uid
                                   ){
        Users users= usersService.getUsersInfo(Integer.parseInt(uid));
        users.setPassword(password);

        return usersService.updateUsersInfo(users);
    }

    @RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
    public boolean resetPassword(HttpServletRequest request,
                                  @RequestParam("password") String password,@RequestParam("email") String email
    ){
        System.out.println(email);
        System.out.println(password);
        int uid = usersService.getUidByEmail(email);
        Users users= usersService.getUsersInfo(uid);
        users.setPassword(password);

        return usersService.updateUsersInfo(users);
    }
    @RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
    public boolean checkEmailAvailable(HttpServletRequest request,
                                       @Param("email") String email){
        return usersService.checkEmailAvailable(email);
    }
    @RequestMapping(value = "/getuidbyemail",method = RequestMethod.POST)
        public int getUidByEmail(@RequestParam("email")String email){
            System.out.println("Email is "+email);
        System.out.println(usersService.getUidByEmail(email));
        return usersService.getUidByEmail(email);
    }

    @RequestMapping(value = "/getuserinfo",method = RequestMethod.POST)
    public List<Users> getUser(@RequestParam("uid")String uid){
        System.out.println("Uid is :" + uid);
        int id = Integer.parseInt(uid);
        List<Users> list = new ArrayList<>();
        list.add(usersService.getUsersInfo(id));
        return list;
    }
}
