package com.my.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.my.Service.CheckinResultService;
import com.my.Service.CheckinService;
import com.my.Service.MemberService;
import com.my.pojo.Checkin;
import com.my.pojo.Checkresult;
import com.my.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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
                           @RequestParam("cid")int cid,@RequestParam("checkcode")String checkCode,
                           @RequestParam("checktime")String checkTime){
        Checkin checkin=new Checkin();
        checkin.setCourseid(cid);
        checkin.setCheckcode(checkCode);
        checkin.setChecktime(Timestamp.valueOf(checkTime));
        checkin.setIsopen("Y");
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
    @RequestMapping(value = "/getusersnamebychid",method = RequestMethod.POST)
    public List getUsersNameBychid(@RequestParam("chid")String chid){
        return checkinResultService.getUsersNameBychid(Integer.valueOf(chid));
    }
    @RequestMapping(value = "/getcheckinbycid",method = RequestMethod.POST)
    public List getCheckinByCid(@RequestParam("cid")String cid){
        return checkinService.getCourseCheckin(Integer.valueOf(cid));
    }
    @RequestMapping(value = "/getuserscheckinfo",method = RequestMethod.POST)
    public List getUsersClassCheckInfo(@RequestParam("cid")String cid,@RequestParam("uid")String uid){
        return checkinService.getCRInfo(Integer.valueOf(cid),Integer.valueOf(uid));
    }
    @RequestMapping(value = "/userscheckin",method = RequestMethod.POST)
    public boolean usersCheckIn(@RequestParam("result")String re){
        JSONArray ja= JSON.parseArray(re);
        Checkresult cr=new Checkresult();
        for (int i=0;i<ja.size();i++){
            JSONObject jo;
            jo= (JSONObject) ja.get(i);
            cr.setUid(jo.getInteger("uid"));
            cr.setStatus(jo.getString("status"));
            cr.setChid(jo.getInteger("chid"));
            cr.setChtime(new Date());
            if (!checkinResultService.addCheckinResult(cr)){
                return false;
            }
        }
        return true;
    }
    @RequestMapping(value = "/startcheckin",method = RequestMethod.POST)
    public int startCheckIn(@RequestParam("cid")String cid,@RequestParam("checkcode")String checkCode,
                            @RequestParam("checktime")String checkTime){
        Checkin checkin=new Checkin();
        checkin.setCourseid(Integer.valueOf(cid));
        checkin.setCheckcode(checkCode);
        checkin.setChecktime(Timestamp.valueOf(checkTime));
        checkin.setIsopen("Y");
        if (checkinService.addCheckin(checkin)){
            return checkin.getChid();
        }
        return 0;
    }

    @RequestMapping(value = "/closecheckin",method = RequestMethod.POST)
    public boolean closedCheckin(HttpServletRequest request,
                                 @RequestParam("cid") int cid){
        Checkin checkin=new Checkin();
        checkin.setCourseid(cid);
        checkin.setIsopen("0");
        return checkinService.updateCheckin(checkin);
    }
    @RequestMapping(value = "/opencheckin",method = RequestMethod.POST)
    public boolean openCheckin(HttpServletRequest request,
                               @RequestParam("cid")int cid){
        Checkin checkin=new Checkin();
        checkin.setCourseid(cid);
        checkin.setIsopen("1");
        return checkinService.updateCheckin(checkin);
    }
    @RequestMapping(value = "/getcheckincode",method = RequestMethod.POST)
    public String getCheckInCode(@RequestParam("cid")String cid){
        return checkinService.checkinCode(Integer.valueOf(cid));
    }
    //需要传入修改的状态
    @RequestMapping(value = "/changestatus",method = RequestMethod.POST)
    public boolean changeStatus(HttpServletRequest request,
                                @RequestParam("uid")int uid,@RequestParam("chid") int chid,
                                @RequestParam("status")String status){
        Checkresult checkresult=new Checkresult();
        checkresult.setChid(chid);
        checkresult.setChtime(new Date());
        checkresult.setStatus(status);
        checkresult.setUid(uid);
        return checkinResultService.updateCheckinResult(checkresult);
    }
}
