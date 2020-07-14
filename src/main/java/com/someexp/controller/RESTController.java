package com.someexp.controller;

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
        return sysUserService.registerNewUserAccount(user) == 1 ? "success" : "fail";
    }
}
