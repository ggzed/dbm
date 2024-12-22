package com.ggzed.im.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ggzed.im.model.dto.DbmTableInfoDto;
import com.ggzed.im.model.entity.DbmTableInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据表信息DAO.
 *
 * @ClassName UserInfoMapper
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Mapper
public interface TableInfoMapper extends BaseMapper<DbmTableInfo> {
    List<DbmTableInfoDto> queryList(String databaseType);
}