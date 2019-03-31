package com.my.Service;

import com.my.dao.CheckinMapper;
import com.my.dao.CheckresultMapper;
import com.my.pojo.Checkin;
import com.my.pojo.CheckinExample;
import com.my.pojo.Checkresult;
import com.my.pojo.CheckresultExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 2:05 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class CheckinServiceImpl implements CheckinService {
    @Autowired
    private CheckinMapper checkinMapper;
    @Autowired
    private CheckresultMapper checkresultMapper;
    @Override
    public boolean addCheckin(Checkin checkin) {
        try{
            checkinMapper.insert(checkin);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCheckin(Checkin checkin) {
        try{
            checkinMapper.updateByPrimaryKey(checkin);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Checkin getCheckinByChid(String chid) {
        return checkinMapper.selectByPrimaryKey(Integer.parseInt(chid));
    }


    @Override
    public String checkinCode(int cid) {
        CheckinExample checkinExample=new CheckinExample();
        checkinExample.or().andCourseidEqualTo(cid).andIsopenEqualTo("Y");
//        Checkin ci=checkinMapper.selectByExample(checkinExample).get(0);
        if (checkinMapper.selectByExample(checkinExample).isEmpty()){
            return "0000";
        }
        return checkinMapper.selectByExample(checkinExample).get(0).getCheckcode();
    }

    @Override
    public List<Checkin> teachergetCheckinRecords(int cid) {
        CheckinExample checkinExample=new CheckinExample();
        checkinExample.or().andCourseidEqualTo(cid);
        List<Checkin> list = checkinMapper.selectByExample(checkinExample);
        return list;
    }

    @Override
    public List<Checkresult> getCRInfo(int cid, int uid) {
        CheckresultExample checkresultExample=new CheckresultExample();
        CheckinExample checkinExample=new CheckinExample();
        checkinExample.or().andCourseidEqualTo(cid);
        List<Checkin> checkins=checkinMapper.selectByExample(checkinExample);
        List<Integer> chids=new ArrayList<>();
        for (Checkin checkin:checkins){
            chids.add(checkin.getChid());
        }
        checkresultExample.or().andChidIn(chids).andUidEqualTo(uid);
        List<Checkresult> checkresults=checkresultMapper.selectByExample(checkresultExample);
        return checkresults;
    }

}
