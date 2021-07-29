package com.my.blog.website.dao;

import com.my.blog.website.model.Vo.FollowVoExample;
import com.my.blog.website.model.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author fanyang
 * @CreateTime 15:56
 * @Version 1.0.0
 */
@Mapper
public interface FollowVoMapper {

    long countByExample(FollowVoExample example);
    List<UserVo> selectUsers(@Param("id") Integer id);
}
