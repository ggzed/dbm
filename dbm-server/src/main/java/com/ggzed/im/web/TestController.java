package com.ggzed.im.web;

import com.ggzed.im.core.DynamicDataSource;
import com.ggzed.im.core.GenConfig;
import com.ggzed.im.model.dto.DbmTableInfoDto;
import com.ggzed.im.model.vo.RoleVo;
import com.ggzed.im.service.RoleInfoService;
import com.ggzed.im.service.TableInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Api(tags = "cs")
@RestController
@RequestMapping("/cs")
public class TestController {
    @Autowired
    private TableInfoService tableInfoService;
    @Autowired
    private DynamicDataSource dynamicDataSource;

    @ApiOperation("test")
    @PostMapping("/test")
    public List<DbmTableInfoDto> test(@RequestBody GenConfig config) throws NoSuchFieldException, IllegalAccessException, SQLException {
        //切换数据源之前先清空
        DynamicDataSource.clearDataSource();
        //切换数据源
        dynamicDataSource.changeDataSource(config);
        System.out.println("当前数据源:" + dynamicDataSource.getConnection());
        return tableInfoService.queryList(config);
    }
}
