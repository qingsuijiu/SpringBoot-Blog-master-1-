package com.my.blog.website.service;

import com.github.pagehelper.PageInfo;
import com.my.blog.website.model.Vo.ContentVo;
import com.my.blog.website.model.Vo.UserVo;
import com.my.blog.website.model.Vo.UserVoExample;

/**
 * Created by BlueT on 2017/3/3.
 */
public interface IUserService {

    /**
     * 保存用户数据
     *
     * @param userVo 用户数据
     * @return 主键
     */

    Integer insertUser(UserVo userVo);

    /**
     * 通过uid查找对象
     * @param uid
     * @return
     */
    UserVo queryUserById(Integer uid);

    /**
     * 用戶登录
     * @param username
     * @param password
     * @return
     */
    UserVo login(String username, String password);

    /**
     * 根据主键更新user对象
     * @param userVo
     * @return
     */
    void updateByUid(UserVo userVo);


    /**
     * 获取用户列表
     * @param page 当前页
     * @param limit 每页条数
     * @return
     */
    PageInfo<UserVo> getUSersWithpage(UserVoExample userVoExample, int page, int limit);


    /**
     * 根据用户id删除
     * @param uid
     */
    String deleteByUid(Integer uid);

    String changeMUteState(Integer uid);
}
