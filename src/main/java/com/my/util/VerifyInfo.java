package com.my.util;

/**
 * @Author: dongqihang
 * @Date: Created in 13:04 2018/10/25
 */
public class VerifyInfo {
    private static String emailRegex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
    private static String phoneRegex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
    private static String UNAndPassRegex="^[a-zA-Z\\d]\\w{2,10}[a-zA-Z\\d]$";
    public static boolean verifyEmailFormat(String email){
        if(email.matches(emailRegex)){
            return true;
        }
        return false;
    }
    public static boolean verifyPhoneFormat(String phone){
        if (phone.matches(phoneRegex)){
            return true;
        }
        return false;
    }
    public static boolean verifyUNOrPassForamt(String uop){
        if(uop.matches(UNAndPassRegex)&&uop.length()<=20&&uop.length()>=5){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        VerifyInfo vi=new VerifyInfo();
        boolean re=vi.verifyEmailFormat("dqh_ql@133.com");
        System.out.println("email:"+re);
        re=vi.verifyPhoneFormat("17865425098");
        System.out.println("phone:"+re);
        re=vi.verifyUNOrPassForamt("asdfeas#a");
        System.out.println("uop:"+re);
    }

}
