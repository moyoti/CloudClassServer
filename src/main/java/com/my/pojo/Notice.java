package com.my.pojo;

import java.util.Date;

public class Notice {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.nid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private Integer nid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.cid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private String cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.content
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.time
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private Date time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.nid
     *
     * @return the value of notice.nid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public Integer getNid() {
        return nid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.nid
     *
     * @param nid the value for notice.nid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setNid(Integer nid) {
        this.nid = nid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.cid
     *
     * @return the value of notice.cid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.cid
     *
     * @param cid the value for notice.cid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.content
     *
     * @return the value of notice.content
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.content
     *
     * @param content the value for notice.content
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.time
     *
     * @return the value of notice.time
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.time
     *
     * @param time the value for notice.time
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setTime(Date time) {
        this.time = time;
    }
}