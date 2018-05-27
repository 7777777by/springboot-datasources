package com.xyz.zf.service.impl;

import com.xyz.zf.dao.SysUserDao;
import com.xyz.zf.demo.dao.DemoSysUserDao;
import com.xyz.zf.demo1.dao.Demo1SysUserDao;
import com.xyz.zf.pojo.SysUser;
import com.xyz.zf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: liuyang
 * @Date: 20180513 17:08
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private DemoSysUserDao demoSysUserDao;
    @Autowired
    private Demo1SysUserDao demo1SysUserDao;

    @Override
    public SysUser getDemoUser(Integer id) {
        return demoSysUserDao.getSysUserById(id);
    }

    @Override
    public SysUser getDemo1User(Integer id) {
        return demo1SysUserDao.getSysUserById(id);
    }
}
