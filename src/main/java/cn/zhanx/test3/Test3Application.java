package cn.zhanx.test3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "cn.zhanx.test3")
@MapperScan("cn.zhanx.test3.mapper")
public class Test3Application {

    public static void main(String[] args) {

        SpringApplication.run(Test3Application.class, args);
        //http://localhost:8080/swagger-ui.html
    }

}
