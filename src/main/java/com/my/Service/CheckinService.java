package com.my.Service;

import com.my.pojo.Checkin;
import com.my.pojo.Checkresult;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 16:33 2019/2/20
 */
public interface CheckinService {
    boolean addCheckin(Checkin checkin);
    boolean updateCheckin(Checkin checkin);
    String checkinCode(int cid);
    List<Checkin> getCourseCheckin(int cid);
    List<Checkresult> getCRInfo(int cid, int uid);
}
