package com.ggzed.im.service;

import com.ggzed.im.model.common.PageResult;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.RoleQuery;
import com.ggzed.im.model.req.user.RoleEditReq;
import com.ggzed.im.model.vo.RoleVo;

public interface RoleInfoService {

    RoleVo getByRoleId(String id);

    PageResult<RoleVo> page(RoleQuery query, PageReq pageReq);

    void edit(RoleEditReq req);

    void delete(Long id);
}
