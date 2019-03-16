package com.my.controller;

import com.my.Service.CourseService;
import com.my.Service.HomeworkService;
import com.my.Service.MemberService;
import com.my.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 22:37 2019/3/8
 */
@RestController
@RequestMapping(value = "/homework")
public class HomeworkController {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/addhomework",method = RequestMethod.POST)
    public boolean addHomework(@RequestParam("status")String status,@RequestParam("cid")String cid,@RequestParam("profile")String profile,
//                               @RequestParam("starttime")String startTime,@RequestParam("endtime")String endTime,
                               @RequestParam("question")String question,@RequestParam("value")String value){
        try{
            Homework homework=new Homework();
            homework.setStatus(status);
            homework.setCid(Integer.valueOf(cid));
            homework.setProfile(profile);
            homework.setValue(Integer.parseInt(value));
            homework.setQuestion(question);
            int id = homeworkService.addHomework(homework);
            //homeworkresult表插入全班数据
            List<Users> memberlist = memberService.getClassMember(Integer.parseInt(cid));
            for(int i = 0; i<memberlist.size();i++){
                Homeworkresult result = new Homeworkresult();
                result.setValue(-2);
                result.setHid(id);
                result.setUid(memberlist.get(i).getUid());
                result.setAnswer("");
                homeworkService.doHomework(result);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping(value = "/closehomework",method = RequestMethod.POST)
    public boolean closeHomework(@RequestParam("hid")String hid){
        try{
            //todo 作业状态有哪些？
            Homework homework = homeworkService.getHomeworkById(Integer.parseInt(hid));
            homework.setStatus("concluded");
            homeworkService.updateHomework(homework);
//            homeworkService.closeHomework()
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping(value = "/updatestatus",method = RequestMethod.POST)
    public boolean updateStatus(@RequestParam("hid")String hid,@RequestParam("status")String status){
        try{
//            Homework homework=new Homework();
//            homework.setHid(Integer.valueOf(hid));
            Homework homework=homeworkService.getHomeworkById(Integer.valueOf(hid));
            homework.setStatus(status);
            homeworkService.updateHomework(homework);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping(value = "/gethomeworks",method = RequestMethod.POST)
    public List<Homework> getHomeworksById(@RequestParam("cid")String cid){
        return homeworkService.getHomeworksById(Integer.valueOf(cid));
    }
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public boolean updateHomeworkInfo(@RequestParam("status")String status,@RequestParam("question")String question,
                                      @RequestParam("hid")String hid,@RequestParam("value")String value,@RequestParam("profile")String profile){
        try{
            //todo 测试update用法，观察更新后cid是否改变
            Homework homework=homeworkService.getHomeworkById(Integer.parseInt(hid));
            homework.setValue(Integer.parseInt(value));
            homework.setProfile(profile);
            homework.setStatus(status);
            homework.setQuestion(question);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping(value = "/getresult",method = RequestMethod.POST)
    public List getResult(@RequestParam("hid")String hid){
        return homeworkService.getResults(Integer.valueOf(hid));
    }

    @RequestMapping(value = "/gethomeworkbyid",method = RequestMethod.POST)
    public List<Homework> getHomework(@RequestParam("hid")String hid){
        List<Homework> list = new ArrayList<>();
        list.add(homeworkService.getHomeworkById(Integer.valueOf(hid)));
        return list;
    }

    @RequestMapping(value = "/doHomework",method = RequestMethod.POST)
    public boolean doHomework(@RequestParam("hrid")String hrid,@RequestParam("answer")String answer){
        Homeworkresult homeworkresult=homeworkService.getHomeworkResult(Integer.parseInt(hrid));
        homeworkresult.setAnswer(answer);
        homeworkresult.setValue(-1);
        homeworkService.doHomework(homeworkresult);
        return true;
    }

    @RequestMapping(value = "/deletehomework",method = RequestMethod.POST)
    public boolean deletehomework(@RequestParam("hid")String hid, @RequestParam("code")String code){
        if(code.equals("1")) {
            return homeworkService.deleteHomework(Integer.parseInt(hid));
        }else{
            //todo 删除homework和homeworkresult相关数据
            return homeworkService.deleteHomework(Integer.parseInt(hid));
        }
    }

    @RequestMapping(value = "/gethomeworkresult",method = RequestMethod.POST)
    public List<Homeworkresult> gethomeworkresult(@RequestParam("hid")String hid, @RequestParam("uid")String uid){
        int hrid = homeworkService.getIdByuidhid(Integer.parseInt(uid),Integer.parseInt(hid));
//        System.out.println("hrid is "+hrid);
        List<Homeworkresult> list = new ArrayList<>();
        list.add(homeworkService.getHomeworkResult(hrid));
        return list;
    }

    @RequestMapping(value = "/getcheckhomework",method = RequestMethod.POST)
    public List<CheckhomeworkItem> getcheckhomework(@RequestParam("hrid")String hrid){
        List<CheckhomeworkItem> list = new ArrayList<>();
        CheckhomeworkItem item = new CheckhomeworkItem();

        Homeworkresult hr = homeworkService.getHomeworkResult(Integer.parseInt(hrid));
        item.setHrid(hr.getHrid());
        item.setAnswer(hr.getAnswer());
        item.setScore(hr.getValue());

        Homework homework = homeworkService.getHomeworkById(hr.getHid());
        item.setTitle(homework.getQuestion());
        item.setProfile(homework.getProfile());
        item.setValue(homework.getValue());

        list.add(item);
        return list;
    }

    @RequestMapping(value = "/checkhomework",method = RequestMethod.POST)
    public boolean checkhomeworkresult(@RequestParam("hrid")String hrid, @RequestParam("score")String score){
        Homeworkresult homeworkresult = homeworkService.getHomeworkResult(Integer.parseInt(hrid));
        homeworkresult.setValue(Integer.parseInt(score));

        return homeworkService.doHomework(homeworkresult);
    }

    @RequestMapping(value = "/studentgethomeworkresult",method = RequestMethod.POST)
    public List<Homeworkresult> studentgethomeworkresult(@RequestParam("hid")String hid, @RequestParam("uid")String uid){
        List<Homeworkresult> list = new ArrayList<>();
        int hrid = homeworkService.getIdByuidhid(Integer.parseInt(uid),Integer.parseInt(hid));
        list.add(homeworkService.getHomeworkResult(hrid));
        return list;
    }


}
