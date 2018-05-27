package com.xyz.zf.demo1.dao;

import com.xyz.zf.pojo.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Demo1SysUserDao {
    @Select("select * from sys_user where id = #{id}")
    SysUser getSysUserById(Integer id);
}
