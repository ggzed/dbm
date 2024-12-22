package com.ggzed.im.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ggzed.im.model.common.PageResult;
import com.ggzed.im.model.entity.RoleInfo;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.RoleQuery;
import com.ggzed.im.model.req.user.RoleEditReq;
import com.ggzed.im.model.vo.RoleVo;
import com.ggzed.im.dao.RoleInfoDao;
import com.ggzed.im.service.RoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Resource
    private RoleInfoDao roleInfoDao;

    @Override
    public RoleVo getByRoleId(String id) {
        RoleInfo roleInfo = roleInfoDao.getById(id);
        return Convert.convert(RoleVo.class, roleInfo);
    }

    @Override
    public PageResult<RoleVo> page(RoleQuery query, PageReq pageReq) {
        IPage<RoleInfo> iPage = roleInfoDao.pageSearch(query, pageReq.toPage());
        return PageResult.create(iPage.convert(method -> Convert.convert(RoleVo.class, method)));
    }

    @Override
    public void edit(RoleEditReq req) {
        roleInfoDao.edit(req);
    }

    @Override
    public void delete(Long id) {
        roleInfoDao.delete(id);
    }
}
