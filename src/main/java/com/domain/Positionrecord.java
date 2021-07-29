package com.domain;

public class Positionrecord {
    private Integer pid;

    private String positionname;

    private Integer positionstate;

    private String positionstatesdes;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname == null ? null : positionname.trim();
    }

    public Integer getPositionstate() {
        return positionstate;
    }

    public void setPositionstate(Integer positionstate) {
        this.positionstate = positionstate;
    }

    public String getPositionstatesdes() {
        return positionstatesdes;
    }

    public void setPositionstatesdes(String positionstatesdes) {
        this.positionstatesdes = positionstatesdes == null ? null : positionstatesdes.trim();
    }
}