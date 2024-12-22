package com.ggzed.im.common.exception;

import com.ggzed.im.common.result.ResultEnum;

/**
 * @author: ggzed
 * @date: 2024/2/21 17:04
 * @description:
 */
public class AuthenticationFailedException extends BizException {
    public AuthenticationFailedException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
