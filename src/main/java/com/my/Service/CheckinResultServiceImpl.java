package com.my.Service;

import com.my.dao.CheckinMapper;
import com.my.dao.CheckresultMapper;
import com.my.pojo.Checkresult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 2:07 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class CheckinResultServiceImpl implements  CheckinResultService{
    @Autowired
    private CheckresultMapper checkresultMapper;
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
}
