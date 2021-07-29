package com.my.blog.website.service;

import com.my.blog.website.model.Vo.UserVo;

import java.util.List;

/**
 * @Author Zeng Jie
 * @CreateTime 15:43
 * @Version 1.0.0
 */
public interface IFollowService {

    /**
     * 选出当前id的所有关注者
     * @param id
     * @return
     */
    List<UserVo> selectUsers(Integer id);

    /**
     * 添加关注关系
     * @param userId
     * @param followedId
     * @return
     */
    void addFollowers(Integer userId, Integer followedId);

    /**
     * 取消关注关系
     * @param userId
     * @param followedId
     * @return
     */
    void deleteFollowers(Integer userId, Integer followedId);

    boolean selectFollowers(int userId, int followedId);

}
