package com.my.Service;

import com.my.dao.MessageMapper;
import com.my.pojo.Message;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 1:33 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageServiceMapper;
    @Override
    public boolean sendMessage(Message message) {
        try{
            messageServiceMapper.insert(message);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
