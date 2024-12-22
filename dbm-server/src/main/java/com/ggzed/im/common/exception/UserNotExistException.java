package com.ggzed.im.common.exception;

import com.ggzed.im.common.result.ResultEnum;

/**
 * @author: ggzed
 * @date: 2024/2/21 15:45
 * @description:
 */
public class UserNotExistException extends BizException {
    public UserNotExistException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
