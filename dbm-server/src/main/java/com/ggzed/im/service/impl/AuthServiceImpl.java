package com.ggzed.im.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWT;
import com.alibaba.fastjson2.JSON;
import com.ggzed.im.common.constant.JwtConstant;
import com.ggzed.im.common.exception.BizException;
import com.ggzed.im.common.result.ResultEnum;
import com.ggzed.im.model.entity.AuthInfo;
import com.ggzed.im.model.entity.Menus;
import com.ggzed.im.model.req.auth.LoginReq;
import com.ggzed.im.model.req.auth.RegisterReq;
import com.ggzed.im.model.vo.LoginVo;
import com.ggzed.im.model.vo.MenuVo;
import com.ggzed.im.dao.AuthInfoDao;
import com.ggzed.im.dao.MenuDao;
import com.ggzed.im.model.vo.PermissionInfoVo;
import com.ggzed.im.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private AuthInfoDao authInfoDao;
    @Resource
    private MenuDao menuDao;

    @Override
    public LoginVo login(LoginReq req) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        authenticationManager.authenticate(authenticationToken);
        //上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
        return LoginVo
                .builder()
                .token(JWT.create()
                .setPayload("username", req.getUsername())
                .setKey(JwtConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
                .sign()).build();
    }

    @Override
    public void register(RegisterReq req) {
        AuthInfo exist = authInfoDao.getByUsername(req.getUsername());
        if (Objects.nonNull(exist)) {
            throw new BizException(ResultEnum.USER_HAS_EXISTED);
        }
        String userId = IdUtil.simpleUUID();
        AuthInfo authInfo = AuthInfo.builder()
                .userId(userId)
                .username(req.getUsername())
                .password(req.getPassword()).build();
        authInfoDao.save(authInfo);
    }

    @Override
    public List<MenuVo> menus() {
        List<Menus> menus = menuDao.list();

        return menus.stream().filter(m -> m.getParentId() == 0).map(m -> {
            MenuVo menuVo = Convert.convert(MenuVo.class, m);
            menuVo.setChildren(getChildrenMenus(menus, m.getIdKey()));
            return menuVo;
        }).collect(Collectors.toList());
    }

    @Override
    public PermissionInfoVo permission() {
        List<PermissionInfoVo> infoVos = new ArrayList<>();
        PermissionInfoVo vo = new PermissionInfoVo();
        vo.setUserId("1");
        vo.setUsername("admin");
        vo.setRealName("sssgoEasy Admin");
        vo.setAvatar("");
        vo.setDesc("manager");
        vo.setAuths(new ArrayList<>());
        vo.setModules(new ArrayList<>());
        vo.setPassword("123456");
        vo.setToken("fakeToken1");
        vo.setMobile("15888889999");
        vo.setLastLogin("2021-11-11 12:00");
        vo.setRole(1);
        PermissionInfoVo vo1 = new PermissionInfoVo();
        vo1.setUserId("2");
        vo1.setUsername("test");
        vo1.setRealName("test user");
        vo1.setAvatar("");
        vo1.setDesc("tester");
        List<String> modules = new ArrayList<>();
        modules.add("home");
        modules.add("database");
        vo1.setModules(modules);
        vo1.setPassword("123456");
        vo1.setToken("fakeToken1");
        vo1.setMobile("15888889999");
        vo1.setLastLogin("2021-11-11 12:00");
        vo1.setRole(0);
        infoVos.add(vo1);
        infoVos.add(vo);
        return vo;
    }

    /**
     * 递归查询子菜单
     *
     * @param menus    菜单
     * @param parentId 父id
     * @return 子菜单
     */
    private List<MenuVo> getChildrenMenus(List<Menus> menus, Long parentId) {
        List<MenuVo> result = new ArrayList<>();
        for (Menus menu : menus) {
            if (Objects.equals(parentId, menu.getParentId())) {
                result.add(Convert.convert(MenuVo.class, menu));
                result.addAll(getChildrenMenus(menus, menu.getIdKey()));
            }
        }
        return result;
    }
}
