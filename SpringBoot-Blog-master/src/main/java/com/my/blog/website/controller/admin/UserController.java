package com.my.blog.website.controller.admin;


import com.github.pagehelper.PageInfo;
import com.my.blog.website.constant.WebConst;
import com.my.blog.website.model.Bo.RestResponseBo;
import com.my.blog.website.model.Vo.UserVo;
import com.my.blog.website.model.Vo.UserVoExample;
import com.my.blog.website.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Resource
    private IUserService userService;



    @GetMapping(value = "")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        UserVoExample userVoExample = new UserVoExample();
        userVoExample.setOrderByClause("created desc");
        userVoExample.createCriteria().andGroupNameEqualTo("user");
        PageInfo<UserVo> usersPaginator = userService.getUSersWithpage(userVoExample, page, limit);
        request.setAttribute("users", usersPaginator);
        return "admin/user_list";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam int uid, HttpServletRequest request) {
        String result = userService.deleteByUid(uid);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @RequestMapping(value = "/mute")
    @ResponseBody
    public RestResponseBo mute(@RequestParam int uid, HttpServletRequest request) {
        String result = userService.changeMUteState(uid);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok(result);
    }
}
