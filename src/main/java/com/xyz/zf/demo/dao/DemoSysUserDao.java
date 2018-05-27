package com.xyz.zf.demo.dao;

import com.xyz.zf.pojo.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoSysUserDao {
    @Select("select * from sys_user where id = #{id}")
    SysUser getSysUserById(Integer id);
}
