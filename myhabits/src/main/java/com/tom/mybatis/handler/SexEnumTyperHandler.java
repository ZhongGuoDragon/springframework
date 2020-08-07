package com.tom.mybatis.handler;

import com.tom.mybatis.pojo.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexEnumTyperHandler implements TypeHandler<Sex> {
    public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        int id= parameter.getId();
        ps.setInt(i,id);
    }

    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        int integer = rs.getInt(columnName);
        return Sex.getSex(integer);
    }

    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int integer = cs.getInt(columnIndex);
        return Sex.getSex(columnIndex);
    }

    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int integer = rs.getInt(columnIndex);
        return Sex.getSex(columnIndex);
    }
}
