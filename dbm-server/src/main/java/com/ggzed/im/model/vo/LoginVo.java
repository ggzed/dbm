package com.ggzed.im.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author: ggzed
 * @date: 2024/2/26 16:22
 * @description:
 */
@Data
@Builder
public class LoginVo {
    private String token;
}
