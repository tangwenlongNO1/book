package com.example.dao.impl;

import com.example.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Class name: BaseDao
 * Package: com.example.dao.impl
 * Description:
 *
 * @Author: twl
 * @Create-time: 2024/4/19 - 17:01
 */
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 更新表中数据
     * @param sql
     * @param args
     * @return 返回-1表示插入失败
     */
    public int update(String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 查询数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return 查询到的数据
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 返回结果集
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return 返回结果集
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 返回单值
     * @param sql
     * @param args
     * @return 返回单个查询结果
     */
    public Object queryForSingle(String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
