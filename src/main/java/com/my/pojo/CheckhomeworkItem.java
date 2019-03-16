package com.my.pojo;

/**
 * Created by williamwu on 2019/3/16.
 */
public class CheckhomeworkItem {
    int hrid;
    String answer;
    int score;
    int value;
    String title;
    String profile;

    public CheckhomeworkItem(){

    }

    public int getHrid() {
        return hrid;
    }

    public void setHrid(int hrid) {
        this.hrid = hrid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
