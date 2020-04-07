package com.cinema.tickets_selling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan("com.cinema.tickets_selling.dao")
@SpringBootApplication
public class TicketsSellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketsSellingApplication.class, args);
    }

}
