package com.ggzed.im.dao;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggzed.im.common.constant.Constants;
import com.ggzed.im.mapper.RoleInfoMapper;
import com.ggzed.im.model.entity.RoleInfo;
import com.ggzed.im.model.req.query.RoleQuery;
import com.ggzed.im.model.req.user.RoleEditReq;
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
public class RoleInfoDao extends ServiceImpl<RoleInfoMapper, RoleInfo> {
    public IPage<RoleInfo> pageSearch(RoleQuery query, Page<RoleInfo> page) {
        return buildQueryWrapper(query).page(page);
    }

    private LambdaQueryChainWrapper<RoleInfo> buildQueryWrapper(RoleQuery query) {
        return lambdaQuery()
                .eq(StrUtil.isNotBlank(query.getName()), RoleInfo::getName, query.getName())
                .eq(RoleInfo::getIsDeleted, Constants.NOT_DELETED);
    }

    public void edit(RoleEditReq req) {
        this.saveOrUpdate(Convert.convert(RoleInfo.class, req));
    }

    public void delete(Long id) {
        lambdaUpdate()
                .set(RoleInfo::getIsDeleted, Constants.IS_DELETED)
                .eq(RoleInfo::getIdKey, id)
                .update();
    }
}