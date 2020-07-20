package com.mcl.cony;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mcl.cony.Mapper")
public class ConyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConyApplication.class, args);
    }

}
