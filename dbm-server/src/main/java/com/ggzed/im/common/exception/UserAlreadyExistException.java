package com.ggzed.im.common.exception;

import com.ggzed.im.common.result.ResultEnum;

/**
 * @author: ggzed
 * @date: 2024/2/21 17:48
 * @description:
 */
public class UserAlreadyExistException extends BizException {
    public UserAlreadyExistException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
