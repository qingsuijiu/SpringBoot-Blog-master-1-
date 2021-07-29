package com.my.blog.website.service;

import com.my.blog.website.model.Bo.ArticleBo;

import java.util.List;

public interface IndexService {
    List<ArticleBo> selectAll();
}
