package com.my.Service;

import com.my.dao.CheckinMapper;
import com.my.dao.CheckresultMapper;
import com.my.dao.UsersMapper;
import com.my.pojo.Checkresult;
import com.my.pojo.CheckresultExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 2:07 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class CheckinResultServiceImpl implements  CheckinResultService{
    @Autowired
    private CheckresultMapper checkresultMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public boolean addCheckinResult(Checkresult checkresult) {
        try{
            checkresultMapper.insert(checkresult);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCheckinResult(Checkresult checkresult) {
        try{
            checkresultMapper.updateByPrimaryKey(checkresult);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<String> getUsersNameBychid(int chid) {
        CheckresultExample checkresultExample=new CheckresultExample();
        checkresultExample.or().andChidEqualTo(chid);
        List<Checkresult> checkresults=checkresultMapper.selectByExample(checkresultExample);
        List<String> usersNames=new ArrayList<>();
        for (Checkresult item :
                checkresults) {
            usersNames.add(usersMapper.selectByPrimaryKey(item.getUid()).getName());
        }
        return usersNames;
    }

}
