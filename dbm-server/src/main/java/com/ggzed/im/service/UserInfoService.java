package com.ggzed.im.service;

import com.ggzed.im.model.common.PageResult;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.UserQuery;
import com.ggzed.im.model.req.user.UserEditReq;
import com.ggzed.im.model.vo.UserVo;

public interface UserInfoService {

    UserVo getById(String id);

    PageResult<UserVo> page(UserQuery query,PageReq pageReq);

    void edit(UserEditReq req);

    void delete(String userId);
}
