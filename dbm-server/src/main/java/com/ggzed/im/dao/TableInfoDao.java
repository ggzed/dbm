package com.ggzed.im.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggzed.im.mapper.TableInfoMapper;
import com.ggzed.im.model.dto.DbmTableInfoDto;
import com.ggzed.im.model.entity.DbmTableInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据表信息dao.
 *
 * @ClassName UserInfoRepository
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */
@Component
public class TableInfoDao extends ServiceImpl<TableInfoMapper, DbmTableInfo> {

    public List<DbmTableInfoDto> queryList(String databaseType) {
        return baseMapper.queryList(databaseType);
    }

}