package com.xyz.zf.controller;

import com.xyz.zf.pojo.SysUser;
import com.xyz.zf.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/getDemoSysUser")
    public SysUser getDemoSysUser(Integer id) {
        return sysUserService.getDemoUser(id);
    }

    @RequestMapping("/getDemo1SysUser")
    public SysUser getDemo1SysUser(Integer id) {
        return sysUserService.getDemo1User(id);
    }
}
