package com.yangrr.center.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yangrr.center.common.BaseResponse;
import com.yangrr.center.common.ErrorCode;
import com.yangrr.center.common.ResultUtils;
import com.yangrr.center.exception.BusinessException;
import com.yangrr.center.model.domain.User;
import com.yangrr.center.model.request.*;
import com.yangrr.center.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.yangrr.center.constant.UserConstant.ADMIN_ROLE;
import static com.yangrr.center.constant.UserConstant.USER_LOGIN_STATE;


/**
 * 用户接口
 */
@CrossOrigin(value = {"http://localhost:5173"}, allowCredentials = "true")
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("register")
    public BaseResponse<String> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {

        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();


        System.out.println(userAccount + userPassword + checkPassword);

        Long planetCode = userService.count(new QueryWrapper<>()) + 1;

        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        String unique = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);

        return ResultUtils.success(unique);
    }


    @PostMapping("login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {

        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();

        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        System.out.println(userAccount + userPassword);


        User user = userService.userLogin(userAccount, userPassword, request);

        return ResultUtils.success(user);

    }


    @GetMapping("current")
    public BaseResponse<User> getCurrentUser(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        Long userId = currentUser.getId();
        User user = userService.getById(userId);

        User safetyUser = userService.getSafetyUser(user);

        return ResultUtils.success(safetyUser);
    }

    @PostMapping("update")
    public BaseResponse<Integer> updateUser(@RequestBody UpdateRequest updateRequest){

        if (updateRequest == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        Long id = updateRequest.getId();

        userService.updateUser(updateRequest);

        return ResultUtils.success(1);
    }

    @PostMapping("logout")
    private void logout(HttpServletRequest request){
        userService.userLogout(request);
    }

    private boolean isAdmin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        return user != null && user.getUserRole() == ADMIN_ROLE;
    }

}
