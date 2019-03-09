package com.wu.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestControll {
	private static Logger log = LoggerFactory.getLogger(TestControll.class);
	@GetMapping("/tttttttttttttt")
	public String test(String str) {
		log.info("我是日志："+str);
		return str;
	}
}
