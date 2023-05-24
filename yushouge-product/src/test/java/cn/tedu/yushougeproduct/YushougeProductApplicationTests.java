package cn.tedu.yushougeproduct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class YushougeProductApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    @Test
    void getConnection() throws Throwable {
        dataSource.getConnection();
        System.out.println("连接数据库成功!");
    }
}
