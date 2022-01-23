package com.zyj.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }

    /**
     * 数据库连接池
     * HikariProxyConnection@912054991 wrapping com.mysql.cj.jdbc.ConnectionImpl@303c55fa
     *
     * @throws SQLException
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
