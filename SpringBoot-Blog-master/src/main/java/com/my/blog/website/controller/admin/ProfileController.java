package com.my.blog.website.controller.admin;


import com.my.blog.website.constant.WebConst;
import com.my.blog.website.dto.LogActions;
import com.my.blog.website.exception.TipException;
import com.my.blog.website.model.Bo.RestResponseBo;
import com.my.blog.website.model.Vo.UserVo;
import com.my.blog.website.service.ILogService;
import com.my.blog.website.service.IUserService;
import com.my.blog.website.utils.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/admin/profile")
@Transactional(rollbackFor = TipException.class)
public class ProfileController {

    @Resource
    private IUserService userService;

    /**
     * 管理员修改用户信息
     */
    @GetMapping(value = "/{uid}")
    public String getProfile(@PathVariable String uid, HttpServletRequest request) {
        if (StringUtils.isNotBlank(uid)) {
            UserVo userVo = userService.queryUserById(Integer.valueOf(uid));
            request.setAttribute("m_user",userVo);
        }
        return "admin/modify_user";
    }

    @PostMapping("/modify")
    @ResponseBody
    public RestResponseBo saveProfile(@RequestParam String uid, @RequestParam String username, @RequestParam String name,@RequestParam String identify, @RequestParam String email,@RequestParam String phone,@RequestParam String adress) {
        UserVo userVo = new UserVo();
        userVo.setUid(Integer.valueOf(uid));
        userVo.setUsername(username);
        userVo.setName(name);
        userVo.setIdentify(Integer.parseInt(identify));
        userVo.setEmail(email);
        userVo.setPhone(Integer.parseInt(phone));
        userVo.setAdress(adress);
        userService.updateByUid(userVo);
        return RestResponseBo.ok();
    }

}
