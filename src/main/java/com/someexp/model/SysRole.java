package com.someexp.model;

import java.io.Serializable;

/**
 * sys_role
 * @author 
 */
public class SysRole implements Serializable {
    private Integer id;

    private String rolename;

    private String roledesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }
}