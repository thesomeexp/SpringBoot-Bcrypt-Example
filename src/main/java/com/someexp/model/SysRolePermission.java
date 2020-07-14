package com.someexp.model;

import java.io.Serializable;

/**
 * sys_role_permission
 * @author 
 */
public class SysRolePermission implements Serializable {
    private Integer roleId;

    private Integer permId;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}