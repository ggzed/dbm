package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ggzed.im.model.common.BaseModel;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 网站用户基本信息
 * </p>
 *
 * @author ggzed
 * @since 2024-02-20
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo  extends BaseModel {


    /**
     * 用户id
     */
    private String userId;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private Integer avatar;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 一句话介绍自己，最多50个汉字
     */
    private String shortIntroduce;

    /**
     * 用户提交的简历存放地址
     */
    private String userResume;

    /**
     * 用户注册时的源ip
     */
    private Integer userRegisterIp;

    /**
     * 用户资料审核状态，1为通过，2为审核中，3为未通过，4为还未提交审核
     */
    private Byte userReviewStatus;

}
