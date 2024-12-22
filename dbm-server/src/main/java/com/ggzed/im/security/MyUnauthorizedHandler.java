package com.ggzed.im.security;

import com.alibaba.fastjson2.JSON;
import com.ggzed.im.common.exception.AuthenticationFailedException;
import com.ggzed.im.common.result.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ggzed.im.common.result.ResultEnum.PERMISSION_UNAUTHENTICATED;

/**
 * 认证失败处理.
 *
 * @ClassName MyUnauthorizedHandler
 * @Author ggzed
 * @Date 2024/2/5
 * @Version 1.0
 */
@Component
public class MyUnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSON.toJSONString(Result.error(PERMISSION_UNAUTHENTICATED)));
        response.getWriter().flush();
    }
}