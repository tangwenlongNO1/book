package com.example.test;

import com.example.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * Class name: JdbcUtilsTest
 * Package: com.example.test
 * Description:jdbcutils test
 *
 * @Author: twl
 * @Create-time: 2024/4/19 - 16:50
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for(int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }
    }
}
