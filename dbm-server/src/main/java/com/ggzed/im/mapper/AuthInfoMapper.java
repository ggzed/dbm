package com.ggzed.im.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ggzed.im.model.entity.AuthInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息DAO.
 *
 * @ClassName UserInfoMapper
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Mapper
public interface AuthInfoMapper extends BaseMapper<AuthInfo> {
}