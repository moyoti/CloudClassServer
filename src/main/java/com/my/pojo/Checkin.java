package com.my.pojo;

public class Checkin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column checkin.chid
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    private Integer chid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column checkin.courseid
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    private Integer courseid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column checkin.isopen
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    private String isopen;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column checkin.chid
     *
     * @return the value of checkin.chid
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    public Integer getChid() {
        return chid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column checkin.chid
     *
     * @param chid the value for checkin.chid
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    public void setChid(Integer chid) {
        this.chid = chid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column checkin.courseid
     *
     * @return the value of checkin.courseid
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    public Integer getCourseid() {
        return courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column checkin.courseid
     *
     * @param courseid the value for checkin.courseid
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column checkin.isopen
     *
     * @return the value of checkin.isopen
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    public String getIsopen() {
        return isopen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column checkin.isopen
     *
     * @param isopen the value for checkin.isopen
     *
     * @mbggenerated Mon Feb 25 12:00:40 CST 2019
     */
    public void setIsopen(String isopen) {
        this.isopen = isopen == null ? null : isopen.trim();
    }
}