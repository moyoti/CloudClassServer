package com.my.dao;

import com.my.pojo.Homeworkresult;
import com.my.pojo.HomeworkresultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeworkresultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int countByExample(HomeworkresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByExample(HomeworkresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByPrimaryKey(Integer hrid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insert(Homeworkresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insertSelective(Homeworkresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    List<Homeworkresult> selectByExample(HomeworkresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    Homeworkresult selectByPrimaryKey(Integer hrid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") Homeworkresult record, @Param("example") HomeworkresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExample(@Param("record") Homeworkresult record, @Param("example") HomeworkresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKeySelective(Homeworkresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table homeworkresult
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKey(Homeworkresult record);
}