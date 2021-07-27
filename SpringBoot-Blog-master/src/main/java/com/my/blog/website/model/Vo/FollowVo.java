package com.my.blog.website.model.Vo;

import java.io.Serializable;

/**
 * (Follow)实体类
 *
 * @author makejava
 * @since 2021-07-27 14:39:32
 */
public class FollowVo implements Serializable {
    private static final long serialVersionUID = 527077785896948522L;

    private Integer userId;

    private Integer followedId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }

}
