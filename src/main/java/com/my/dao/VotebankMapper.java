package com.my.dao;

import com.my.pojo.Votebank;
import com.my.pojo.VotebankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VotebankMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int countByExample(VotebankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByExample(VotebankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int deleteByPrimaryKey(Integer vbid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insert(Votebank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int insertSelective(Votebank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    List<Votebank> selectByExample(VotebankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    Votebank selectByPrimaryKey(Integer vbid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") Votebank record, @Param("example") VotebankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByExample(@Param("record") Votebank record, @Param("example") VotebankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKeySelective(Votebank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table votebank
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    int updateByPrimaryKey(Votebank record);
}