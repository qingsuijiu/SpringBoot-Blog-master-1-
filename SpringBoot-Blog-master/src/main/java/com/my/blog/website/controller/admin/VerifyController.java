package com.my.blog.website.controller.admin;

import com.github.pagehelper.PageInfo;
import com.my.blog.website.controller.BaseController;
import com.my.blog.website.model.Vo.*;
import com.my.blog.website.service.IContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/verify")
public class VerifyController extends BaseController {
    @Resource
    private IContentService contentService;

    @GetMapping(value = "")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        UserVo users = this.user(request);
        ContentVoExample contentVoExample = new ContentVoExample();
        contentVoExample.setOrderByClause("cid desc");
        contentVoExample.createCriteria().andAuthorIdNotEqualTo(users.getUid()).andStatusEqualTo("verify");
        PageInfo<ContentVo> contentsPaginator = contentService.getArticlesWithpage(contentVoExample, page, limit);
        request.setAttribute("articles", contentsPaginator);
        return "admin/verify";
    }
}
