package com.my.pojo;

public class Course {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.cid
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    private Integer cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.cname
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.cover
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    private String cover;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.semester
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    private String semester;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.canjoin
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    private String canjoin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.teacher
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    private Integer teacher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.profile
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    private String profile;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.cid
     *
     * @return the value of course.cid
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.cid
     *
     * @param cid the value for course.cid
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.cname
     *
     * @return the value of course.cname
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.cname
     *
     * @param cname the value for course.cname
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.cover
     *
     * @return the value of course.cover
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public String getCover() {
        return cover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.cover
     *
     * @param cover the value for course.cover
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.semester
     *
     * @return the value of course.semester
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public String getSemester() {
        return semester;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.semester
     *
     * @param semester the value for course.semester
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.canjoin
     *
     * @return the value of course.canjoin
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public String getCanjoin() {
        return canjoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.canjoin
     *
     * @param canjoin the value for course.canjoin
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public void setCanjoin(String canjoin) {
        this.canjoin = canjoin == null ? null : canjoin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.teacher
     *
     * @return the value of course.teacher
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public Integer getTeacher() {
        return teacher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.teacher
     *
     * @param teacher the value for course.teacher
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.profile
     *
     * @return the value of course.profile
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public String getProfile() {
        return profile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.profile
     *
     * @param profile the value for course.profile
     *
     * @mbggenerated Mon Feb 25 13:03:42 CST 2019
     */
    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }
}