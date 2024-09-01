package com.yangrr.center.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * java面试题
 * @TableName java_question
 */
@TableName(value ="java_question")
@Data
public class JavaQuestion implements Serializable {
    /**
     * 题目的id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 题目
     */
    private String question;

    /**
     * 分类  0-java基础 1-多线程
     */
    private Integer classification;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}