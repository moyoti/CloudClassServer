package com.my.Service;


import com.my.dao.CourseMapper;
import com.my.dao.UsersMapper;
import com.my.pojo.*;
import com.my.dao.MemberMapper;
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
            memberExample.or().andCidEqualTo(cid).andRoleEqualTo("S");
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
    public List<CourseItem> getJoinedCourse(int uid) {
        try{
            MemberExample memberExample=new MemberExample();
            memberExample.or().andUidEqualTo(uid).andRoleEqualTo("S");
            List<Member> memberList=memberMapper.selectByExample(memberExample);
            List<Course> courseList=new ArrayList<>();
            List<CourseItem> courseItems=new ArrayList<>();
            for(Member member:memberList){
                courseList.add(courseMapper.selectByPrimaryKey(member.getCid()));
            }
            for (Course item:courseList){
                CourseItem courseItem=new CourseItem();
                courseItem.setCourse(item);
                courseItem.setTeacherName(usersMapper.selectByPrimaryKey(item.getTeacher()).getName());
                courseItems.add(courseItem);
            }
            return courseItems;
        }catch (Exception e){
            return null;
        }
    }

    //todo 除这两个字段其他字段如何处理,还需要检查用户是否已经参与到班课中,controller目前还没添加相应接口
    @Override
    public boolean joinClass(int uid, int cid, String role, String name) {
        Member member=new Member();
        member.setCid(cid);
        member.setUid(uid);
        member.setName(name);
        member.setRole(role);
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

    @Override
    public List<Member> getMembersById(int uid) {
        try{
            MemberExample memberExample=new MemberExample();
            memberExample.or().andUidEqualTo(uid);
            List<Member> memberList=memberMapper.selectByExample(memberExample);
            return memberList;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean updateMember(Member m) {
        //更新member表姓名
        try{
            memberMapper.updateByPrimaryKey(m);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
