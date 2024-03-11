package org.hsbc.penwang.bookprovider;

import org.hsbc.penwang.bookprovider.model.Book;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MappedTypes(Book.class)
@MapperScan("org.hsbc.penwang.bookprovider.mapper")
@EnableEurekaClient
@SpringBootApplication
public class BookProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookProviderApplication.class, args);
    }
}
