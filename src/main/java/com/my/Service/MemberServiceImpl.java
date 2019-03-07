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

    //todo 除这两个字段其他字段如何处理,还需要检查用户是否已经参与到班课中,controller目前还没添加相应接口
    @Override
    public boolean joinClass(int uid, int cid) {
        Member member=new Member();
        member.setCid(cid);
        member.setUid(uid);
        try{
            memberMapper.insert(member);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean exitClass(int uid, int cid) {
        MemberExample memberExample=new MemberExample();
        memberExample.or().andCidEqualTo(cid).andUidEqualTo(uid);
        int rows=memberMapper.deleteByExample(memberExample);
        if(rows>0){
            return true;
        }else {
            return false;
        }
    }

}
