package com.whir;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.whir")
@SpringBootApplication(scanBasePackages="com.whir")
public class WhirApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhirApplication.class, args);
    }

}
