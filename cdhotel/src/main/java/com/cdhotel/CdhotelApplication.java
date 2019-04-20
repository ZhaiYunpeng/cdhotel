package com.cdhotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.cdhotel.mapper"})
public class CdhotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdhotelApplication.class, args);
	}

}
