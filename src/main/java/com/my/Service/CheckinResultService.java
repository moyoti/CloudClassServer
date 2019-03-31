package com.my.Service;

import com.my.pojo.Checkresult;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 16:35 2019/2/20
 */
public interface CheckinResultService {
    boolean addCheckinResult(Checkresult checkresult);
    boolean updateCheckinResult(Checkresult checkresult);
    List<String> getUsersNameBychid(int chid);
}
