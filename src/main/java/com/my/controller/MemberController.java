package com.my.controller;

import com.my.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by williamwu on 2019/3/11.
 */
@RestController
@RequestMapping(value = "/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/joinclass", method = RequestMethod.POST)
    public boolean joinClass(HttpServletRequest request, @RequestParam("uid") String uid, @RequestParam("cid") String cid, @RequestParam("name") String name) {
        System.out.println(uid);
        System.out.println(cid);
        System.out.println(name);
        return memberService.joinClass(Integer.parseInt(uid),Integer.parseInt(cid),"S",name);
    }
}
