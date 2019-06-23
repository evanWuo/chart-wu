package com.wu.chartwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.wu.chartwu.dao")
public class ChartWuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartWuApplication.class, args);
		System.out.println("sdddddd");
	}

}
