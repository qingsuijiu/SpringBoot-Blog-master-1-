package com.my.blog.website.controller.admin;

import com.my.blog.website.model.Vo.ContentVo;
import com.my.blog.website.service.IContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author fanyang
 * @CreateTime 21:08
 * @Version 1.0.0
 */
@Controller
@SessionAttributes({"folariticles"})
@RequestMapping("admin/folariticles")
public class FollowArticleController {
    @Resource
    private IContentService contentService;

    @RequestMapping(value ="")
    public String toFollowed(HttpServletRequest request, Integer id,String name)
    {
        System.out.println("hello\n\n");
        try{
            List<ContentVo> folAriticles = contentService.getContentsByAuthorId(id);
            request.setAttribute("folAriticles", folAriticles);
            request.setAttribute("followedName",name);
            return "admin/follow_articles";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            String msg = "操作失败";
            return msg;
        }
    }

    @RequestMapping(value = "/{aid}")
    public String editArticle(@PathVariable Integer aid, HttpServletRequest request) {
        List<ContentVo> folAriticles = contentService.getContentsByAuthorId(aid);
        request.setAttribute("folAriticles", folAriticles);
        return "admin/follow_articles";
    }

}
