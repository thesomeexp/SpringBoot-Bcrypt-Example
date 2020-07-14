package com.someexp.dao;

import com.someexp.model.SysPermission;
import com.someexp.model.SysUser;
import com.someexp.model.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserDao {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    // find user by username
    @Select("select * from sys_user where username=#{username}")
    public SysUser findUserByUsername(String username);

    // find permissions by username
    @Select(" select permission.* from sys_user user" + " inner join sys_user_role user_role"
            + " on user.id = user_role.user_id inner join "
            + "sys_role_permission role_permission on user_role.role_id = role_permission.role_id "
            + " inner join sys_permission permission on role_permission.perm_id = permission.id where user.username = #{userName};")
    List<SysPermission> findPermissionByUsername(@Param("userName") String userName);
}