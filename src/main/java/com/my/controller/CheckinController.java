package com.my.controller;

import com.my.Service.CheckinResultService;
import com.my.Service.CheckinService;
import com.my.Service.MemberService;
import com.my.pojo.Checkin;
import com.my.pojo.Checkresult;
import com.my.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 11:47 2019/2/25
 */
@RestController
@RequestMapping(value = "/checkin")
public class CheckinController {
    @Autowired
    private CheckinService checkinService;
    @Autowired
    private CheckinResultService checkinResultService;
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/addcheckin",method = RequestMethod.POST)
    public boolean checkin(HttpServletRequest request,
                           @Param("cid")int cid){
        Checkin checkin=new Checkin();
        checkin.setCourseid(cid);
        checkin.setIsopen("1");
        List<Users> usersList = memberService.getClassMember(cid);
        if(checkinService.addCheckin(checkin)){
            for(Users users:usersList){
                Checkresult checkresult=new Checkresult();
                checkresult.setChid(checkin.getChid());
                checkresult.setChtime(new Date());
                checkresult.setStatus("0");
                checkresult.setUid(users.getUid());
                checkinResultService.addCheckinResult(checkresult);
            }
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/closecheckin",method = RequestMethod.POST)
    public boolean closedCheckin(HttpServletRequest request,
                                 @Param("cid") int cid){
        Checkin checkin=new Checkin();
        checkin.setCourseid(cid);
        checkin.setIsopen("0");
        return checkinService.updateCheckin(checkin);
    }
    @RequestMapping(value = "/opencheckin",method = RequestMethod.POST)
    public boolean openCheckin(HttpServletRequest request,
                               @Param("cid")int cid){
        Checkin checkin=new Checkin();
        checkin.setCourseid(cid);
        checkin.setIsopen("1");
        return checkinService.updateCheckin(checkin);
    }
    //需要传入修改的状态
    @RequestMapping(value = "/changestatus",method = RequestMethod.POST)
    public boolean changeStatus(HttpServletRequest request,
                                @Param("uid")int uid,@Param("chid") int chid,
                                @Param("status")String status){
        Checkresult checkresult=new Checkresult();
        checkresult.setChid(chid);
        checkresult.setChtime(new Date());
        checkresult.setStatus(status);
        checkresult.setUid(uid);
        return checkinResultService.updateCheckinResult(checkresult);
    }
}
