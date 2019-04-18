package com.my.controller;

import com.my.Service.CourseService;
import com.my.Service.MemberService;
import com.my.Service.UsersService;
import com.my.dao.UsersMapper;
import com.my.pojo.Course;
import com.my.pojo.CourseItem;
import com.my.pojo.Member;
import com.my.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UsersService usersService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    //todo cover的上传稍后做，先传入一个String初期尝试
    public int createCourse(HttpServletRequest request,
                                @RequestParam("coursename")String coursename,@RequestParam("classname")String classname,
                                @RequestParam("uid")String teacher,@RequestParam("profile")String profile,@RequestParam("personname")String personname){
        Course course=new Course();
        course.setCanjoin("Y");
        course.setClassname(classname);
        course.setCname(coursename);
        course.setProfile(profile);
        course.setTeacher(Integer.valueOf(teacher));
        int cid = courseService.CreateCourse(course);
        memberService.joinClass(Integer.parseInt(teacher),cid,"T",personname);
        return cid;
    }
    @RequestMapping(value = "/getallclass",method = RequestMethod.POST)
    public List<CourseItem> getAllClass(@RequestParam("uid")String uid){
        List<CourseItem> courseItems=new ArrayList<>();
        int reuid=Integer.valueOf(uid);
        courseItems.addAll(courseService.getCreateCourse(reuid));
        courseItems.addAll(memberService.getJoinedCourse(reuid));
        return courseItems;
    }
    @RequestMapping(value = "/getjoinedcourse",method = RequestMethod.POST)
    public List<CourseItem> getJoinedCourse(HttpServletRequest request,
                                            @RequestParam("uid")String uid){
        return memberService.getJoinedCourse(Integer.valueOf(uid));
    }
    @RequestMapping(value = "/getcreatecourse",method = RequestMethod.POST)
    public List<CourseItem> getCreateCourse(@RequestParam("uid")String uid){
        return courseService.getCreateCourse(Integer.valueOf(uid));
    }
    @RequestMapping(value = "/getcreatecoursepc",method = RequestMethod.POST)
    public List<CourseItem> getCreateCoursePC(HttpSession session){
        String email= (String) session.getAttribute("username");
        if (email==null){
            return null;
        }
        int uid=usersService.getUidByEmail(email);
        return courseService.getCreateCourse(uid);
    }
    @RequestMapping(value = "/checkclassexist", method = RequestMethod.POST)
    public List<CourseItem> checkClassExist(@RequestParam("cid")String cid){
        boolean exist = courseService.checkCourseExist(Integer.valueOf(cid));
        if(exist) {
            Course course = courseService.searchCourse(Integer.parseInt(cid));
            List<CourseItem> courseItems=new ArrayList<>();
            CourseItem courseItem=new CourseItem();
            courseItem.setCourse(course);
            courseItem.setTeacherName(usersMapper.selectByPrimaryKey(course.getTeacher()).getName());
            courseItems.add(courseItem);
            return courseItems;
        }else{
            return null;
        }
//        return courseService.checkCourseExist(Integer.valueOf(cid));
    }
    @RequestMapping(value = "/exitclass",method = RequestMethod.POST)
    public boolean exitClass(@RequestParam("uid")String uid,@RequestParam("cid")String cid){
        return memberService.exitClass(Integer.valueOf(uid),Integer.valueOf(cid));
    }
    @RequestMapping(value = "/getstudents",method = RequestMethod.POST)
    public List<Users> getStudents(HttpServletRequest request,
                                   @RequestParam("cid")String cid){
        return memberService.getClassMember(Integer.valueOf(cid));
    }
    //todo 封面先传一个String，上传图片之后做
    @RequestMapping(value = "/updatecourse",method = RequestMethod.POST)
    public boolean updateCourse(@RequestParam("cid")String cid,@RequestParam("profile")String profile,
                                @RequestParam("coursename")String coursename,@RequestParam("classname")String classname){
        Course course=courseService.searchCourse(Integer.parseInt(cid));
        course.setCname(coursename);
        course.setProfile(profile);
        course.setClassname(classname);
        int updatere=courseService.updateCourseInfo(course);
        if(updatere>0){
            return true;
        }else {
            return false;
        }
    }
}
