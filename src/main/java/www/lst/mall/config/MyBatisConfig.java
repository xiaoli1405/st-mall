package www.lst.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/*
* mybatis配置类
* */
@Configuration
@MapperScan("www.lst.mall.mbg.mapper")
public class MyBatisConfig {
}
