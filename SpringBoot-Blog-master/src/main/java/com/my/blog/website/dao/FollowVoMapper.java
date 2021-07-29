package com.my.blog.website.dao;

import com.my.blog.website.model.Vo.FollowVoExample;
import com.my.blog.website.model.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FollowVoMapper {
    boolean selectFollowers(int userId, int followedId);
    long countByExample(FollowVoExample example);
    List<UserVo> selectUsers(@Param("id") Integer id);
    void addFollowers(@Param("userId") Integer userId,
                      @Param("followedId") Integer followedId);

    void deleteFollowers(Integer userId, Integer followedId);
}
