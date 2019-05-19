package com.my.Service;

import com.my.dao.HomeworkMapper;
import com.my.dao.HomeworkresultMapper;
import com.my.dao.UsersMapper;
import com.my.pojo.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 1:35 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private HomeworkresultMapper homeworkresultMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public int addHomework(Homework homework) {
        try{
            homeworkMapper.insert(homework);
            int id = homework.getHid();
            return id;
        }catch (Exception e){
            return -1;
        }
    }

    //todo status都有哪些状态？
    @Override
    public boolean closeHomework(Homework homework) {
        try{
            Homework homework1=homeworkMapper.selectByPrimaryKey(homework.getHid());
            //homework1.setStatus();
            homeworkMapper.updateByPrimaryKey(homework);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateHomework(Homework homework) {
        try{
            homeworkMapper.updateByPrimaryKey(homework);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Homework getHomeworkById(int hid) {
        return homeworkMapper.selectByPrimaryKey(hid);
    }

    @Override
    public List<Homework> getHomeworksById(int cid) {
        HomeworkExample homeworkExample=new HomeworkExample();
        homeworkExample.or().andCidEqualTo(cid);
        return homeworkMapper.selectByExample(homeworkExample);
    }

    @Override
    public boolean deleteHomework(int hid) {
        try{
            homeworkMapper.deleteByPrimaryKey(hid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<HomeworkResultItem> getResults(int hid) {
        HomeworkresultExample homeworkresultExample=new HomeworkresultExample();
        homeworkresultExample.or().andHidEqualTo(hid);
        List<Homeworkresult> hrl=homeworkresultMapper.selectByExample(homeworkresultExample);
        List<HomeworkResultItem> hril=new ArrayList<>();
        for (Homeworkresult item :
                hrl) {
            HomeworkResultItem hri=new HomeworkResultItem();
            Users users=usersMapper.selectByPrimaryKey(item.getUid());
            hri.setHomeworkresult(item);
            hri.setUsers(users);
            hril.add(hri);
        }
        return hril;
    }

    @Override
    public List<HomeworkResultItem> getResultsByUser(int uid) {
        HomeworkresultExample homeworkresultExample=new HomeworkresultExample();
        homeworkresultExample.or().andUidEqualTo(uid);
        List<Homeworkresult> hrl=homeworkresultMapper.selectByExample(homeworkresultExample);
        List<HomeworkResultItem> hril=new ArrayList<>();
        for (Homeworkresult item :
                hrl) {
            HomeworkResultItem homeworkResultItem=new HomeworkResultItem();
            homeworkResultItem.setHomeworkresult(item);
            homeworkResultItem.setUsers(usersMapper.selectByPrimaryKey(uid));
            hril.add(homeworkResultItem);
        }
        return hril;
    }

    @Override
    public boolean doHomework(Homeworkresult homeworkresult) {
        try{
            HomeworkresultExample homeworkresultExample=new HomeworkresultExample();
            homeworkresultExample.or().andUidEqualTo(homeworkresult.getHid()).andHidEqualTo(homeworkresult.getHid());
            if(homeworkresult.getHrid()==null){
                homeworkresultMapper.insert(homeworkresult);
            }else{
                homeworkresultMapper.updateByPrimaryKey(homeworkresult);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public int getIdByuidhid(int uid, int hid) {
        System.out.println("Uid is "+uid);
        System.out.println("His is "+hid);
        HomeworkresultExample homeworkresultExample=new HomeworkresultExample();
        homeworkresultExample.or().andUidEqualTo(uid).andHidEqualTo(hid);

        return homeworkresultMapper.selectByExample(homeworkresultExample).get(0).getHrid();
    }

    @Override
    public Homeworkresult getHomeworkResult(int hrid) {
        return homeworkresultMapper.selectByPrimaryKey(hrid);
    }
}
