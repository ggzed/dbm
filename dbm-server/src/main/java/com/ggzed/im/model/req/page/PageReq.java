package com.ggzed.im.model.req.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ggzed
 * @date: 2024/2/22 10:41
 * @description: 分页请求模板
 */
@Data
public class PageReq {
    @ApiModelProperty(value = "当前页",notes = "default 1")
    private Integer page = 1;
    @ApiModelProperty(value = "页大小",notes = "default 10")
    private Integer size = 10;
    @ApiModelProperty(value = "起始页",notes = "default 1")
    private Integer startRow = 1;
    @ApiModelProperty(value = "排序")
    private List<OrderItem> orders = new ArrayList<>();

    public static PageReq create(int page, int size) {
        PageReq req = new PageReq();
        req.setPage(page);
        req.setSize(size);
        return req;
    }

    public <T> Page<T> toPage() {
        Page<T> page = new Page<>(getPage(), getSize());
        page.setOrders(getOrders());
        return page;
    }

    public void setPage(Integer page) {
        if (page == null) {
            this.page = 1;
        } else if (page < 1) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setSize(Integer size) {
        if (size == null) {
            this.size = 10;
        } else if (size < 1) {
            this.size = 1;
        } else {
            this.size = size;
        }
    }
}
