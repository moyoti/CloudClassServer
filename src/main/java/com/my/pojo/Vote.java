package com.my.pojo;

import java.util.Date;

public class Vote {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote.vid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private Integer vid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote.cid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private String cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote.starttime
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private Date starttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote.endtime
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private Date endtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote.status
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote.vid
     *
     * @return the value of vote.vid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public Integer getVid() {
        return vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote.vid
     *
     * @param vid the value for vote.vid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setVid(Integer vid) {
        this.vid = vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote.cid
     *
     * @return the value of vote.cid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote.cid
     *
     * @param cid the value for vote.cid
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote.starttime
     *
     * @return the value of vote.starttime
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote.starttime
     *
     * @param starttime the value for vote.starttime
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote.endtime
     *
     * @return the value of vote.endtime
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote.endtime
     *
     * @param endtime the value for vote.endtime
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote.status
     *
     * @return the value of vote.status
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote.status
     *
     * @param status the value for vote.status
     *
     * @mbggenerated Tue Feb 19 19:39:03 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}