package com.my.Service;

import com.my.pojo.Course;
import com.my.pojo.CourseItem;
import com.my.pojo.Users;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 1:49 2019/2/25
 */
public interface MemberService {
    List<Users> getClassMember(int cid);
    List<CourseItem> getJoinedCourse(int uid);
    boolean joinClass(int uid,int cid,String role, String name);
    boolean exitClass(int uid,int cid);
}
