package com.ggzed.im.web;

import com.ggzed.im.common.result.Result;
import com.ggzed.im.model.common.PageResult;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.UserQuery;
import com.ggzed.im.model.req.user.UserEditReq;
import com.ggzed.im.model.vo.UserVo;
import com.ggzed.im.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

/**
 * 详细介绍类情况.
 *
 * @ClassName UserController
 * @Author ggzed
 * @Date 2024/2/5
 * @Version 1.0
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

//    @ApiOperation("根据id获取")
//    @GetMapping("/{id}")
//    public UserVo login(@PathVariable String id) {
//        return userInfoService.getById(id);
//    }

    @ApiOperation("分页查询")
    @PostMapping("/page")
    public PageResult<UserVo> page(@RequestBody UserQuery query, PageReq req) {
        return userInfoService.page(query, req);
    }

    @ApiOperation("编辑")
    @PostMapping("/edit")
    public void edit(@RequestBody UserEditReq req) {
        userInfoService.edit(req);
    }

    @ApiOperation("删除")
    @PostMapping("/delete/{userId}")
    public void delete(@PathVariable String userId) {
        userInfoService.delete(userId);
    }
}
