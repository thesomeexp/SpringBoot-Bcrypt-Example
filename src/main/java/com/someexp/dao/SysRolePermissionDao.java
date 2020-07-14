package com.someexp.dao;

import com.someexp.model.SysRolePermission;
import com.someexp.model.SysRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionDao {
    long countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);
}