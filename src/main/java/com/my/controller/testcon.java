package com.my.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dongqihang
 * @Date: Created in 13:14 2019/1/18
 */
@RestController
@RequestMapping(value = "/test")
public class testcon {
    @RequestMapping(value = "/testurl",method = RequestMethod.GET)
    public String testurl(){
        return "testSuccess";
    }
}
