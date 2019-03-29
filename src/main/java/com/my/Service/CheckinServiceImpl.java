package com.my.Service;

import com.my.dao.CheckinMapper;
import com.my.pojo.Checkin;
import com.my.pojo.CheckinExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 2:05 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class CheckinServiceImpl implements CheckinService {
    @Autowired
    private CheckinMapper checkinMapper;
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
    public String checkinCode(int cid) {
        CheckinExample checkinExample=new CheckinExample();
        checkinExample.or().andCourseidEqualTo(cid).andIsopenEqualTo("Y");
        Checkin ci=checkinMapper.selectByExample(checkinExample).get(0);
        if (checkinMapper.selectByExample(checkinExample).isEmpty()){
            return "0000";
        }
        return checkinMapper.selectByExample(checkinExample).get(0).getCheckcode();
    }

}
