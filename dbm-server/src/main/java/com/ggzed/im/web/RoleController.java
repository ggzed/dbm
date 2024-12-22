package com.ggzed.im.web;

import com.ggzed.im.model.common.PageResult;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.RoleQuery;
import com.ggzed.im.model.req.user.RoleEditReq;
import com.ggzed.im.model.vo.RoleVo;
import com.ggzed.im.service.RoleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 详细介绍类情况.
 *
 * @ClassName UserController
 * @Author ggzed
 * @Date 2024/2/5
 * @Version 1.0
 */
@Api(tags = "角色信息")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleInfoService roleInfoService;

    @ApiOperation("根据id获取")
    @GetMapping("/{id}")
    public RoleVo getByRoleId(@PathVariable String id) {
        return roleInfoService.getByRoleId(id);
    }

    @ApiOperation("分页查询")
    @PostMapping("/page")
    public PageResult<RoleVo> page(@RequestBody RoleQuery query, PageReq req) {
        return roleInfoService.page(query, req);
    }

    @ApiOperation("编辑")
    @PostMapping("/edit")
    public void edit(@RequestBody RoleEditReq req) {
        roleInfoService.edit(req);
    }

    @ApiOperation("删除")
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        roleInfoService.delete(id);
    }
}
