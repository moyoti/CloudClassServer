package com.my.Service;

import com.my.pojo.Notice;

/**
 * @Author: dongqihang
 * @Date: Created in 17:14 2019/2/20
 */
public interface NoticeService {
    boolean addNotice(Notice notice);
    boolean deleteNotice(Notice notice);
}
