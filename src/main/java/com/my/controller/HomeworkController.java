package com.my.controller;

import com.my.Service.HomeworkService;
import com.my.pojo.Homework;
import com.my.pojo.Homeworkresult;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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

    @RequestMapping(value = "/addhomework",method = RequestMethod.POST)
    public boolean addHomework(@RequestParam("status")String status,@RequestParam("cid")String cid,@RequestParam("profile")String profile,
//                               @RequestParam("starttime")String startTime,@RequestParam("endtime")String endTime,
                               @RequestParam("question")String question,@RequestParam("value")String value){
        try{
            Homework homework=new Homework();
            homework.setStatus(status);
            homework.setCid(Integer.valueOf(cid));
//            homework.setEndtime(Date.valueOf(endTime));
//            homework.setStarttime(Date.valueOf(startTime));
            homework.setQuestion(question);
            homeworkService.addHomework(homework);
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
    public boolean doHomework(@RequestParam("uid")String uid,@RequestParam("hid")String hid,
                              @RequestParam("answer")String answer){
        Homeworkresult homeworkresult=new Homeworkresult();
        homeworkresult.setHid(Integer.valueOf(hid));
        homeworkresult.setUid(Integer.valueOf(uid));
        homeworkresult.setAnswer(answer);
        homeworkresult.setValue(0);
        homeworkService.doHomework(homeworkresult);
        return true;
    }

    @RequestMapping(value = "/deletehomework",method = RequestMethod.POST)
    public boolean deletehomework(@RequestParam("hid")String hid, @RequestParam("code")String code){
        if(code.equals("1")) {
            return homeworkService.deleteHomework(Integer.parseInt(hid));
        }else{
            //删除homework和homeworkresult相关数据
            return homeworkService.deleteHomework(Integer.parseInt(hid));
        }
    }


}
