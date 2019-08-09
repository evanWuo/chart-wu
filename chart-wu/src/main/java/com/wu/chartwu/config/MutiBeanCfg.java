package com.wu.chartwu.config;

import com.wu.chartwu.config.FactoryBean.WuFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:properties/muti.properties")
public class MutiBeanCfg {
	@Bean(initMethod = "init",destroyMethod = "destroy")
	public WuFactoryBean wuFactoryBean(){
		WuFactoryBean b = new WuFactoryBean();
		b.setResourse("classpath:properties/muti.properties");
		return b;
	}
}
