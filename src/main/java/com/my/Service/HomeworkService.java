package com.my.Service;

import com.my.pojo.Homework;

/**
 * @Author: dongqihang
 * @Date: Created in 16:27 2019/2/20
 */
public interface HomeworkService {
    boolean addHomework(Homework homework);
    boolean closeHomework(Homework homework);
    boolean updateHomework(Homework homework);
}
