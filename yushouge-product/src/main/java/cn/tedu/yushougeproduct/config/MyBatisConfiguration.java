package cn.tedu.yushougeproduct.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.yushougeproduct.mapper")
public class MyBatisConfiguration {
}
