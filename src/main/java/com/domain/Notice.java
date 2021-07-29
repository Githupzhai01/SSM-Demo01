package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Notice {
    private Integer noid;

    private String noname;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date notime;

    public Integer getNoid() {
        return noid;
    }

    public void setNoid(Integer noid) {
        this.noid = noid;
    }

    public String getNoname() {
        return noname;
    }

    public void setNoname(String noname) {
        this.noname = noname == null ? null : noname.trim();
    }

    public Date getNotime() {
        return notime;
    }

    public void setNotime(Date notime) {
        this.notime = notime;
    }
}