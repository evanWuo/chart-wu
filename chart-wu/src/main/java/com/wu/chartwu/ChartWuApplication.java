package com.wu.chartwu;

import com.wu.chartwu.util.OutUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan("com.wu.chartwu.dao")
public class ChartWuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartWuApplication.class, args);
		System.out.println(OutUtil.endOut());
	}

}
