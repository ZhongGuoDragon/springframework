package com.tom.mybatis.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(String.class)
public class MyStringTypeHandler implements TypeHandler<String> {
    private static int count1;
    private static int count2;
    private static int count3;
    private static int count4;

    {
        count1 = count2 = count3 = count4 = 0;
    }

    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        count1++;
        System.out.println("count1=" + count1);
        ps.setString(i, parameter);
    }

    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        count2++;
        System.out.println("count2=" + count2);
        return rs.getString(columnIndex);
    }

    public String getResult(ResultSet rs, String columnName) throws SQLException {
        count3++;
        System.out.println("count3=" + count3);
        System.out.println(rs.getString(columnName));
        return rs.getString(columnName);
    }

    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        count4++;
        System.out.println("count4=" + count4);
        return cs.getString(columnIndex);
    }
}
