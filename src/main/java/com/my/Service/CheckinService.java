package com.my.Service;

import com.my.pojo.Checkin;

/**
 * @Author: dongqihang
 * @Date: Created in 16:33 2019/2/20
 */
public interface CheckinService {
    boolean addCheckin(Checkin checkin);
    boolean updateCheckin(Checkin checkin);
    String checkinCode(int cid);
}
