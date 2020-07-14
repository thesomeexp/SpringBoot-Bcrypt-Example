package com.someexp.service;

import com.someexp.exception.UsernameExistsException;
import com.someexp.model.SysUser;

public interface SysUserService {
    int registerNewUserAccount(SysUser user) throws UsernameExistsException;
}
