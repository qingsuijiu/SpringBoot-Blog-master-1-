package com.my.blog.website.controller.admin;

import com.my.blog.website.constant.WebConst;
import com.my.blog.website.controller.BaseController;
import com.my.blog.website.dto.LogActions;
import com.my.blog.website.exception.TipException;
import com.my.blog.website.model.Bo.RestResponseBo;
import com.my.blog.website.model.Vo.UserVo;
import com.my.blog.website.service.ILogService;
import com.my.blog.website.service.IUserService;
import com.my.blog.website.utils.FaceClient;
import com.my.blog.website.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户后台登录/登出
 */
@Controller
@RequestMapping("/admin")
@Transactional(rollbackFor = TipException.class)
public class AuthController extends BaseController {

    private static final String APP_ID = "24589475";
    private static final String API_KEY = "bDMsSh3KFR3qpXv12LSbWKbv";
    private static final String SECRET_KEY = "nzV9bcdiZAha32WYwjmlS3UptOtAXuPO";

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private IUserService usersService;

    @Resource
    private ILogService logService;

    @GetMapping(value = "/login")
    public String login() {
        return "admin/login3";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "admin/register2";
    }

    @GetMapping("/face")
    public String faceDetect(Model model, HttpServletRequest request) {
        UserVo login_user = (UserVo) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY);
        Integer uid = login_user.getUid();
//        System.out.println(uid);
        String faceUrl = usersService.selectFaceUrl(uid);
//        System.out.println(faceUrl);

        model.addAttribute("faceUrl", faceUrl);
        return "admin/faceCheck";
    }

    @PostMapping("/face/contrast")
    @ResponseBody
    public boolean faceContrast(String face1, String face2){
        FaceClient faceClient = FaceClient.getInstance(APP_ID, API_KEY, SECRET_KEY);
        System.out.println(face1);
        System.out.println(face2);
        System.out.println(faceClient);
        if(faceClient.faceContrast(face1, face2)){
            System.out.println("成立");
            return true;
        }else {
            return false;
        }
    }

    @PostMapping(value = "login")
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam(required = false) String remeber_me,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        Integer error_count = cache.get("login_error_count");
        try {
            UserVo user = usersService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            if (StringUtils.isNotBlank(remeber_me)) {
                TaleUtils.setCookie(response, user.getUid());
            }
            logService.insertLog(LogActions.LOGIN.getAction(), null, request.getRemoteAddr(), user.getUid());
        } catch (Exception e) {
            error_count = null == error_count ? 1 : error_count + 1;
            if (error_count > 3) {
                return RestResponseBo.fail("您输入密码已经错误超过3次，请10分钟后尝试");
            }
            cache.set("login_error_count", error_count, 10 * 60);
            String msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    /**
     * 注销
     *
     * @param session
     * @param response
     */
    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, "");
        cookie.setValue(null);
        cookie.setMaxAge(0);// 立即销毁cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        try {
            response.sendRedirect("/admin/login");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("注销失败", e);
        }
    }

}
