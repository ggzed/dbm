package com.ggzed.im.model.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;
import java.util.List;

/**
 * @author: ggzed
 * @date: 2024/2/21 18:37
 * @description:
 */
@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private long total;
    private long size;
    private long current;
    private long totalPages;
    private List<T> records;

    public static <T> PageResult<T> create(IPage<T> iPage){
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setTotal(iPage.getTotal());
        pageResult.setTotalPages(iPage.getPages());
        pageResult.setSize(iPage.getSize());
        pageResult.setRecords(iPage.getRecords());
        pageResult.setCurrent(iPage.getCurrent());
        return pageResult;
    }

}
