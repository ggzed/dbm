package com.ggzed.im.security;

import com.ggzed.im.model.entity.AuthInfo;
import com.ggzed.im.dao.AuthInfoDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 详细介绍类情况.
 *
 * @ClassName CustomUserDetailsService
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Resource
    private AuthInfoDao authInfoDao;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /**
         * 1/通过userName 获取到userInfo信息
         * 2/通过User（UserDetails）返回details。
         */
        //通过userName获取用户信息
        AuthInfo authInfo = authInfoDao.getByUsername(userName);
        if(authInfo == null) {
            throw new UsernameNotFoundException("not found");
        }
        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
        authorities.add(new SimpleGrantedAuthority("ROLE_"));
        return new User(authInfo.getUsername(),passwordEncoder.encode(authInfo.getPassword()),authorities);
    }
}