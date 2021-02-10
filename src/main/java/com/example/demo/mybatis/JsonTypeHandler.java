package com.example.demo.mybatis;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@MappedTypes({JSONObject.class})
public class JsonTypeHandler extends BaseTypeHandler<Object> {

    private static final PGobject jsonObject = new PGobject();

    /**
     * 相当于set方法；将dao中的数据设置到sql对象占位符中；
     *
     * void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;
     *
     * @param preparedStatement
     * @param i
     * @param o
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        jsonObject.setType("jsonb");
        jsonObject.setValue(o.toString());
        preparedStatement.setObject(i, jsonObject);
    }

    /**
     * 相当于get 方法，重查询的结果集中，通过字段名称获取查询的值
     * @param resultSet
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public Map getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return JSONObject.parseObject(resultSet.getString(columnName));
    }


    /**
     * 相当于get 方法，重查询的结果集中，通过字段列下标获取查询的值
     *
     * @param resultSet
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Object getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getString(columnIndex);
    }

    /**
     * 相当于get 方法，重查询的结果集中，通过字段列下标获取查询的值
     *
     * @param callableStatement
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Object getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return callableStatement.getString(columnIndex);
    }
}
