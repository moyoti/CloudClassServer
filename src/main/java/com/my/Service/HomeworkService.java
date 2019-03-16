package com.my.Service;

import com.my.pojo.Homework;
import com.my.pojo.HomeworkResultItem;
import com.my.pojo.Homeworkresult;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 16:27 2019/2/20
 */
public interface HomeworkService {
    int addHomework(Homework homework);
    boolean closeHomework(Homework homework);
    boolean updateHomework(Homework homework);
    Homework getHomeworkById(int hid);
    List<Homework> getHomeworksById(int cid);
    List<HomeworkResultItem> getResults(int hid);
    List<HomeworkResultItem> getResultsByUser(int uid);
    boolean doHomework(Homeworkresult homeworkresult);
    boolean deleteHomework(int hid);
    int getIdByuidhid(int uid, int hid);
    Homeworkresult getHomeworkResult(int hrid);
}
