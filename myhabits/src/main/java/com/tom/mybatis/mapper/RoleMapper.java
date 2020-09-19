package com.tom.mybatis.mapper;

import com.tom.mybatis.pojo.Role;
import com.tom.mybatis.pojo.Sex;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface RoleMapper {
//    @Select(value="select id,message as text,time FROM crashcourse.spittles WHERE id=#{id}")
    public Role getRole(Long id);

    public int insertRole(@Param("message") String message, @Param("date")Date date);

    public int deleteRole(String test);

    public int updateRole(@Param("inlong") double inlong, @Param("id") long id);

    public int insertSex(Sex sex);

    public int insertRole2(Role role);

    public int insertRole3(Role role);
}
