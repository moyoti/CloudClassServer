package com.my.Service;

import com.my.dao.CourseMapper;
import com.my.dao.UsersMapper;
import com.my.pojo.Course;
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

    //todo cid改回int
    @Override
    public boolean DeleteCourse(Course course) {
        try{
            courseMapper.deleteByPrimaryKey(course.getCid());
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
