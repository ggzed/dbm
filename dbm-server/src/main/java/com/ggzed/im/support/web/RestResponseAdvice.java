package com.ggzed.im.support.web;

/**
 * 详细介绍类情况.
 *
 * @ClassName RestResponseAdvice
 * @Author ggzed
 * @Date 2024/2/7
 * @Version 1.0
 */

import com.alibaba.fastjson2.JSON;
import com.ggzed.im.common.exception.BizException;
import com.ggzed.im.common.result.ResultEnum;
import com.ggzed.im.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import javax.validation.constraints.NotNull;

/**
 * 对返回结果统一进行处理，包括返回结果格式统一包装，返回异常统一处理
 *
 * @author 笑小枫
 * @date 2022/07/15
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.ggzed.im.web"}, annotations = {RestController.class})
public class RestResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NotNull MethodParameter returnType,
                            @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 返回结果包装统一返回格式
     *
     * @return 包装后的返回结果
     */
    @Override
    public Object beforeBodyWrite(Object body,
                                  @NotNull MethodParameter returnType,
                                  @NotNull MediaType selectedContentType,
                                  @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @NotNull ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // 指定返回的结果为application/json格式
        // 不指定，String类型转json后返回Content-Type是text/plain;charset=UTF-8
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        Result result = Result.success(body);
        // 若返回类型是Result，则不进行修改
        if (body == null) {
            if (returnType.getParameterType().isAssignableFrom(String.class)) {
                return JSON.toJSONString(result);
            }
        } else if (body instanceof Result) {
            return body;
        } else if (body instanceof String) {
            return JSON.toJSONString(result);
        }
        return result;
    }

    /**
     * 通用异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception ex) {
        log.error(ex.getMessage());
        return Result.error(ResultEnum.FAIL);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleSystemException(BizException ex) {
        return Result.error(ex.getResultEnum());
    }
}