package com.someexp.service;

import com.someexp.model.SysPermission;

import java.util.List;

public interface SysPermissionService {
    List<SysPermission> findAllPermission();
}
