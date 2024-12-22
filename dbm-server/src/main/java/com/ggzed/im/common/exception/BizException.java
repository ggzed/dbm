package com.ggzed.im.common.exception;

/**
 * @author: ggzed
 * @date: 2024/2/21 15:35
 * @description: 业务异常
 */
import com.ggzed.im.common.result.ResultEnum;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
    private final ResultEnum resultEnum;

    public BizException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
