package com.someexp.service.impl;

import com.someexp.dao.SysPermissionDao;
import com.someexp.model.SysPermission;
import com.someexp.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> findAllPermission() {
        return sysPermissionDao.findAllPermission();
    }
}
