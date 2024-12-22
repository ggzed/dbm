package com.ggzed.im.service.impl;

import com.ggzed.im.core.GenConfig;
import com.ggzed.im.dao.TableInfoDao;
import com.ggzed.im.model.dto.DbmTableInfoDto;
import com.ggzed.im.service.TableInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TableInfoServiceImpl implements TableInfoService {
    @Resource
    private TableInfoDao tableInfoDao;

    @Override
    public List<DbmTableInfoDto> queryList(GenConfig config) {
       return tableInfoDao.queryList(config.dbtype);
    }
}
