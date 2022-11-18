package com.ssafy.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.ssafy.home.**.mapper"})
public class SaveHomeBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaveHomeBootApplication.class, args);
	}

}
