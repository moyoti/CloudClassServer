package com.my.Service;

import com.my.dao.NoticeMapper;
import com.my.pojo.Notice;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dongqihang
 * @Date: Created in 1:30 2019/2/25
 */
@Service
@MapperScan("com.my.dao")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public boolean addNotice(Notice notice) {
        try{
            noticeMapper.insert(notice);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteNotice(Notice notice) {
        try {
            noticeMapper.deleteByPrimaryKey(notice.getNid());
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
