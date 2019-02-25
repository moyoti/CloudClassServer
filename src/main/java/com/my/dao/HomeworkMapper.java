package com.my.dao;

import com.my.pojo.Homework;
import com.my.pojo.HomeworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeworkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int countByExample(HomeworkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByExample(HomeworkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByPrimaryKey(Integer hid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insert(Homework record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insertSelective(Homework record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    List<Homework> selectByExample(HomeworkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    Homework selectByPrimaryKey(Integer hid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") Homework record, @Param("example") HomeworkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExample(@Param("record") Homework record, @Param("example") HomeworkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKeySelective(Homework record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homework
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKey(Homework record);
}