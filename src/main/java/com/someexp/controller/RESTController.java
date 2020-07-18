package com.someexp.controller;

import com.someexp.exception.UsernameExistsException;
import com.someexp.model.SysUser;
import com.someexp.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/register")
    public String register(SysUser user){
        int result = 0;
        try {
            result = sysUserService.registerNewUserAccount(user);
        } catch (UsernameExistsException usernameExistsException) {
            usernameExistsException.printStackTrace();
            return "fail, username is already exist";
        }
        return result == 1 ? "register success" : "register fail";
    }
}
