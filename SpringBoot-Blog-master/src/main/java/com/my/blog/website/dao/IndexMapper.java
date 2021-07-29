package com.my.blog.website.dao;

import com.my.blog.website.model.Bo.ArticleBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexMapper {
    List<ArticleBo> selectAll();
}
