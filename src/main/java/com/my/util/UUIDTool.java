package com.my.util;

import com.my.pojo.Users;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: dongqihang
 * @Date: Created in 17:13 2018/11/7
 */
public class UUIDTool {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

//    public static void reflectObject(Object o){
//        for (Field f :
//                o.getClass().getDeclaredFields()) {
//            f.setAccessible(true);
//            try {
//                Constructor constructor=f.getType().getClass().getConstructor();
//                List<Class> classes=new ArrayList<>();
//                for (Parameter p :
//                        constructor.getParameters()) {
//                    classes.add(ClassLoader.getSystemClassLoader().loadClass(p.getName()));
//                }
//                List<Object> objects=new ArrayList<>();
//                for (Class c :
//                        classes) {
//                    objects.add(c.newInstance());
//                }
//                Object s=constructor.newInstance(objects.toArray());
//                if(f.getType().getClass() instanceof Object){
//                    s=f.get(s);
//                }
//                if(!s.equals(null)||!s.equals("")){
//                    System.out.println(f.getName()+":");
//                    System.out.print(s);
//                }
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(getUUID());
//        String x = null;
//        if(x!=null&&x.equals("1")){
//            System.out.println(x);
//        }
        Users users=new Users();
        users.setName("test1");
        for (Field f :
                users.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object o= f.get(users);
            if(o!=null){
                System.out.println(f.getName()+":"+o);
            }
        }
//        T s=new Object();
//        for (Field f :
//                users.getClass().getDeclaredFields()) {
//            try {
//                f.setAccessible(true);
//
//                if(!f.getType().getClass().newInstance().toString().equals(null)){
//                    System.out.println(f.getName()+":");
//                    System.out.print(s);
//                }
////                System.out.println(f.getName());
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Users.class.getFields().toString());
    }
}
