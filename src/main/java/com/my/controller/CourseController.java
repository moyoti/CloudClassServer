package com.my.controller;

import com.my.Service.CourseService;
import com.my.Service.MemberService;
import com.my.pojo.Course;
import com.my.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
                                @Param("cname")String cname,@Param("cover")String cover,
                                @Param("semester") String semester,@Param("canjoin") String canjoin,
                                @Param("teacher")int teacher,@Param("profile")String profile){
        Course course=new Course();
        course.setCanjoin(canjoin);
        course.setCname(cname);
        course.setProfile(profile);
        course.setTeacher(teacher);
        course.setSemester(semester);
        course.setCover(cover);
        return courseService.CreateCourse(course);
    }
    @RequestMapping(value = "/getjoinedcourse",method = RequestMethod.POST)
    public List<Course> getJoinedCourse(HttpServletRequest request,
                                        @Param("uid")int uid){
        return memberService.getJoinedCourse(uid);
    }
    @RequestMapping(value = "/getstudents",method = RequestMethod.POST)
    public List<Users> getStudents(HttpServletRequest request,
                                   @Param("cid")int cid){
        return memberService.getClassMember(cid);
    }
}
