package com.ggzed.im.security;

import com.alibaba.fastjson2.JSON;
import com.ggzed.im.common.result.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ggzed.im.common.result.ResultEnum.PERMISSION_UNAUTHORIZED;

/**
 * 详细介绍类情况.
 *
 * @ClassName MyAccessDeniedHandler
 * @Author ggzed
 * @Date 2024/2/5
 * @Version 1.0
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSON.toJSONString(Result.error(PERMISSION_UNAUTHORIZED)));
        response.getWriter().flush();
    }
}