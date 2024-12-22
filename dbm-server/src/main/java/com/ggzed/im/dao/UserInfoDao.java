package com.ggzed.im.dao;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggzed.im.common.constant.Constants;
import com.ggzed.im.mapper.UserInfoMapper;
import com.ggzed.im.model.entity.UserInfo;
import com.ggzed.im.model.req.query.UserQuery;
import com.ggzed.im.model.req.user.UserEditReq;
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
public class UserInfoDao extends ServiceImpl<UserInfoMapper, UserInfo> {
    public IPage<UserInfo> pageSearch(UserQuery query, Page<UserInfo> page) {
        return buildQueryWrapper(query).page(page);
    }
    public UserInfo getByUserId(String id) {
        return lambdaQuery()
                .eq(StrUtil.isNotBlank(id), UserInfo::getUserId, id)
                .eq(UserInfo::getIsDeleted, Constants.NOT_DELETED)
                .one();
    }

    public void edit(UserEditReq req) {
        lambdaUpdate()
                .set(UserInfo::getName, req.getName())
                .eq(UserInfo::getUserId, req.getUserId())
                .update();
    }

    public void deleteByUserId(String userId) {
        lambdaUpdate()
                .set(UserInfo::getIsDeleted, Constants.IS_DELETED)
                .eq(UserInfo::getUserId, userId)
                .update();
    }

    private LambdaQueryChainWrapper<UserInfo> buildQueryWrapper(UserQuery query) {
        return lambdaQuery()
                .eq(StrUtil.isNotBlank(query.getName()), UserInfo::getName, query.getName())
                .eq(UserInfo::getIsDeleted, Constants.NOT_DELETED);
    }
}