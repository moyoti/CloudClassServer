package com.my.dao;

import com.my.pojo.ResourcesClass;
import com.my.pojo.ResourcesClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int countByExample(ResourcesClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int deleteByExample(ResourcesClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int deleteByPrimaryKey(Integer rcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int insert(ResourcesClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int insertSelective(ResourcesClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    List<ResourcesClass> selectByExample(ResourcesClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    ResourcesClass selectByPrimaryKey(Integer rcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int updateByExampleSelective(@Param("record") ResourcesClass record, @Param("example") ResourcesClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int updateByExample(@Param("record") ResourcesClass record, @Param("example") ResourcesClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int updateByPrimaryKeySelective(ResourcesClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_class
     *
     * @mbggenerated Wed Mar 06 12:16:43 CST 2019
     */
    int updateByPrimaryKey(ResourcesClass record);
}