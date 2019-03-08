package com.my.controller;

import com.my.Service.CourseService;
import com.my.Service.MemberService;
import com.my.pojo.Course;
import com.my.pojo.CourseItem;
import com.my.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 11:36 2019/2/25
 */
@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private MemberService memberService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    //todo cover的上传稍后做，先传入一个String初期尝试
    public boolean createCourse(HttpServletRequest request,
                                @RequestParam("cname")String cname,@RequestParam("cover")String cover,
                                @RequestParam("semester") String semester,@RequestParam("canjoin") String canjoin,
                                @RequestParam("teacher")int teacher,@RequestParam("profile")String profile){
        Course course=new Course();
        course.setCanjoin(canjoin);
        course.setCname(cname);
        course.setProfile(profile);
        course.setTeacher(teacher);
        course.setSemester(semester);
        course.setCover(cover);
        return courseService.CreateCourse(course);
    }
    @RequestMapping(value = "/getallclass",method = RequestMethod.POST)
    public List<CourseItem> getAllClass(@RequestParam("uid")int uid){
        List<CourseItem> courseItems=new ArrayList<>();
        courseItems.addAll(courseService.getCreateCourse(uid));
        courseItems.addAll(memberService.getJoinedCourse(uid));
        return courseItems;
    }
    @RequestMapping(value = "/getjoinedcourse",method = RequestMethod.POST)
    public List<CourseItem> getJoinedCourse(HttpServletRequest request,
                                            @RequestParam("uid")int uid){
        return memberService.getJoinedCourse(uid);
    }
    @RequestMapping(value = "/getcreatecourse",method = RequestMethod.POST)
    public List<CourseItem> getCreateCourse(@RequestParam("uid")int uid){
        return courseService.getCreateCourse(uid);
    }
    @RequestMapping(value = "/checkclassexist", method = RequestMethod.POST)
    public boolean checkClassExist(@RequestParam("cid")int cid){
        return courseService.checkCourseExist(cid);
    }
    @RequestMapping(value = "/exitclass",method = RequestMethod.POST)
    public boolean exitClass(@RequestParam("uid")int uid,@RequestParam("cid")int cid){
        return memberService.exitClass(uid,cid);
    }
    @RequestMapping(value = "/getstudents",method = RequestMethod.POST)
    public List<Users> getStudents(HttpServletRequest request,
                                   @RequestParam("cid")int cid){
        return memberService.getClassMember(cid);
    }
    //todo 封面先传一个String，上传图片之后做
    @RequestMapping(value = "/updatecourse",method = RequestMethod.POST)
    public boolean updateCourse(@RequestParam("cid")int cid,@RequestParam("profile")String profile,
                                @RequestParam("cover")String cover,@RequestParam("semester")String semester,
                                @RequestParam("canjoin")String canjoin,@RequestParam("cname")String cname){
        Course course=new Course();
        course.setCover(cover);
        course.setCid(cid);
        course.setCname(cname);
        course.setCanjoin(canjoin);
        course.setSemester(semester);
        course.setProfile(profile);
        int updatere=courseService.updateCourseInfo(course);
        if(updatere>0){
            return true;
        }else {
            return false;
        }
    }
}
