package com.my.blog.website.service;

import com.my.blog.website.model.Vo.UserVo;

import java.util.List;

/**
 * @Author fanyang
 * @CreateTime 15:43
 * @Version 1.0.0
 */
public interface IFollowService {
    List<UserVo> selectUsers(Integer id);



}
