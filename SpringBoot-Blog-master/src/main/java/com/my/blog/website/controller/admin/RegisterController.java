package com.my.blog.website.controller.admin;

import com.my.blog.website.model.Vo.UserVo;
import com.my.blog.website.service.IUserService;
import com.my.blog.website.utils.FaceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RegisterController {
    private static final String APP_ID = "24589475";
    private static final String API_KEY = "bDMsSh3KFR3qpXv12LSbWKbv";
    private static final String SECRET_KEY = "nzV9bcdiZAha32WYwjmlS3UptOtAXuPO";

    @Resource
    private IUserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @PostMapping("/face/detect")
    @ResponseBody
    public boolean faceDetect(@RequestParam("data") String data){
        FaceClient faceClient = FaceClient.getInstance(APP_ID, API_KEY, SECRET_KEY);
        return faceClient.faceDetect(data);
    }

    @PostMapping("/admin/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String faceUrl) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(faceUrl);

        UserVo userVo = new UserVo();
        userVo.setUsername(username);
        userVo.setPassword(password);
        userVo.setGroupName("user");
        userVo.setFaceUrl(faceUrl);
        userVo.setScreenName(username);
        userVo.setMute("0");
        userVo.setCreated(Integer.parseInt((System.currentTimeMillis() + "").substring(0, (System.currentTimeMillis() + "").length() - 3)));
        try {
            userService.insertUser(userVo);
        } catch (Exception e) {
            String msg = "注册失败";
            LOGGER.error(msg, e);
            System.out.println(msg);
            System.out.println(userVo.getCreated());
            return "/admin/register2";
        }
        return "/admin/login3";
    }
}
