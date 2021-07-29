package com.domain;

import java.util.Date;

public class Cardrecord {
    private Integer cid;

    private String carnumber;

    private String username;

    private String phone;

    private Date starttime;

    private Date endtime;

    private String operatorname;

    private Integer level;

    private String lveldes;

    private String starttimestring;

    private String endtimestring;

    private Integer frequency;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname == null ? null : operatorname.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLveldes() {
        return lveldes;
    }

    public void setLveldes(String lveldes) {
        this.lveldes = lveldes == null ? null : lveldes.trim();
    }

    public String getStarttimestring() {
        return starttimestring;
    }

    public void setStarttimestring(String starttimestring) {
        this.starttimestring = starttimestring == null ? null : starttimestring.trim();
    }

    public String getEndtimestring() {
        return endtimestring;
    }

    public void setEndtimestring(String endtimestring) {
        this.endtimestring = endtimestring == null ? null : endtimestring.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}