package com.ggzed.im.common.result;

/**
 * @author: ggzed
 * @date: 2024/2/21 14:57
 * @description:
 */
import lombok.Data;


/**
 * @author mijiupro
 */

@Data
public class Result<T> {

    // 操作代码
    Integer code;

    // 提示信息
    String message;

    // 结果数据
    T result;

    public Result(ResultEnum resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public Result(ResultEnum resultCode, T result) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.result = result;
    }
    public Result(String message) {
        this.message = message;
    }
    //成功返回封装-无数据
    public static Result<String> success() {
        return new Result<String>(ResultEnum.SUCCESS);
    }
    //成功返回封装-带数据
    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultEnum.SUCCESS, data);
    }
    //失败返回封装-使用默认提示信息
    public static Result<String> error() {
        return new Result<String>(ResultEnum.FAIL);
    }
    //失败返回封装-使用返回结果枚举提示信息
    public static Result<String> error(ResultEnum resultCode) {
        return new Result<String>(resultCode);
    }
    //失败返回封装-使用自定义提示信息
    public static Result<String> error(String message) {
        return new Result<String>(message);

    }
}
