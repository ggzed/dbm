package com.ggzed.im.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ggzed.im.common.exception.UserNotExistException;
import com.ggzed.im.common.result.ResultEnum;
import com.ggzed.im.model.entity.UserInfo;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.UserQuery;
import com.ggzed.im.model.req.user.UserEditReq;
import com.ggzed.im.model.vo.UserVo;
import com.ggzed.im.dao.UserInfoDao;
import com.ggzed.im.service.UserInfoService;
import org.springframework.stereotype.Service;
import com.ggzed.im.model.common.PageResult;
import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserVo getById(String id) {
        UserInfo userInfo = userInfoDao.getByUserId(id);
        if (Objects.isNull(userInfo)){
            throw new UserNotExistException(ResultEnum.USER_NOT_EXIST);
        }
        return Convert.convert(UserVo.class, userInfo);
    }

    @Override
    public PageResult<UserVo> page(UserQuery query, PageReq pageReq) {
        IPage<UserInfo> iPage = userInfoDao.pageSearch(query,pageReq.toPage());
        return PageResult.create(iPage.convert(method-> Convert.convert(UserVo.class,method)));
    }

    @Override
    public void edit(UserEditReq req) {
        userInfoDao.edit(req);
    }

    @Override
    public void delete(String userId) {
        userInfoDao.deleteByUserId(userId);
    }
}
