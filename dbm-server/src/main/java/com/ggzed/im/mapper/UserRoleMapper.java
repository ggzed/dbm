package com.ggzed.im.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ggzed.im.model.entity.RoleInfo;
import com.ggzed.im.model.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: ggzed
 * @date: 2024/2/26 16:32
 * @description:
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
