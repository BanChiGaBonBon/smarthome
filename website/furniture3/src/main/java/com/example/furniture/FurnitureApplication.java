package com.example.furniture;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
import java.text.SimpleDateFormat;
import java.util.Random;


@SpringBootApplication
//@EnableSwagger2
@MapperScan("com.example.furniture.mapper")
public class FurnitureApplication {
    public static void main(String[] args) {
        SpringApplication.run(FurnitureApplication.class, args);
    }


    @Bean
    public Random creatRandom() {
        return new Random();
    }

    @Bean
    public Gson createGson() {
        return new Gson();
    }

    @Bean
    public SimpleDateFormat createSimpleDateFormat() {
        return new SimpleDateFormat("yyyy_MM_dd");
    }
}
