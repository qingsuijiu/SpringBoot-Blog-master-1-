package com.my.blog.website.service.impl;

import com.my.blog.website.dao.FollowVoMapper;
import com.my.blog.website.dao.LogVoMapper;
import com.my.blog.website.model.Vo.UserVo;
import com.my.blog.website.service.IFollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author fanyang
 * @CreateTime 15:45
 * @Version 1.0.0
 */

@Service
public class FollowServiceImpl implements IFollowService {

    @Resource
    private FollowVoMapper followDao;

    @Override
    public List<UserVo> selectUsers(Integer id) {
        List<UserVo> users = followDao.selectUsers(id);
        return users;
    }
}
