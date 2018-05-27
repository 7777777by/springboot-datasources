package com.xyz.zf.dao;

import com.xyz.zf.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, Integer> {
}
