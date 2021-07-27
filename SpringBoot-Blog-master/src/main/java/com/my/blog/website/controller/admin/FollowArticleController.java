package com.my.blog.website.controller.admin;

import com.my.blog.website.model.Vo.ContentVo;
import com.my.blog.website.service.IContentService;
import com.zaxxer.hikari.util.ConcurrentBag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author fanyang
 * @CreateTime 21:08
 * @Version 1.0.0
 */
@Controller
public class FollowArticleController {
    private IContentService contentService;

    @RequestMapping("admin/folAriticles")
    public String toFollowed(Integer id, HttpServletRequest request)
    {
        List<ContentVo> folAriticles = contentService.getContentsByAuthorId(id);
        request.setAttribute("folAriticles", folAriticles);
        return "admin/follow_articles";
    }

}
