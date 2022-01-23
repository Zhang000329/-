package com.zyj.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zyj.store.mapper")
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
//    @Bean
//    public MultipartConfigElement getMultipartConfigElement(){
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
//        factory.setMaxRequestSize(DataSize.of(15,DataUnit.MEGABYTES));
//        return factory.createMultipartConfig();
//    }
}