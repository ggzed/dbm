package com.ggzed.im.service;

import com.ggzed.im.core.GenConfig;
import com.ggzed.im.model.common.PageResult;
import com.ggzed.im.model.dto.DbmTableInfoDto;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.UserQuery;
import com.ggzed.im.model.req.user.UserEditReq;
import com.ggzed.im.model.vo.UserVo;

import java.util.List;

public interface TableInfoService {

    List<DbmTableInfoDto> queryList(GenConfig config);
}
