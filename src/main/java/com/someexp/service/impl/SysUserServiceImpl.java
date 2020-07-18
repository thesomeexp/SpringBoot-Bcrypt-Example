package com.someexp.service.impl;

import com.someexp.dao.SysUserDao;
import com.someexp.exception.UsernameExistsException;
import com.someexp.model.SysPermission;
import com.someexp.model.SysUser;
import com.someexp.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userDetailsService")
public class SysUserServiceImpl implements SysUserService, UserDetailsService {

    @Resource
    SysUserDao sysUserDao;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public int registerNewUserAccount(SysUser user) throws UsernameExistsException {
        if (usernameExist(user.getUsername())) {
            throw new UsernameExistsException("The username is already exist!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Date firstTime = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        user.setCreatedate(firstTime);
        user.setLastlogintime(firstTime);
        user.setEnabled(true);
        user.setAccountnonexpired(true);
        user.setAccountnonlocked(true);
        user.setCredentialsnonexpired(true);
        return sysUserDao.insert(user);
    }

    private boolean usernameExist(String username) {
        return sysUserDao.findUserByUsername(username) == null ? false : true;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser userFromDatabase = sysUserDao.findUserByUsername(s);
        if (userFromDatabase == null)
            throw new UsernameNotFoundException("User" + s + "was not found in database");

        List<SysPermission> permissions = sysUserDao.findPermissionByUsername(s);
        if (permissions != null && permissions.size() > 0) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            permissions.stream().forEach(e -> authorities.add(new SimpleGrantedAuthority(e.getPermtag()))
            );
            userFromDatabase.setAuthorities(authorities);
        }
        return userFromDatabase;
    }
}
