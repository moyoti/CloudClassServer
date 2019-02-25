package com.my.Service;


import com.my.dao.CourseMapper;
import com.my.dao.UsersMapper;
import com.my.pojo.Course;
import com.my.pojo.Member;
import com.my.pojo.Users;
import com.my.dao.MemberMapper;
import com.my.pojo.MemberExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 1:51 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Override
    //todo member表缺少唯一id
    public List<Users> getClassMember(int cid) {
        try{
            MemberExample memberExample=new MemberExample();
            memberExample.or().andCidEqualTo(cid);
            List<Member> memberList=memberMapper.selectByExample(memberExample);
            List<Users> usersList=new ArrayList<>();
            for(Member member:memberList){
                usersList.add(usersMapper.selectByPrimaryKey(member.getUid()));
            }
            return usersList;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Course> getJoinedCourse(int uid) {
        try{
            MemberExample memberExample=new MemberExample();
            memberExample.or().andUidEqualTo(uid);
            List<Member> memberList=memberMapper.selectByExample(memberExample);
            List<Course> courseList=new ArrayList<>();
            for(Member member:memberList){
                courseList.add(courseMapper.selectByPrimaryKey(member.getCid()));
            }
            return courseList;
        }catch (Exception e){
            return null;
        }
    }
}
