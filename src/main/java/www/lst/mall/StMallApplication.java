package www.lst.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("www.lst.mall.dao")
public class StMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(StMallApplication.class, args);
    }

}
