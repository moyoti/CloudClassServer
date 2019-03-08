package com.my.dao;

import com.my.pojo.Questionbank;
import com.my.pojo.QuestionbankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionbankMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int countByExample(QuestionbankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByExample(QuestionbankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByPrimaryKey(Integer qbid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insert(Questionbank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insertSelective(Questionbank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    List<Questionbank> selectByExample(QuestionbankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    Questionbank selectByPrimaryKey(Integer qbid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") Questionbank record, @Param("example") QuestionbankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExample(@Param("record") Questionbank record, @Param("example") QuestionbankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKeySelective(Questionbank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionbank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKey(Questionbank record);
}