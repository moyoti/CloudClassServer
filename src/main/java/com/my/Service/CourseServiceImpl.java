package com.my.Service;

import com.my.dao.CourseMapper;
import com.my.dao.UsersMapper;
import com.my.pojo.Course;
import com.my.pojo.CourseExample;
import com.my.pojo.Users;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 1:43 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public boolean CreateCourse(Course course) {
        try{
            courseMapper.insert(course);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean DeleteCourse(Course course) {
        try{
            courseMapper.deleteByPrimaryKey(course.getCid());
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<Course> getCreateCourse(int uid) {
        CourseExample courseExample=new CourseExample();
        courseExample.or().andTeacherEqualTo(uid);
        List<Course> courseList=courseMapper.selectByExample(courseExample);
        return courseList;
    }

    @Override
    public boolean checkCourseExist(int cid) {
        CourseExample courseExample=new CourseExample();
        courseExample.or().andCidEqualTo(cid);
        List<Course> courseList=courseMapper.selectByExample(courseExample);
        if(courseList.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public Course searchCourse(int cid) {
        CourseExample courseExample=new CourseExample();
        courseExample.or().andCidEqualTo(cid);
        List<Course> courseList=courseMapper.selectByExample(courseExample);
        return courseList.get(0);
    }

    @Override
    public int updateCourseInfo(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }
}
