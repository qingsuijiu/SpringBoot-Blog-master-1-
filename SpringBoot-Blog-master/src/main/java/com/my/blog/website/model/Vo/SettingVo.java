package com.my.blog.website.model.Vo;

import java.io.Serializable;

/**
 * (Setting)实体类
 *
 * @author makejava
 * @since 2021-07-27 14:39:55
 */
public class SettingVo implements Serializable {
    private static final long serialVersionUID = -59593913638633427L;

    private Integer userId;

    private String ausetVol;

    private String ausetVoiper;

    private String ausetSpd;

    private String ausetPit;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAusetVol() {
        return ausetVol;
    }

    public void setAusetVol(String ausetVol) {
        this.ausetVol = ausetVol;
    }

    public String getAusetVoiper() {
        return ausetVoiper;
    }

    public void setAusetVoiper(String ausetVoiper) {
        this.ausetVoiper = ausetVoiper;
    }

    public String getAusetSpd() {
        return ausetSpd;
    }

    public void setAusetSpd(String ausetSpd) {
        this.ausetSpd = ausetSpd;
    }

    public String getAusetPit() {
        return ausetPit;
    }

    public void setAusetPit(String ausetPit) {
        this.ausetPit = ausetPit;
    }

}
