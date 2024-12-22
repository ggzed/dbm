package com.ggzed.im.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: ggzed
 * @date: 2024/2/26 16:22
 * @description:
 */
@Data
public class MenuVo {
    private Long id;
    private Integer nodeType;
    private String code;
    private String path;
    private String name;
    private List<MenuVo> children;
}
