package com.my.Service;

import com.my.pojo.Course;
import com.my.pojo.Member;
import com.my.pojo.Users;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 15:34 2019/2/20
 */
public interface CourseService {
    boolean CreateCourse(Course course);
    boolean DeleteCourse(Course course);
    List<Course> getCreateCourse(int uid);
    boolean checkCourseExist(int cid);
    Course searchCourse(int cid);
    int updateCourseInfo(Course course);
}
