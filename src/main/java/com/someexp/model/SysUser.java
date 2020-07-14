package com.someexp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * sys_user
 * @author 
 */
public class SysUser implements Serializable, UserDetails {
    private Integer id;

    private String username;

    private String realname;

    private String password;

    private Date createdate;

    private Date lastlogintime;

    private Boolean enabled;

    private Boolean accountnonexpired;

    private Boolean accountnonlocked;

    private Boolean credentialsnonexpired;

    // 用户所有权限
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountnonexpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountnonlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsnonexpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountnonexpired(Boolean accountnonexpired) {
        this.accountnonexpired = accountnonexpired;
    }

    public void setAccountnonlocked(Boolean accountnonlocked) {
        this.accountnonlocked = accountnonlocked;
    }

    public void setCredentialsnonexpired(Boolean credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}