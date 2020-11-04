package com.mengxuegu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.mengxuegu.springboot.mapper")
@SpringBootApplication
public class SpringBoot05BillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05BillApplication.class, args);
    }


}

