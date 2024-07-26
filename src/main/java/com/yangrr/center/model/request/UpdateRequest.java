package com.yangrr.center.model.request;

import lombok.Data;

import java.util.Date;

/**
 * @PATH com.yangrr.center.model.request.UpdateRequest
 * @Author YangRR
 * @CreateData 2024-07-17 20:03
 * @Description:
 */

@Data
public class UpdateRequest {
    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

}