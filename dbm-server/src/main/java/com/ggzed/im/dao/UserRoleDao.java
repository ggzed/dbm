package com.ggzed.im.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggzed.im.mapper.UserRoleMapper;
import com.ggzed.im.model.entity.UserRole;
import org.springframework.stereotype.Component;

/**
 * 详细介绍类情况.
 *
 * @ClassName UserInfoRepository
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */
@Component
public class UserRoleDao extends ServiceImpl<UserRoleMapper, UserRole> {
}