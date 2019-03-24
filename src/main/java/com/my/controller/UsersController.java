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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
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

        }catch (Exception e){
            return false;
        }
        int uid = usersService.signUp(users);
        //生成头像
        //复制
        createHeadpic(uid);
        return true;
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

    public void createHeadpic(int uid){
        File originalFile = new File("C:\\resource\\img\\head_pic\\default.jpg");//指定要读取的图片
        try {
            File result = new File("C:\\resource\\img\\head_pic\\"+uid+".jpg");//要写入的图片
            if (result.exists()) {//校验该文件是否已存在
                result.delete();//删除对应的文件，从磁盘中删除
                result = new File("C:\\resource\\img\\head_pic\\"+uid+".jpg");//只是创建了一个File对象，并没有在磁盘下创建文件
            }
            if (!result.exists()) {//如果文件不存在
                result.createNewFile();//会在磁盘下创建文件，但此时大小为0K
            }
            FileInputStream in = new FileInputStream(originalFile);
            FileOutputStream out = new FileOutputStream(result);// 指定要写入的图片
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }
            //执行完以上后，磁盘下的该文件才完整，大小是实际大小
            out.close();// 关闭输入输出流
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
