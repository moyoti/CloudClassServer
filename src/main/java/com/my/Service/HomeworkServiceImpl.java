package com.my.Service;

import com.my.dao.HomeworkMapper;
import com.my.pojo.Homework;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: dongqihang
 * @Date: Created in 1:35 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Override
    public boolean addHomework(Homework homework) {
        try{
            homeworkMapper.insert(homework);
            return true;
        }catch (Exception e){
            return false;
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
}
