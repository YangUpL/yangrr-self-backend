package com.yangrr.center.service;

import com.yangrr.center.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangrr.center.model.request.SearchRequest;
import com.yangrr.center.model.request.UpdateRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
* @author yangRR
*
 * 用户服务接口
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   账户
     * @param userPassword  密码
     * @param checkPassword 校验密码
     * @param planetCode
     * @return 影响行数
     */
    String userRegister(String userAccount, String userPassword, String checkPassword, Long planetCode);


    /**
     * 用户登录
     * @param userAccount  账户
     * @param userPassword 密码
     * @return  脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser  脱敏前的用户
     * @return   脱敏后的用户
     */
    User getSafetyUser(User originUser);

    void userLogout(HttpServletRequest request);
}
