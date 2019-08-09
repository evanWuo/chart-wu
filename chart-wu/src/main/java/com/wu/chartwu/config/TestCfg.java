package com.wu.chartwu.config;

import com.wu.chartwu.controller.Testc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestCfg {
	@Bean
	public Testc testc(){
		return new Testc();
	}
}
