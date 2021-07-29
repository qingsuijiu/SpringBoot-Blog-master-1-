package com.my.blog.website.service.impl;

import com.my.blog.website.dao.IndexMapper;
import com.my.blog.website.model.Bo.ArticleBo;
import com.my.blog.website.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<ArticleBo> selectAll() {
        return indexMapper.selectAll();
    }
}
