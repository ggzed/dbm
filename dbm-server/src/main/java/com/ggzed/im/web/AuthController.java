package com.ggzed.im.web;

import com.ggzed.im.model.req.auth.LoginReq;
import com.ggzed.im.model.req.auth.RegisterReq;
import com.ggzed.im.model.vo.LoginVo;
import com.ggzed.im.model.vo.MenuVo;
import com.ggzed.im.model.vo.PermissionInfoVo;
import com.ggzed.im.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */

@Api(tags = "权限验证")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public LoginVo login(@RequestBody LoginReq req) {
        return authService.login(req);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public void register(@RequestBody RegisterReq req) {
        authService.register(req);
    }

    @ApiOperation("获取菜单权限")
    @GetMapping("/menus")
    public List<MenuVo> menus() {
      return   authService.menus();
    }

    @ApiOperation("获取菜单权限")
    @GetMapping("/permission")
    public PermissionInfoVo permission() {
        return   authService.permission();
    }
}
